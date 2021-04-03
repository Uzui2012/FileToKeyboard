import java.io.File;
import java.util.Scanner;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.awt.*;

public class FileToKeyboard {
    private static Robot r;
    private static String prefix;
    private static String filename;
    private static String affix;

    private static void robotBoop(String data) throws AWTException{
        //Copies data to clipboard
        StringSelection stringSelection = new StringSelection(data);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection, null);
        //Uses Robot object to paste clipboard content directly to current text window and press the enter key
        r.keyPress(KeyEvent.VK_CONTROL);
        r.keyPress(KeyEvent.VK_V);
        r.delay(10);
        r.keyRelease(KeyEvent.VK_CONTROL);
        r.keyRelease(KeyEvent.VK_V);
        r.delay(10);
        r.keyPress(KeyEvent.VK_ENTER);
        r.delay(10);
        r.keyRelease(KeyEvent.VK_ENTER);
    }
    public static void main(String[] args) {
        //Get file name, any optional prefix and affixes
        try{
            filename = args[0];
        } catch(Exception e){
            System.out.println("Please enter a filepath to access words/phrases you wish to paste");
            System.exit(0);
        }
        try{
            prefix = args[1];
        }catch(Exception e){
            prefix = "";
        }
        try{
            affix = args[2];
        }catch(Exception e){
            affix = "";
        }
        //Create Robot object
        try {
            r = new Robot();
        } catch (AWTException e1) {
            e1.printStackTrace();
            System.exit(0);
        }
        //Little bit of user information
        System.out.println("PLEASE CLICK ON DESIRED OUTPUT AND WAIT 3 SECONDS...");
        r.delay(1000);
        System.out.println("3");
        r.delay(1000);
        System.out.println("2");
        r.delay(1000);
        System.out.println("1");
        r.delay(1000);
        System.out.println("PRINTING...");
        try {
            //Get file text data
            File fn = new File(filename);
            Scanner myReader = new Scanner(fn);
            //For each line perform robot pasting
            while (myReader.hasNextLine()) {
                String data = prefix + myReader.nextLine() + affix;
                try {
                    //Robot paste data method
                    robotBoop(data);
                } catch (AWTException e) {
                    e.printStackTrace();
                }
                r.delay(1000);
            }
            myReader.close();
        } catch (Exception e) {
            System.out.println("An error occurred. Check you entered a correct file path as an argument.");
            e.printStackTrace();
        }
    }
}
