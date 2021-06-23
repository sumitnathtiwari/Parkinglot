package src;
/**
 * This will be our main class
 */
public class Main {
    
    public static void main(String[] args) {
        if(args.length  == 0 || args[0].isEmpty()) {
            System.out.println("File Input is Manadatory");
            throw new NullPointerException("No file Path Provided As Argument");
        }
        String filePath = args[0];
        ParkingApplication app = new ParkingApplication(filePath);
		app.start();
    }
}
