/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin.ui;

/**
 *
 * @author vijay
 */
public enum Hours {

    first(7, "7 AM"), second(8, "8 AM"),third(9,"9 AM"),fourth(10, "10 AM"),
    fifth(11, "11 AM"),
    sixth(12, "12 NOON"),seventh(1, "1 PM"),eight(2, "2 PM"),ninth(3, "3 PM"),tenth(4, "4 PM"),eleventh(5, "5 PM");
    private int hour;
    private String value;

    public int getHour() {
        return hour;
    }

    public String getValue() {
        return value;
    }

    Hours(int hour, String value) {
        this.hour = hour;
        this.value = value;
    }
    
    public String toString(){
        return value;
    }
}
