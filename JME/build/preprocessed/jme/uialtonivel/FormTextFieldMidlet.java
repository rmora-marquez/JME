package jme.uialtonivel;

import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.Item;
import javax.microedition.lcdui.ItemStateListener;
import javax.microedition.lcdui.StringItem;
import javax.microedition.lcdui.TextField;
import javax.microedition.midlet.*;

/**
 * @author user10
 */
public class FormTextFieldMidlet extends MIDlet 
    implements CommandListener, ItemStateListener{
    
    private Form mainForm;
    private TextField tfNum1, tfNum2, tfOper, tfResult;
    private StringItem msg;
    private Command cmdExit, cmdGo;
    private Display currentDisplay;
    
    private double num1 = 1, num2 = 2, result;
    private String oper;

    public FormTextFieldMidlet() {
        mainForm = new Form("Form and TextField-Calculadora App");
        tfNum1 = new TextField("Number 1:", "", 10, TextField.DECIMAL);
        tfNum2 = new TextField("Number 2:", "", 10, TextField.DECIMAL);
        tfOper = new TextField("Operation:", "", 1, TextField.ANY);
        tfResult = new TextField("Result:", "", 10, TextField.DECIMAL);
        msg = new StringItem("Instructions","Type the numbers, set operation 'A' for"
                + " addition, or M for multiplication, then push Go");
        cmdExit = new Command("Exit", Command.EXIT, 2);
        cmdGo = new Command("Go",Command.SCREEN, 1);
        
        mainForm.append(tfNum1);
        mainForm.append(tfNum2);
        mainForm.append(tfOper);
        mainForm.append(tfResult);
        mainForm.append(msg);
        
        mainForm.addCommand(cmdExit);
        mainForm.addCommand(cmdGo);
        mainForm.setCommandListener(this);
        mainForm.setItemStateListener(this);
        currentDisplay = Display.getDisplay(this);
    }      
    
    public void startApp() {
        currentDisplay.setCurrent(mainForm);
    }
    
    public void pauseApp() {
    }
    
    public void destroyApp(boolean unconditional) {
    }

    public void commandAction(Command c, Displayable d) {
       if(c == cmdGo){
           if(oper.equalsIgnoreCase("A")){
               result = num1 + num2;
           }
           if(oper.equalsIgnoreCase("M")){
               result = num1 * num2;
           }
           tfResult.setString( result + "" );
       }
       if(c == cmdExit){
           destroyApp(true);
           notifyDestroyed();
       }
    }

    public void itemStateChanged(Item item) {
        if(item == tfNum1){
            num1 = Double.parseDouble( tfNum1.getString() );
            System.out.println("valor num1 " + num1);
        }
        if(item == tfNum2){
            num2 = Double.parseDouble( tfNum2.getString() );
            System.out.println("valor num2 " + num2);
        }
        if( item == tfOper){
            oper = tfOper.getString();
            System.out.println("oper " + oper);
        }
    }
}
