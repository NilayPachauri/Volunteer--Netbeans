/**
 * Your application code goes here
 */

package userclasses;

import com.codename1.io.CSVParser;
import com.codename1.ui.CheckBox;
import com.codename1.ui.ComboBox;
import com.codename1.ui.Command;
import com.codename1.ui.Component;
import com.codename1.ui.Display;
import com.codename1.ui.Form;
import com.codename1.ui.events.ActionEvent;
import generated.StateMachineBase;
import com.codename1.ui.util.Resources;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;


/**
 *
 * @author Your name here
 */
public class StateMachine extends StateMachineBase{
    private static ArrayList<String> places =new ArrayList<String>();
    private static ArrayList<String> results =new ArrayList<String>();
    private static ArrayList <Agency> listOfAgencies = new ArrayList <Agency>();
     private static ArrayList <Agency> sortedListOfAgencies = new ArrayList <Agency>();
    
    public StateMachine(String resFile) {
        super(resFile);
        // do not modify, write code in initVars and initialize class members there,
        // the constructor might be invoked too late due to race conditions that might occur
    }
    
    /**
     * this method should be used to initialize variables instead of
     * the constructor/class scope to avoid race conditions
     */
    
    static String[][] data = null;
    
    private static String[][] readFile()   {
        
        InputStream stream = Display.getInstance().getResourceAsStream(Form.class, "/VolData.csv");
        CSVParser parser = new CSVParser();
        
        String[][] data = null;
        
        try {
            data = parser.parse(stream);
        } catch (IOException ex) {
            ex.printStackTrace();
        } 
        
        return data; 
        
    }
    
    public static void sortAgencies(String selectedCity, String selectedAreaOfInterest, double selectedHour, boolean isSelectedMonday, boolean isSelectedTuesday, boolean isSelectedWednesday, boolean isSelectedThursday, boolean isSelectedFriday, boolean isSelectedSaturday, boolean isSelectedSunday)
    {
        int minMatch = 40;
        for(int i=0; i<listOfAgencies.size(); i++)
        {
            if(listOfAgencies.get(i).percentMatch(selectedCity, selectedAreaOfInterest, selectedHour, isSelectedMonday, isSelectedTuesday, isSelectedWednesday, isSelectedThursday, isSelectedFriday, isSelectedSaturday, isSelectedSunday)>minMatch) //CHANGE HOW MUCH U WANT MINIMUM PERCENT MATCH TO BE!
            {
                if(sortedListOfAgencies.size()==0)
                {
                    sortedListOfAgencies.add(listOfAgencies.get(i));
                }
                else if(listOfAgencies.get(i).percentMatch(selectedCity, selectedAreaOfInterest, selectedHour, isSelectedMonday, isSelectedTuesday, isSelectedWednesday, isSelectedThursday, isSelectedFriday, isSelectedSaturday, isSelectedSunday) <= sortedListOfAgencies.get(sortedListOfAgencies.size()-1).percentMatch(selectedCity, selectedAreaOfInterest, selectedHour, isSelectedMonday, isSelectedTuesday, isSelectedWednesday, isSelectedThursday, isSelectedFriday, isSelectedSaturday, isSelectedSunday))
                {
                    sortedListOfAgencies.add(listOfAgencies.get(i));
                    
                }
                else
                {
                    for(int w=0; w<sortedListOfAgencies.size(); w++)
                    {
                        if(listOfAgencies.get(i).percentMatch(selectedCity, selectedAreaOfInterest, selectedHour, isSelectedMonday, isSelectedTuesday, isSelectedWednesday, isSelectedThursday, isSelectedFriday, isSelectedSaturday, isSelectedSunday) > sortedListOfAgencies.get(w).percentMatch(selectedCity, selectedAreaOfInterest, selectedHour, isSelectedMonday, isSelectedTuesday, isSelectedWednesday, isSelectedThursday, isSelectedFriday, isSelectedSaturday, isSelectedSunday))
                        {
                            sortedListOfAgencies.add(w, listOfAgencies.get(i));
                            w=w+100;
                            
                        }
                    }
                }
            }
        }
    }
    
    /**
     *
     * @param res
     */
    @Override
    protected void initVars(Resources res) {
    }
    
