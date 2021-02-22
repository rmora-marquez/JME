package edu.ieu.jme;

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
    private TextBox textBox;
    private Command cmdExit, cmdTry;
    private Alert alert;
    private Random rand = new Random();
    private int secretNumber;
    private int intentos = 0;
    private String msgPrompt = "Ingresa tu digito (entre 1 y 99): ";

    public NumberGuessMidlet() {
        textBox = new TextBox("Adivina un numero", msgPrompt, 60, TextField.PLAIN);
        cmdExit = new Command("Salir", Command.EXIT, 1);
        cmdTry = new Command("Intentar",Command.SCREEN , 2);
        textBox.addCommand(cmdExit);
        textBox.addCommand(cmdTry);
        textBox.setCommandListener(this);
        alert = new Alert("Resultado:", "", null, AlertType.CONFIRMATION);
        secretNumber = rand.nextInt(100);
    }      
    
    public void startApp() {
        Display.getDisplay(this).setCurrent(textBox);
    }
    
    public void pauseApp() {
    }
    
    public void destroyApp(boolean unconditional) {
    }

    public void commandAction(Command c, Displayable d) {
        System.out.println("comando " + c.getLongLabel());
        if(c == cmdTry){
            textBox.delete(0, msgPrompt.length());
            alert.setString( checkNumber( textBox.getString() )  );
            Display.getDisplay(this).setCurrent(alert);
            textBox.setString(msgPrompt);
        } else if( c == cmdExit) {
            destroyApp(true);
            notifyDestroyed();
        }        
    }
    
    private String checkNumber(String strNumberIn){
        int numberIn = Integer.parseInt(strNumberIn);
        intentos++;
        if(numberIn == secretNumber){
            int intentosGuardados = intentos;
            intentos = 0;
            secretNumber = rand.nextInt(100);
            return "Felicitaciones\nTu lo lograste en " + intentosGuardados + " intentos";
        } else if (numberIn > secretNumber){
            return "Intenta uno menor";
        }else{
            return "Intenta uno mayor";
        }
    }
}
