
package edu.ieu.jme;

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
    private TextField tfNum1,tfNum2, tfOper, tfResult;
    private StringItem msg;
    private double num1, num2, result;
    private String oper;
    private Command cmdExit, cmdGo;

    public FormTextFieldMidlet() {
        mainForm = new Form("Form y TextField");
        tfNum1 = new TextField("Numero 1:", "", 10, TextField.DECIMAL);
        tfNum2 = new TextField("numero 2:", "", 10, TextField.DECIMAL);
        tfOper = new TextField("Operación:", "", 1, TextField.ANY);
        tfResult = new TextField("Resultado:", "", 10, TextField.DECIMAL);
        msg = new StringItem("","Escribe los numeros, y la operacion 'A' para sumar,"
                + " o 'M' para multiplicar, y 'GO'."  );
        
        mainForm.append(tfNum1);
        mainForm.append(tfNum2);
        mainForm.append(tfOper);
        mainForm.append(tfResult);
        mainForm.append(msg);
        
        cmdExit = new Command("Salir", Command.EXIT, 2);
        cmdGo = new Command("Go", Command.SCREEN, 1);
        mainForm.addCommand(cmdExit);
        mainForm.addCommand(cmdGo);
        mainForm.setCommandListener(this);
        mainForm.setItemStateListener(this);
    }        
    
    public void startApp() {
        Display.getDisplay(this).setCurrent(mainForm);
    }
    
    public void pauseApp() {
    }
    
    public void destroyApp(boolean unconditional) {
    }

    public void commandAction(Command c, Displayable d) {
        if(c == cmdGo){
            if(oper.equalsIgnoreCase("A")){
                result = num1 + num2;
            }else if( oper.equalsIgnoreCase("M")){
                result = num1 * num2;
            }
            tfResult.setString(result + "");
        } else if (c == cmdExit){
            destroyApp(true);
            notifyDestroyed();
        }
    }

    public void itemStateChanged(Item item) {
        if(item == tfNum1){
            num1 = Double.parseDouble( tfNum1.getString() );
        }
        if(item == tfNum2){
            num2 = Double.parseDouble( tfNum2.getString() );
        }
        if(item == tfOper){
            oper = tfOper.getString();
        }
    }
}
