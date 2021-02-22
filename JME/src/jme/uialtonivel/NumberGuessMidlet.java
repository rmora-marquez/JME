
package jme.uialtonivel;

import java.util.Random;
import javax.microedition.lcdui.Alert;
import javax.microedition.lcdui.AlertType;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.TextBox;
import javax.microedition.lcdui.TextField;
import javax.microedition.midlet.*;

/**
 * @author user10
 */
public class NumberGuessMidlet extends MIDlet implements CommandListener{
    private Display currentDisplay;
    private TextBox textBox;
    private Command cmdExit, cmdTry;
    private Alert alerta;
    private Random rand = new Random();
    private int secretNumber;
    private int numTrial = 0;
    private String msgPrompt = "Intente un numero (entre 1 y 100): ";

    public NumberGuessMidlet() {
        textBox = new TextBox("Adivina el numero",msgPrompt, 60, TextField.PLAIN);
        cmdExit = new Command("Salir", Command.EXIT, 2);
        cmdTry = new Command("Pruebale", Command.SCREEN, 1);
        textBox.addCommand(cmdTry);
        textBox.addCommand(cmdExit);
        textBox.setCommandListener(this);
        alerta = new Alert("Resultado","",null, AlertType.INFO);
        secretNumber = rand.nextInt(100);
    }        
    
    public void startApp() {
        currentDisplay = Display.getDisplay(this);
        currentDisplay.setCurrent(textBox);
    }

    public void pauseApp() {
    }

    public void destroyApp(boolean unconditional) {
    }

    public void commandAction(Command c, Displayable d) {
        if(c == cmdTry){
            textBox.delete(0, msgPrompt.length());
            String result = checkNumber( textBox.getString() );
            alerta.setString(result);
            currentDisplay.setCurrent(alerta);
            textBox.setString(msgPrompt);
        }
        if(c == cmdExit){
            destroyApp(true);
            notifyDestroyed();
        }
    }
    
    private String checkNumber(String strNumberIn){
        int number = Integer.parseInt(strNumberIn);
        numTrial++;
        if(number == secretNumber){
            int numTrialSaved = numTrial;
            numTrial = 0;
            secretNumber = rand.nextInt(100);
            return "Felicitaciones\nLo conseguiste en " +
                    numTrialSaved + " intentos";
        }
        if( number > secretNumber){
            return "Intenta un numero menor";
        } else {
            return "Intenta un numero mayor";           
        }        
    }
}
