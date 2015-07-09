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
    private boolean isOpenMonday;
    private boolean isOpenTuesday;
    private boolean isOpenWednesday;
    private boolean isOpenThursday;
    private boolean isOpenFriday;
    private boolean isOpenSaturday;
    private boolean isOpenSunday;

    public Agency(String name, String city, String target, String phoneNumber, String email, double hours, boolean monday, boolean tuesday, boolean wednesday, boolean thursday, boolean friday, boolean saturday, boolean sunday) {
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
   
    public String getName() 
    {
        return agencyName;
    }
    
    public String getCity() 
    {
        return agencyCity;
    }
    
    public String getTarget() 
    {
        return agencyTarget;
    }
    
    public String getPhoneNumber()  
    {
        return agencyPhoneNumber;
    }
    
    public String getEmail()    {
        return agencyEmail;
    }
    
    public double getHours()    {
        return agencyHours;
    }
    
    public boolean getIsOpenMonday() {
        return isOpenMonday;
    }
    
    public boolean getIsOpenTuesday() {
        return isOpenTuesday;
    }
    
    public boolean getIsOpenWednesday() {
        return isOpenWednesday;
    }
    
    public boolean getIsOpenThursday() {
        return isOpenThursday;
    }
    
    public boolean getIsOpenFriday() {
        return isOpenFriday;
    }
    
    public boolean getIsOpenSaturday() {
        return isOpenSaturday;
    }
    
    public boolean getIsOpenSunday() {
        return isOpenSunday;
    }
    
    public int percentMatch(String userCity,String userTarget, double userHours, boolean userMonday, boolean userTuesday, boolean userWednesday, boolean userThursday, boolean userFriday, boolean userSaturday, boolean userSunday)   
    {
         int percentMatch = 0;
         if(agencyTarget.equals(userTarget))
         {
             if(agencyCity.equals(userCity))
             {
                 percentMatch = percentMatch + 40;
             }
             
             int daysSelected = 0;
             int daysMatched = 0;
             if(userMonday==true)
             {
                 daysSelected++;
                 if(isOpenMonday==true)
                 {
                     daysMatched++;
                 }                
             }
             
             if(userMonday==true)
             {
                 daysSelected++;
                 if(isOpenMonday==true)
                 {
                     daysMatched++;
                 }                
             }
             
             if(userTuesday==true)
             {
                 daysSelected++;
                 if(isOpenTuesday==true)
                 {
                     daysMatched++;
                 }               
             }
             
             if(userWednesday==true)
             {
                 daysSelected++;
                 if(isOpenWednesday==true)
                 {
                     daysMatched++;
                 }                 
             }
             
             if(userThursday==true)
             {
                 daysSelected++;
                 if(isOpenThursday==true)
                 {
                     daysMatched++;
                 }                
             }
             
             if(userFriday==true)
             {
                 daysSelected++;
                 if(isOpenFriday==true)
                 {
                     daysMatched++;
                 }
             }
             
             if(userSaturday==true)
             {
                 daysSelected++;
                 if(isOpenSaturday==true)
                 {
                     daysMatched++;
                 }  
             }
             
             if(userSunday==true)
             {
                 daysSelected++;
                 if(isOpenSunday==true)
                 {
                     daysMatched++;
                 }                
             }
             
             percentMatch = (int) (percentMatch + (daysMatched/daysSelected)); //percentMatch increases based on how many days matched out of days selected
             
             double hoursDifference = Math.abs(userHours - agencyHours);
             percentMatch = (int) (percentMatch + (30-(12*(hoursDifference)))); //should be +-<=2.5 hour difference or else the hour match isn't close enough
             
         }
        return percentMatch;
    }
}
