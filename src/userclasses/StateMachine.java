/**
 * Your application code goes here
 */

package userclasses;

import com.codename1.io.CSVParser;
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
        
<<<<<<< HEAD
        
        System.out.println(listOfAgencies.get(0).getIsOpenMonday());    //statement to check if this is accessible
   
=======
<<<<<<< HEAD
        System.out.println(listOfAgencies.get(0).getName());   
=======
        System.out.println(listOfAgencies.get(0).getName());

        
>>>>>>> origin/master
>>>>>>> origin/master
    }


    @Override
    protected void onMain_EnterAction(Component c, ActionEvent event) {
      ComboBox hourSel= (ComboBox) findByName("NumberOfHoursList", c);
      String hourSelect= (String) hourSel.getSelectedItem();
      System.out.println(hourSelect);
    
      
    }
}
