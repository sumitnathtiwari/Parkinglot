package src;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * this class contains neccessary function related to our program
 */
public class Utils {
    
    /**
     * 
     * @param filePath
     * @return List of input commands seperated by /n(enter)
     */
    public static List<String> getInputFromFile(String filePath) {
        List<String> inputs = new ArrayList<>();
        if(filePath.length() == 0) {
            System.err.println("Please provide input path");
            throw new RuntimeException("File Path Not Provided");
            //return null;
        }
        try (Scanner input = new Scanner(new File(filePath) ) ) {
            //read each new line as string command
            while(input.hasNextLine()) {
                String str = input.nextLine();
                inputs.add(str);
            }
        } catch (FileNotFoundException e) {
            System.err.println("File Not Found");
            throw new RuntimeException("File Not Found");
            //return null;
        }
        return inputs;
    }

    /**
     * check if string is number or not
     * @param strNum
     * @return boolean
     */
    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            Integer d = Integer.parseInt(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

}
