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
    
    public int percentMatch(UserInput userPicks)   
    {
        final int CITY_WEIGHTAGE = 40; //percent weightage
        final int HOURS_WEIGHTAGE = 30;
        final int DAYS_WEIGHTAGE = 30;
        
         int percentMatch = 0;
         if(agencyTarget.equals(userPicks.getUserAreaOfInterest()))
         {
             if(agencyCity.equals(userPicks.getUserCity()))
             {
                 percentMatch = percentMatch + CITY_WEIGHTAGE;
             }
             
             int daysSelected = 0;
             int daysMatched = 0;
             if(userPicks.getUserIsSelectedMonday())
             {
                 daysSelected++;
                 if(isOpenMonday==true)
                 {
                     daysMatched++;
                 }                
             }
            
             if(userPicks.getUserIsSelectedTuesday())
             {
                 daysSelected++;
                 if(isOpenTuesday==true)
                 {
                     daysMatched++;
                 }               
             }
             
             if(userPicks.getUserIsSelectedWednesday())
             {
                 daysSelected++;
                 if(isOpenWednesday==true)
                 {
                     daysMatched++;
                 }                 
             }
             
             if(userPicks.getUserIsSelectedThursday())
             {
                 daysSelected++;
                 if(isOpenThursday==true)
                 {
                     daysMatched++;
                 }                
             }
             
             if(userPicks.getUserIsSelectedFriday())
             {
                 daysSelected++;
                 if(isOpenFriday==true)
                 {
                     daysMatched++;
                 }
             }
             
             if(userPicks.getUserIsSelectedSaturday())
             {
                 daysSelected++;
                 if(isOpenSaturday==true)
                 {
                     daysMatched++;
                 }  
             }
             
             if(userPicks.getUserIsSelectedSunday())
             {
                 daysSelected++;
                 if(isOpenSunday==true)
                 {
                     daysMatched++;
                 }                
             }
             
             if(daysSelected==0){daysSelected=1; daysMatched=1;}
             percentMatch = (int) (percentMatch + (DAYS_WEIGHTAGE*(daysMatched/daysSelected))); //percentMatch increases based on how many days matched out of days selected
             
             double hoursDifference = Math.abs(userPicks.getUserNumberOfHours() - agencyHours);
             percentMatch = (int) (percentMatch + (HOURS_WEIGHTAGE-(12*hoursDifference))); //should be +-<=2.5 hour difference or else the hour match isn't close enough
         }
        return percentMatch;
    }
}
