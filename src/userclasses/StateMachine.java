/**
 * Your application code goes here
 */

package userclasses;

import com.codename1.components.InfiniteScrollAdapter;
import com.codename1.io.CSVParser;
import com.codename1.ui.CheckBox;
import com.codename1.ui.Component;
import com.codename1.ui.Display;
import com.codename1.ui.Form;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.geom.Dimension;
import com.codename1.ui.spinner.GenericSpinner;
import com.codename1.ui.spinner.NumericSpinner;
import generated.StateMachineBase;
import com.codename1.ui.util.Resources;
import java.io.IOException;
import java.io.InputStream;
import java.util.Vector;
import javafx.scene.control.Spinner;


/**
 *
 * @author Your name here
 */
public class StateMachine extends StateMachineBase{
    private static Vector <Agency> listOfAgencies = new Vector <Agency>();
     private static Vector <Agency> sortedListOfAgencies = new Vector <Agency>();
    
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
    
    public static void addAgencies(UserInput userSelections)    {
        final int MINIMUM_MATCH = 40;
        
        for(int i=0; i<listOfAgencies.size(); i++)
        {
            if (listOfAgencies.get(i).percentMatch(userSelections) > MINIMUM_MATCH) {
                sortedListOfAgencies.add(listOfAgencies.get(i));
            }
        }
    }
    
    public static void shellSortListOfAgencies(UserInput userPreferences) {
	int increment = sortedListOfAgencies.size() / 2;
	while (increment > 0) {
		for (int i = increment; i < sortedListOfAgencies.size(); i++) {
			int j = i;
			Agency temp = sortedListOfAgencies.get(i);
			while (j >= increment && sortedListOfAgencies.get(j - increment).percentMatch(userPreferences) < temp.percentMatch(userPreferences)) {
				sortedListOfAgencies.set(j,sortedListOfAgencies.get(j - increment));
				j = j - increment;
			}
			sortedListOfAgencies.set(j,temp);
		}
		if (increment == 2) {
			increment = 1;
		} else {
			increment *= (5.0 / 11);
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

        GenericSpinner citySpinner = (GenericSpinner) findByName("CitySpinner",c);
        String selectedCity = (String) citySpinner.getValue();
        
        GenericSpinner interestSpinner = (GenericSpinner) findByName("InterestSpinner",c);
        String selectedInterest = (String) interestSpinner.getValue();
       
        NumericSpinner numberOfHoursSpinner = (NumericSpinner) findByName("HourSpinner", c);
        double selectedHour = numberOfHoursSpinner.getValue();

        Dimension size = new Dimension(60,60);
        
        citySpinner.setSize(size);
        interestSpinner.setSize(size);
        numberOfHoursSpinner.setSize(size);


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
        

       
        UserInput userChoices = new UserInput(selectedCity, selectedInterest, selectedHour, isSelectedMonday, isSelectedTuesday, isSelectedWednesday, isSelectedThursday, isSelectedFriday, isSelectedSaturday, isSelectedSunday);


                
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
        addAgencies(userChoices);
        shellSortListOfAgencies(userChoices);
        
        for (int i = 0; i < sortedListOfAgencies.size(); i++)   {
            System.out.println(sortedListOfAgencies.get(i).percentMatch(userChoices));
            System.out.println(sortedListOfAgencies.get(i).getName());
        }
    }

    @Override
    protected void beforeMain(Form f) {
//        Dimension size = new Dimension(200,50);
//        
//        GenericSpinner citySpinner = (GenericSpinner) findByName("CitySpinner",f);
//        citySpinner.setPreferredSize(size);
//         
//        GenericSpinner interestSpinner = (GenericSpinner) findByName("InterestSpinner",f);
//        interestSpinner.setPreferredSize(size);
//                
//        NumericSpinner hourSpinner= (NumericSpinner) findByName("HourSpinner",f);
//        hourSpinner.setPreferredSize(size);
//        
//        f.setScrollableY(true);
//        
//        InfiniteScrollAdapter.createInfiniteScroll(f.getContentPane(), new Runnable()); 
//        
        f.setSmoothScrolling(true);
        


    }
}

