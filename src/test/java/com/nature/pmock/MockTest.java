package com.nature.pmock;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;

import java.util.Date;

import org.apache.log4j.Logger;
import org.easymock.EasyMock;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.easymock.PowerMock;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.core.classloader.annotations.PrepareOnlyThisForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.nature.pmock.Controller;
import com.nature.pmock.Then;

@RunWith(PowerMockRunner.class)
@PowerMockIgnore( { "org.apache.*" })
@PrepareOnlyThisForTest( { Then.class })
//@PrepareEverythingForTest 
public class MockTest{

    private Logger log = Logger.getLogger(MockTest.class);
    @Test
    public void ValidDate(){
        try {
//            System.out.println("------------------- ValidDate");
            log.info("------------------- ValidDate");
            PowerMock.mockStatic(Then.class);
            EasyMock.expect(Then.getThen()).andReturn(new Date());
            Controller c = new Controller();
            PowerMock.replayAll();
            Date date = c.processThen();
            assertNotNull(date);
            PowerMock.verifyAll();
        } catch (Exception e){
            System.out.println(e);
            fail();
        }
    }
    
    @Test
    public void InvalidDate(){
        try{
            System.out.println("------------------- InvalidDate");
            PowerMock.mockStatic(Then.class);
            EasyMock.expect(Then.getThen()).andReturn(new Date(1372654800));
            Controller c = new Controller();
            PowerMock.replayAll();
            Date date = c.processThen();
            assertNull(date);
            PowerMock.verifyAll();
        } catch(RuntimeException e) {
            System.out.println(e);
            System.out.println("correct exception recieved");
        } catch(Exception e){
            System.out.println(e);
            fail();
        }
    }
}