package edu.ieu.jme;

import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.StringItem;
import javax.microedition.midlet.MIDlet;

/**
 * @author user10
 */
public class HolaMidlet extends MIDlet implements CommandListener{
    private Form mainForm;
    private Display currentDisplay;
    private Command cmdExit;
    
    public void startApp() {
        mainForm = new Form("Hola MIDlet");
        mainForm.append(new StringItem(null, "Hola mi aplicacion MIDlet manual"));
        
        cmdExit = new Command("Salir",Command.EXIT, 0);
        mainForm.addCommand(cmdExit);
        mainForm.setCommandListener(this);
        
        currentDisplay = Display.getDisplay(this);
        currentDisplay.setCurrent(mainForm);               
    }
    
    public void pauseApp() { }
    
    public void destroyApp(boolean unconditional) {  }

    public void commandAction(Command c, Displayable d) {
        if(c == cmdExit){
            destroyApp(true);
            notifyDestroyed();
        }
    }
}
