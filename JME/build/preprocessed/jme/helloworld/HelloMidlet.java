package jme.helloworld;

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
public class HelloMidlet extends MIDlet implements CommandListener{
    private Form mainForm;
    private Display currentDisplay;
    private Command cmdExit;
    
    public void startApp() {
        mainForm = new Form("HelloMIDlet");
        mainForm.append( new StringItem(null, "Hello world" ) );
        cmdExit = new Command("Exit", Command.EXIT, 0);
        mainForm.addCommand(cmdExit);
        mainForm.setCommandListener(this);
        
        currentDisplay = Display.getDisplay(this);
        currentDisplay.setCurrent(mainForm);        
    }
    
    public void pauseApp() {
    }
    
    public void destroyApp(boolean unconditional) {
    }

    public void commandAction(Command c, Displayable d) {
        if(c == cmdExit){
            destroyApp(true);
            notifyDestroyed();
        }        
    }
}
