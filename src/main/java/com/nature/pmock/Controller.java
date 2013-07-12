package com.nature.pmock;

import java.util.Date;

public class Controller {

    public Date processThen() {
        Date date = Then.getThen();
        if (moreThenAWeek(date, new Date())) {
            throw new RuntimeException("too late");
        }
        return date;
    }
    
    private boolean moreThenAWeek(Date date, Date currentDate){
        long dateTime = date.getTime();
        long currDateTime = currentDate.getTime();
        long difference = dateTime - currDateTime;
        long week = 1000 * 60 * 60 * 24 * 7;
        week = -week;
        if(difference < week){
            return true;
        }
        else{
            return false;
        }
    }
}

