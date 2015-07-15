/**
 * This class contains generated code from the Codename One Designer, DO NOT MODIFY!
 * This class is designed for subclassing that way the code generator can overwrite it
 * anytime without erasing your changes which should exist in a subclass!
 * For details about this file and how it works please read this blog post:
 * http://codenameone.blogspot.com/2010/10/ui-builder-class-how-to-actually-use.html
*/
package generated;

import com.codename1.ui.*;
import com.codename1.ui.util.*;
import com.codename1.ui.plaf.*;
import java.util.Hashtable;
import com.codename1.ui.events.*;

public abstract class StateMachineBase extends UIBuilder {
    private Container aboutToShowThisContainer;
    /**
     * this method should be used to initialize variables instead of
     * the constructor/class scope to avoid race conditions
     */
    /**
    * @deprecated use the version that accepts a resource as an argument instead
    
**/
    protected void initVars() {}

    protected void initVars(Resources res) {}

    public StateMachineBase(Resources res, String resPath, boolean loadTheme) {
        startApp(res, resPath, loadTheme);
    }

    public Container startApp(Resources res, String resPath, boolean loadTheme) {
        initVars();
        UIBuilder.registerCustomComponent("NumericSpinner", com.codename1.ui.spinner.NumericSpinner.class);
        UIBuilder.registerCustomComponent("Container", com.codename1.ui.Container.class);
        UIBuilder.registerCustomComponent("Form", com.codename1.ui.Form.class);
        UIBuilder.registerCustomComponent("Button", com.codename1.ui.Button.class);
        UIBuilder.registerCustomComponent("CheckBox", com.codename1.ui.CheckBox.class);
        UIBuilder.registerCustomComponent("Label", com.codename1.ui.Label.class);
        UIBuilder.registerCustomComponent("SpanButton", com.codename1.components.SpanButton.class);
        UIBuilder.registerCustomComponent("SpanLabel", com.codename1.components.SpanLabel.class);
        UIBuilder.registerCustomComponent("GenericSpinner", com.codename1.ui.spinner.GenericSpinner.class);
        if(loadTheme) {
            if(res == null) {
                try {
                    if(resPath.endsWith(".res")) {
                        res = Resources.open(resPath);
                        System.out.println("Warning: you should construct the state machine without the .res extension to allow theme overlays");
                    } else {
                        res = Resources.openLayered(resPath);
                    }
                } catch(java.io.IOException err) { err.printStackTrace(); }
            }
            initTheme(res);
        }
        if(res != null) {
            setResourceFilePath(resPath);
            setResourceFile(res);
            initVars(res);
            return showForm(getFirstFormName(), null);
        } else {
            Form f = (Form)createContainer(resPath, getFirstFormName());
            initVars(fetchResourceFile());
            beforeShow(f);
            f.show();
            postShow(f);
            return f;
        }
    }

    protected String getFirstFormName() {
        return "Home Page";
    }

    public Container createWidget(Resources res, String resPath, boolean loadTheme) {
        initVars();
        UIBuilder.registerCustomComponent("NumericSpinner", com.codename1.ui.spinner.NumericSpinner.class);
        UIBuilder.registerCustomComponent("Container", com.codename1.ui.Container.class);
        UIBuilder.registerCustomComponent("Form", com.codename1.ui.Form.class);
        UIBuilder.registerCustomComponent("Button", com.codename1.ui.Button.class);
        UIBuilder.registerCustomComponent("CheckBox", com.codename1.ui.CheckBox.class);
        UIBuilder.registerCustomComponent("Label", com.codename1.ui.Label.class);
        UIBuilder.registerCustomComponent("SpanButton", com.codename1.components.SpanButton.class);
        UIBuilder.registerCustomComponent("SpanLabel", com.codename1.components.SpanLabel.class);
        UIBuilder.registerCustomComponent("GenericSpinner", com.codename1.ui.spinner.GenericSpinner.class);
        if(loadTheme) {
            if(res == null) {
                try {
                    res = Resources.openLayered(resPath);
                } catch(java.io.IOException err) { err.printStackTrace(); }
            }
            initTheme(res);
        }
        return createContainer(resPath, "Home Page");
    }

    protected void initTheme(Resources res) {
            String[] themes = res.getThemeResourceNames();
            if(themes != null && themes.length > 0) {
                UIManager.getInstance().setThemeProps(res.getTheme(themes[0]));
            }
    }

    public StateMachineBase() {
    }

    public StateMachineBase(String resPath) {
        this(null, resPath, true);
    }

    public StateMachineBase(Resources res) {
        this(res, null, true);
    }