    protected void beforeHomePage(Form f) {
        data = readFile();
        
        String name;
        String city;
        String target;
        String phoneNumber;
        String email;
                
        double hours;
                
        boolean monday;
        boolean tuesday;
        boolean wednesday;
        boolean thursday;
        boolean friday;
        boolean saturday;
        boolean sunday;
        
        Agency x= null;
        for (int rows = 1; rows < data.length; rows++)    {
            
            name = data[rows][0];
            city = data[rows][1];
            target = data[rows][2];
            phoneNumber = data[rows][3];
            email = data[rows][4];
            
            hours = Double.parseDouble(data[rows][5]);
            
            monday = Boolean.parseBoolean(data[rows][6]);
            tuesday = Boolean.parseBoolean(data[rows][7]);
            wednesday = Boolean.parseBoolean(data[rows][8]);
            thursday = Boolean.parseBoolean(data[rows][9]);
            friday = Boolean.parseBoolean(data[rows][10]);
            saturday = Boolean.parseBoolean(data[rows][11]);
            sunday = Boolean.parseBoolean(data[rows][12]);
            
            listOfAgencies.add(new Agency(name,city,target,phoneNumber,email,hours,monday,tuesday,wednesday,thursday,friday,saturday,sunday)); 
        }

    }


    @Override
    protected void onMain_EnterAction(Component c, ActionEvent event) {

        ComboBox cityList = (ComboBox) findByName("City List",c);
        String selectedCity = (String) cityList.getSelectedItem();
        
        ComboBox areaOfInterestList = (ComboBox) findByName("Area Of Interest List",c);
        String selectedAreaOfInterest = (String) areaOfInterestList.getSelectedItem();
        
        ComboBox numberOfHoursList= (ComboBox) findByName("NumberOfHoursList",c);
        double selectedHour = Double.parseDouble((String) numberOfHoursList.getSelectedItem());

        CheckBox monday = (CheckBox) findByName("Monday",c);
        boolean isSelectedMonday = monday.isSelected();
        
        CheckBox tuesday = (CheckBox) findByName("Tuesday",c);
        boolean isSelectedTuesday = tuesday.isSelected();
        
        CheckBox wednesday = (CheckBox) findByName("Wednesday",c);
        boolean isSelectedWednesday = wednesday.isSelected();
        
        CheckBox thursday = (CheckBox) findByName("Thursday",c);
        boolean isSelectedThursday = thursday.isSelected();
        
        CheckBox friday = (CheckBox) findByName("Friday",c);
        boolean isSelectedFriday = friday.isSelected();
        
        CheckBox saturday = (CheckBox) findByName("Saturday",c);
        boolean isSelectedSaturday = saturday.isSelected();
        
        CheckBox sunday = (CheckBox) findByName("Sunday",c);
        boolean isSelectedSunday = sunday.isSelected();
                
//        //checking to see if these values are correct
//        
//        System.out.println(selectedCity);
//        System.out.println(selectedAreaOfInterest);
//        System.out.println(selectedHour);
//        System.out.println(isSelectedMonday);
//        System.out.println(isSelectedTuesday);
//        System.out.println(isSelectedWednesday);
//        System.out.println(isSelectedThursday);
//        System.out.println(isSelectedFriday);
//        System.out.println(isSelectedSaturday);
//        System.out.println(isSelectedSunday);
        sortAgencies(selectedCity, selectedAreaOfInterest, selectedHour, isSelectedMonday, isSelectedTuesday, isSelectedWednesday, isSelectedThursday, isSelectedFriday, isSelectedSaturday, isSelectedSunday);
        System.out.println(sortedListOfAgencies.size());
        for(int x=0; x<sortedListOfAgencies.size(); x++)
        {
            System.out.println(sortedListOfAgencies.get(x).getName());
            System.out.println(sortedListOfAgencies.get(x).percentMatch(selectedCity, selectedAreaOfInterest, selectedHour, isSelectedMonday, isSelectedTuesday, isSelectedWednesday, isSelectedThursday, isSelectedFriday, isSelectedSaturday, isSelectedSunday));
            //System.out.println(listOfAgencies.get(x).percentMatch(selectedCity, selectedAreaOfInterest, selectedHour, isSelectedMonday, isSelectedTuesday, isSelectedWednesday, isSelectedThursday, isSelectedFriday, isSelectedSaturday, isSelectedSunday));

        }
    }
}
