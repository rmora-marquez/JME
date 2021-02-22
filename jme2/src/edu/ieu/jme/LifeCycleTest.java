package edu.ieu.jme;

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
public class LifeCycleTest extends MIDlet implements CommandListener {
    private Form mainForm;
    private Display currentDisplay;
    private Command cmdExit;
    private StringItem msg;

    public LifeCycleTest() {
        System.out.println("Constructor es llamado");
        mainForm = new Form("Midlet LifeCycle Test");
        msg = new StringItem(null,"Construyendo Midlet");
        mainForm.append(msg);
        cmdExit = new Command("Salir", Command.EXIT, 0);
        mainForm.addCommand(cmdExit);
        mainForm.setCommandListener(this);
        currentDisplay = Display.getDisplay(this);
        currentDisplay.setCurrent(mainForm);                
    }    
    
    public void startApp() {
        System.out.println("startApp() fue llamado");
        msg.setText("Midlet iniciado - started");
    }
    
    public void pauseApp() {
        System.out.println("pauseApp() fue llamado");
        msg.setText("Midlet pausado - paused");
    }
    
    public void destroyApp(boolean unconditional) {
        System.out.println("destroyApp() fue llamado");
        msg.setText("Midlet destruido - destroyed");
    }

    public void commandAction(Command c, Displayable d) {
        if(c == cmdExit){
            destroyApp(true);
            notifyDestroyed();
        }
    }
}
