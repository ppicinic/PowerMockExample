package com.nature.pmock;

public class WrappedObject {
    
    public static byte getAnInt() {
        
        Integer integer = new Integer(35);
        if (true) {
//            integer.notify();
            return integer.byteValue();
        } else {
            return 1;
        }
            
    }
    
    public static String getString(Integer i) {
        return i.toString();
    }
}