    public StateMachineBase(String resPath, boolean loadTheme) {
        this(null, resPath, loadTheme);
    }

    public StateMachineBase(Resources res, boolean loadTheme) {
        this(res, null, loadTheme);
    }

    public com.codename1.ui.Label findCityLabel(Component root) {
        return (com.codename1.ui.Label)findByName("City Label", root);
    }

    public com.codename1.ui.Label findCityLabel() {
        com.codename1.ui.Label cmp = (com.codename1.ui.Label)findByName("City Label", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Label)findByName("City Label", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Label findNumberOfHoursLabel(Component root) {
        return (com.codename1.ui.Label)findByName("Number Of Hours Label", root);
    }

    public com.codename1.ui.Label findNumberOfHoursLabel() {
        com.codename1.ui.Label cmp = (com.codename1.ui.Label)findByName("Number Of Hours Label", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Label)findByName("Number Of Hours Label", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.spinner.NumericSpinner findHourSpinner(Component root) {
        return (com.codename1.ui.spinner.NumericSpinner)findByName("HourSpinner", root);
    }

    public com.codename1.ui.spinner.NumericSpinner findHourSpinner() {
        com.codename1.ui.spinner.NumericSpinner cmp = (com.codename1.ui.spinner.NumericSpinner)findByName("HourSpinner", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.spinner.NumericSpinner)findByName("HourSpinner", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.CheckBox findMonday(Component root) {
        return (com.codename1.ui.CheckBox)findByName("Monday", root);
    }

    public com.codename1.ui.CheckBox findMonday() {
        com.codename1.ui.CheckBox cmp = (com.codename1.ui.CheckBox)findByName("Monday", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.CheckBox)findByName("Monday", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.spinner.GenericSpinner findInterestSpinner(Component root) {
        return (com.codename1.ui.spinner.GenericSpinner)findByName("InterestSpinner", root);
    }

    public com.codename1.ui.spinner.GenericSpinner findInterestSpinner() {
        com.codename1.ui.spinner.GenericSpinner cmp = (com.codename1.ui.spinner.GenericSpinner)findByName("InterestSpinner", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.spinner.GenericSpinner)findByName("InterestSpinner", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.spinner.GenericSpinner findCitySpinner(Component root) {
        return (com.codename1.ui.spinner.GenericSpinner)findByName("CitySpinner", root);
    }

    public com.codename1.ui.spinner.GenericSpinner findCitySpinner() {
        com.codename1.ui.spinner.GenericSpinner cmp = (com.codename1.ui.spinner.GenericSpinner)findByName("CitySpinner", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.spinner.GenericSpinner)findByName("CitySpinner", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Container findContainer4(Component root) {
        return (com.codename1.ui.Container)findByName("Container4", root);
    }

    public com.codename1.ui.Container findContainer4() {
        com.codename1.ui.Container cmp = (com.codename1.ui.Container)findByName("Container4", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Container)findByName("Container4", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Container findContainer1(Component root) {
        return (com.codename1.ui.Container)findByName("Container1", root);
    }

    public com.codename1.ui.Container findContainer1() {
        com.codename1.ui.Container cmp = (com.codename1.ui.Container)findByName("Container1", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Container)findByName("Container1", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.components.SpanLabel findSpanLabel(Component root) {
        return (com.codename1.components.SpanLabel)findByName("SpanLabel", root);
    }

    public com.codename1.components.SpanLabel findSpanLabel() {
        com.codename1.components.SpanLabel cmp = (com.codename1.components.SpanLabel)findByName("SpanLabel", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.components.SpanLabel)findByName("SpanLabel", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Label findAreaOfInterestLabel(Component root) {
        return (com.codename1.ui.Label)findByName("Area Of Interest Label", root);
    }

    public com.codename1.ui.Label findAreaOfInterestLabel() {
        com.codename1.ui.Label cmp = (com.codename1.ui.Label)findByName("Area Of Interest Label", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Label)findByName("Area Of Interest Label", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Container findInformation(Component root) {
        return (com.codename1.ui.Container)findByName("Information", root);
    }

    public com.codename1.ui.Container findInformation() {
        com.codename1.ui.Container cmp = (com.codename1.ui.Container)findByName("Information", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Container)findByName("Information", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.CheckBox findSaturday(Component root) {
        return (com.codename1.ui.CheckBox)findByName("Saturday", root);
    }

    public com.codename1.ui.CheckBox findSaturday() {
        com.codename1.ui.CheckBox cmp = (com.codename1.ui.CheckBox)findByName("Saturday", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.CheckBox)findByName("Saturday", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Container findContainer(Component root) {
        return (com.codename1.ui.Container)findByName("Container", root);
    }

    public com.codename1.ui.Container findContainer() {
        com.codename1.ui.Container cmp = (com.codename1.ui.Container)findByName("Container", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Container)findByName("Container", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.CheckBox findThursday(Component root) {
        return (com.codename1.ui.CheckBox)findByName("Thursday", root);
    }

    public com.codename1.ui.CheckBox findThursday() {
        com.codename1.ui.CheckBox cmp = (com.codename1.ui.CheckBox)findByName("Thursday", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.CheckBox)findByName("Thursday", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Button findButton(Component root) {
        return (com.codename1.ui.Button)findByName("Button", root);
    }

    public com.codename1.ui.Button findButton() {
        com.codename1.ui.Button cmp = (com.codename1.ui.Button)findByName("Button", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Button)findByName("Button", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.CheckBox findFriday(Component root) {
        return (com.codename1.ui.CheckBox)findByName("Friday", root);
    }

    public com.codename1.ui.CheckBox findFriday() {
        com.codename1.ui.CheckBox cmp = (com.codename1.ui.CheckBox)findByName("Friday", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.CheckBox)findByName("Friday", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.CheckBox findSunday(Component root) {
        return (com.codename1.ui.CheckBox)findByName("Sunday", root);
    }

    public com.codename1.ui.CheckBox findSunday() {
        com.codename1.ui.CheckBox cmp = (com.codename1.ui.CheckBox)findByName("Sunday", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.CheckBox)findByName("Sunday", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.CheckBox findWednesday(Component root) {
        return (com.codename1.ui.CheckBox)findByName("Wednesday", root);
    }

    public com.codename1.ui.CheckBox findWednesday() {
        com.codename1.ui.CheckBox cmp = (com.codename1.ui.CheckBox)findByName("Wednesday", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.CheckBox)findByName("Wednesday", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Container findDays(Component root) {
        return (com.codename1.ui.Container)findByName("Days", root);
    }

    public com.codename1.ui.Container findDays() {
        com.codename1.ui.Container cmp = (com.codename1.ui.Container)findByName("Days", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Container)findByName("Days", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.components.SpanButton findEnter(Component root) {
        return (com.codename1.components.SpanButton)findByName("Enter", root);
    }

    public com.codename1.components.SpanButton findEnter() {
        com.codename1.components.SpanButton cmp = (com.codename1.components.SpanButton)findByName("Enter", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.components.SpanButton)findByName("Enter", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.CheckBox findTuesday(Component root) {
        return (com.codename1.ui.CheckBox)findByName("Tuesday", root);
    }

    public com.codename1.ui.CheckBox findTuesday() {
        com.codename1.ui.CheckBox cmp = (com.codename1.ui.CheckBox)findByName("Tuesday", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.CheckBox)findByName("Tuesday", aboutToShowThisContainer);
        }
        return cmp;
    }

    public static final int COMMAND_HomePageStartSearching = 1;

    protected boolean onHomePageStartSearching() {
        return false;
    }

    protected void processCommand(ActionEvent ev, Command cmd) {
        switch(cmd.getId()) {
            case COMMAND_HomePageStartSearching:
                if(onHomePageStartSearching()) {
                    ev.consume();
                    return;
                }
                break;

        }
        if(ev.getComponent() != null) {
            handleComponentAction(ev.getComponent(), ev);
        }
    }

    protected void exitForm(Form f) {
        if("Home Page".equals(f.getName())) {
            exitHomePage(f);
            aboutToShowThisContainer = null;
            return;
        }

        if("Main".equals(f.getName())) {
            exitMain(f);
            aboutToShowThisContainer = null;
            return;
        }

            return;
    }


    protected void exitHomePage(Form f) {
    }


    protected void exitMain(Form f) {
    }

    protected void beforeShow(Form f) {
    aboutToShowThisContainer = f;
        if("Home Page".equals(f.getName())) {
            beforeHomePage(f);
            aboutToShowThisContainer = null;
            return;
        }

        if("Main".equals(f.getName())) {
            beforeMain(f);
            aboutToShowThisContainer = null;
            return;
        }

            return;
    }


    protected void beforeHomePage(Form f) {
    }


    protected void beforeMain(Form f) {
    }

    protected void beforeShowContainer(Container c) {
        aboutToShowThisContainer = c;
        if("Home Page".equals(c.getName())) {
            beforeContainerHomePage(c);
            aboutToShowThisContainer = null;
            return;
        }

        if("Main".equals(c.getName())) {
            beforeContainerMain(c);
            aboutToShowThisContainer = null;
            return;
        }

            return;
    }


    protected void beforeContainerHomePage(Container c) {
    }


    protected void beforeContainerMain(Container c) {
    }

    protected void postShow(Form f) {
        if("Home Page".equals(f.getName())) {
            postHomePage(f);
            aboutToShowThisContainer = null;
            return;
        }

        if("Main".equals(f.getName())) {
            postMain(f);
            aboutToShowThisContainer = null;
            return;
        }

            return;
    }


    protected void postHomePage(Form f) {
    }


    protected void postMain(Form f) {
    }

    protected void postShowContainer(Container c) {
        if("Home Page".equals(c.getName())) {
            postContainerHomePage(c);
            aboutToShowThisContainer = null;
            return;
        }

        if("Main".equals(c.getName())) {
            postContainerMain(c);
            aboutToShowThisContainer = null;
            return;
        }

            return;
    }


    protected void postContainerHomePage(Container c) {
    }


    protected void postContainerMain(Container c) {
    }

    protected void onCreateRoot(String rootName) {
        if("Home Page".equals(rootName)) {
            onCreateHomePage();
            aboutToShowThisContainer = null;
            return;
        }

        if("Main".equals(rootName)) {
            onCreateMain();
            aboutToShowThisContainer = null;
            return;
        }

            return;
    }


    protected void onCreateHomePage() {
    }


    protected void onCreateMain() {
    }

    protected Hashtable getFormState(Form f) {
        Hashtable h = super.getFormState(f);
        if("Home Page".equals(f.getName())) {
            getStateHomePage(f, h);
            aboutToShowThisContainer = null;
            return h;
        }

        if("Main".equals(f.getName())) {
            getStateMain(f, h);
            aboutToShowThisContainer = null;
            return h;
        }

            return h;
    }


    protected void getStateHomePage(Form f, Hashtable h) {
    }


    protected void getStateMain(Form f, Hashtable h) {
    }

    protected void setFormState(Form f, Hashtable state) {
        super.setFormState(f, state);
        if("Home Page".equals(f.getName())) {
            setStateHomePage(f, state);
            aboutToShowThisContainer = null;
            return;
        }

        if("Main".equals(f.getName())) {
            setStateMain(f, state);
            aboutToShowThisContainer = null;
            return;
        }

            return;
    }


    protected void setStateHomePage(Form f, Hashtable state) {
    }


    protected void setStateMain(Form f, Hashtable state) {
    }

    protected void handleComponentAction(Component c, ActionEvent event) {
        Container rootContainerAncestor = getRootAncestor(c);
        if(rootContainerAncestor == null) return;
        String rootContainerName = rootContainerAncestor.getName();
        Container leadParentContainer = c.getParent().getLeadParent();
        if(leadParentContainer != null && leadParentContainer.getClass() != Container.class) {
            c = c.getParent().getLeadParent();
        }
        if(rootContainerName == null) return;
        if(rootContainerName.equals("Home Page")) {
            if("Button".equals(c.getName())) {
                onHomePage_ButtonAction(c, event);
                return;
            }
        }
        if(rootContainerName.equals("Main")) {
            if("Monday".equals(c.getName())) {
                onMain_MondayAction(c, event);
                return;
            }
            if("Tuesday".equals(c.getName())) {
                onMain_TuesdayAction(c, event);
                return;
            }
            if("Wednesday".equals(c.getName())) {
                onMain_WednesdayAction(c, event);
                return;
            }
            if("Thursday".equals(c.getName())) {
                onMain_ThursdayAction(c, event);
                return;
            }
            if("Friday".equals(c.getName())) {
                onMain_FridayAction(c, event);
                return;
            }
            if("Saturday".equals(c.getName())) {
                onMain_SaturdayAction(c, event);
                return;
            }
            if("Sunday".equals(c.getName())) {
                onMain_SundayAction(c, event);
                return;
            }
            if("Enter".equals(c.getName())) {
                onMain_EnterAction(c, event);
                return;
            }
        }
    }

      protected void onHomePage_ButtonAction(Component c, ActionEvent event) {
      }

      protected void onMain_MondayAction(Component c, ActionEvent event) {
      }

      protected void onMain_TuesdayAction(Component c, ActionEvent event) {
      }

      protected void onMain_WednesdayAction(Component c, ActionEvent event) {
      }

      protected void onMain_ThursdayAction(Component c, ActionEvent event) {
      }

      protected void onMain_FridayAction(Component c, ActionEvent event) {
      }

      protected void onMain_SaturdayAction(Component c, ActionEvent event) {
      }

      protected void onMain_SundayAction(Component c, ActionEvent event) {
      }

      protected void onMain_EnterAction(Component c, ActionEvent event) {
      }

}
