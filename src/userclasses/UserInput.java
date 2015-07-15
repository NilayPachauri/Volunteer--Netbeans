/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userclasses;

/**
 *
 * @author Nilay Pachauri, Harshayu Girase, Akash Singhal
 */
public class UserInput {
    private String userCity;
    private String userAreaOfInterest;
    
    private double userNumberOfHours;
    
    private boolean userIsSelectedMonday;
    private boolean userIsSelectedTuesday;
    private boolean userIsSelectedWednesday;
    private boolean userIsSelectedThursday;
    private boolean userIsSelectedFriday;
    private boolean userIsSelectedSaturday;
    private boolean userIsSelectedSunday;
    
    public UserInput(String city, String areaOfInterest, double numberOfHours, boolean isSelectedMonday, boolean isSelectedTuesday, boolean isSelectedWednesday, boolean isSelectedThursday, boolean isSelectedFriday, boolean isSelectedSaturday, boolean isSelectedSunday)    {
        userCity = city;
        userAreaOfInterest = areaOfInterest;
        
        userNumberOfHours = numberOfHours;
        
        userIsSelectedMonday = isSelectedMonday;
        userIsSelectedTuesday = isSelectedTuesday;
        userIsSelectedWednesday = isSelectedWednesday;
        userIsSelectedThursday = isSelectedThursday;
        userIsSelectedFriday = isSelectedFriday;
        userIsSelectedSaturday = isSelectedSaturday;
        userIsSelectedSunday = isSelectedSunday;
    }
    
    public String getUserCity()    {
        return userCity;
    }
    
    public String getUserAreaOfInterest()   {
        return userAreaOfInterest;
    }
    
    public double getUserNumberOfHours()    {
        return userNumberOfHours;
    }
    
    public boolean getUserIsSelectedMonday()    {
        return userIsSelectedMonday;
    }
    
    public boolean getUserIsSelectedTuesday()   {
        return userIsSelectedTuesday;
    }
    
    public boolean getUserIsSelectedWednesday() {
        return userIsSelectedWednesday;
    }
    
    public boolean getUserIsSelectedThursday()  {
        return userIsSelectedThursday;
    }
    
    public boolean getUserIsSelectedFriday()    {
        return userIsSelectedFriday;
    }
    
    public boolean getUserIsSelectedSaturday()  {
        return userIsSelectedSaturday;
    }
    
    public boolean getUserIsSelectedSunday()    {
        return userIsSelectedSunday;
    }
}
