package com.nature.pmock;

import static org.junit.Assert.fail;

import org.apache.log4j.Logger;
import org.easymock.EasyMock;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.easymock.PowerMock;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest({Integer.class, WrappedObject.class })
@PowerMockIgnore("org.apache.*")
public class MockTest {

    private Logger log = Logger.getLogger(MockTest.class);

    @Test
    public void MockMethodVerification() {
        try {
            // Let PowerMock create a mock. 
            Integer mockObject = PowerMock.createMock(Integer.class, 6);
            
            // Have PowerMock expect the construction of an Integer and return our mock object.
            PowerMock.expectNew(Integer.class, 35).andReturn(mockObject);
            
            // Have EasyMock expect the method we want. We have to force andReturn() or test is inaccurate.
            EasyMock.expect(mockObject.byteValue()).andReturn((byte) 2);
            
            // We need to replay for verifyAll to work
            PowerMock.replayAll();
            
            // Call the method to test
            Byte string = WrappedObject.getAnInt();
            log.info(string);
            
            // Verify the mock and expects. If the expect from EasyMock never happens this test fails.
            PowerMock.verifyAll();
            
        } catch (Exception e) {
            log.fatal(e);
            fail();
        }
    }
}