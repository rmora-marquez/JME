/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jme.lifecycle;

import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.StringItem;
import javax.microedition.midlet.*;

/**
 * @author user10
 */
public class LifeCycleMidlet extends MIDlet implements CommandListener{
    private Form mainForm;
    private Display currentDisplay;
    private Command cmdExit;
    private StringItem msg;
    
    public LifeCycleMidlet(){
        System.out.println("Constructor es llamado");
        mainForm = new Form("Midlet Lifecycle");
        msg = new StringItem(null, "Construyendo Midlet...");
        mainForm.append(msg);
        cmdExit = new Command("Salir", Command.EXIT, 0);
        mainForm.addCommand(cmdExit);
        mainForm.setCommandListener(this);
        currentDisplay = Display.getDisplay(this);
        currentDisplay.setCurrent(mainForm);               
    }
    
    public void startApp() {
        System.out.println("startApp() es llamado");
        msg.setText("Midlet inicializado...");                
    }
    
    public void pauseApp() {
        System.out.println("PauseApp() es llamado");
        msg.setText("Midlet pausado...");
    }
    
    public void destroyApp(boolean unconditional) {
        System.out.println("DestroyApp es llamado");
        msg.setText("Midlet destruido");
    }

    public void commandAction(Command c, Displayable d) {
        if(c == cmdExit){
            destroyApp(true);
            notifyDestroyed();
        }
    }
}
