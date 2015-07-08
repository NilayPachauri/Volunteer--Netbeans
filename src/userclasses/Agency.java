/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userclasses;

/**
 *
 * @author Nilay Pachauri
 */
public class Agency {
    
    private String agencyName;  //name of the agency
    private String agencyCity;  //city in which the agency is located
    private String agencyTarget;    //the area with which the area works with
    private String agencyPhoneNumber;   //the phone number to contact the agency
    private String agencyEmail; //the email to contact the agency

    private double agencyHours;    //hours which the agency works per day

    //what days the agency is open
    private String isOpenMonday;
    private String isOpenTuesday;
    private String isOpenWednesday;
    private String isOpenThursday;
    private String isOpenFriday;
    private String isOpenSaturday;
    private String isOpenSunday;

    public Agency(String name, String city, String target, String phoneNumber, String email, double hours, String monday, String tuesday, String wednesday, String thursday, String friday, String saturday, String sunday) {
        agencyName = name;
        agencyCity = city;
        agencyTarget = target;
        agencyPhoneNumber = phoneNumber;
        agencyEmail = email;
        
        agencyHours = hours;
        
        isOpenMonday = monday;
        isOpenTuesday = tuesday;
        isOpenWednesday = wednesday;
        isOpenThursday = thursday;
        isOpenFriday = friday;
        isOpenSaturday = saturday;
        isOpenSunday = sunday;
    }
    
    private int percentMatch(String city,String target, double hours, String monday, String tuesday, String wednesday, String thursday, String friday, String saturday, String sunday)   {
        
        return 0;
        
    }
    
    public String getName() {
        return agencyName;
    }
    
    public String getCity() {
        return agencyCity;
    }
    
    public String getTarget() {
        return agencyTarget;
    }
    
    public String getPhoneNumber()  {
        return agencyPhoneNumber;
    }
    
    public String getEmail()    {
        return agencyEmail;
    }
    
    public double getHours()    {
        return agencyHours;
    }
    
    public String getIsOpenMonday() {
        return isOpenMonday;
    }
    
    public String getIsOpenTuesday() {
        return isOpenTuesday;
    }
    
    public String getIsOpenWednesday() {
        return isOpenWednesday;
    }
    
    public String getIsOpenThursday() {
        return isOpenThursday;
    }
    
    public String getIsOpenFriday() {
        return isOpenFriday;
    }
    
    public String getIsOpenSaturday() {
        return isOpenSaturday;
    }
    
    public String getIsOpenSunday() {
        return isOpenSunday;
    }
}
