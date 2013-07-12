package com.nature.pmock;

import java.util.Date;

public class Then {
    
    private static Date date;
    
    private Then() {
        super();
    }
    
    public static Date getThen() {
        if(date == null){
            date = new Date();
        }
        return date;
    }
}