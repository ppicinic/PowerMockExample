package com.nature.pmock;

import static org.junit.Assert.fail;

import org.junit.Test;

public class MockTest{

    @Test
    public void InvalidDate(){
        try {
            // TODO: Use PowerMock to expect getThen() and return an invalid date (a date from over a week ago)
        } catch (RuntimeException re) {
            
        } catch (Exception e){
            System.out.println(e);
            fail();
        }
    }
    
    @Test
    public void InvokeConstructor(){
        try{
            // TODO: Leverage Whitebox to invoke constructor
        } catch(Exception e){
            System.out.println(e);
            fail();
        }
    }
    
    @Test
    public void ExpectExists(){
        try{
            // TODO: Use PowerMock to expect exists() and return false to force the constructor to run.
        } catch(Exception e){
            System.out.println(e);
            fail();
        }
    }
    
    @Test
    public void SetState(){
        try{
            // TODO: Use Whitebox to set date in Then to null
        } catch(Exception e){
            System.out.println(e);
            fail();
        }
    }
    
}