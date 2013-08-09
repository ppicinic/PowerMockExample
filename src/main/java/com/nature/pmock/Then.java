package com.nature.pmock;

import java.util.Date;

public class Then {
    
    private static Date date;
    
    private Then() {
        date = new Date();
    }
    
    public static synchronized Date getThen() {
        if(!exists()){
            new Then();
        }
        return date;
    }
    
    public static boolean exists() {
        return date != null;
    }
}