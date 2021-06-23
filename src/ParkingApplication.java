package src;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * This class will handle our appication I/O
 */
public class ParkingApplication {

    private String filePath;

    /**
     * @param filePath
     */
    public ParkingApplication(String filePath) {
        this.filePath = filePath;
    }

    /**
     * This function will be invoke to start the execution of input file
     */
    public void start() {
        //get input from files
        List<String> inputs = Utils.getInputFromFile(filePath);
        //this will keep track of slots alloted to vehicle i.e. 
        //index will correspond to slot number and it's value will point to a vehicle
        //if value is NULL then it's the vacant space
        List<Parking> slots = new ArrayList<>();
        //hashmap for faster age query
        Map<Integer, List<Parking>> ageMap = new HashMap<>();

        //Minheap inbuilt library in java
        //priorityQueue
        PriorityQueue<Integer> minSlotVacant = new PriorityQueue<Integer>();

        for (String input : inputs) {
            String[] currentInput = input.split(" ");
            if (currentInput.length == 0) {
                System.err.println("Empty Input Provided");
                continue;
            }
            processRawData(currentInput,slots,ageMap,minSlotVacant);
        }
    }

    /**
     * 
     * @param currentInput
     * @param slots
     * @param ageMap
     * @param minSlotVacant
     * this function handle the raw data incoming from input files
     */
    public static void processRawData(String[] currentInput , List<Parking> slots, Map<Integer, List<Parking>> ageMap, PriorityQueue<Integer> minSlotVacant) {
        switch (currentInput[0].toLowerCase()) {
            case "create_parking_lot":
                if(currentInput.length < 2 || currentInput[1].isBlank() || !Utils.isNumeric(currentInput[1])) {
                    System.err.println("Invalid Create Parking Lot Command Please Provide correct Size");
                    break;
                }
                Commands.initialiseParkingLot(Integer.parseInt(currentInput[1]), slots, minSlotVacant);
                break;
            case "park":
                if(slots.isEmpty()) {
                    System.err.println("Please Initialise Parking slot first");
                    break;
                }
                if(currentInput.length < 4 || currentInput[1].isBlank() || !Utils.isNumeric(currentInput[3])) {
                    System.err.println("Invalid Park Command Please Provide correct Input");
                    break;
                }
                Commands.parkVehicle(currentInput, slots, minSlotVacant, ageMap);
                break;

            case "slot_numbers_for_driver_of_age":
                if(currentInput.length < 2 || currentInput[1].isBlank() || !Utils.isNumeric(currentInput[1])) {
                    System.err.println("Invalid slot_numbers_for_driver_of_age Command Please Provide correct age");
                    break;
                }
                Commands.ageSlotQuery(Integer.parseInt(currentInput[1]),ageMap);
                break;

            case "vehicle_registration_number_for_driver_of_age":
                if(currentInput.length < 2 || currentInput[1].isBlank() || !Utils.isNumeric(currentInput[1])) {
                    System.err.println("Invalid vehicle_registration_number_for_driver_of_age Command Please Provide correct age");
                    break;
                }
                Commands.ageVehicleNumberQuery(Integer.parseInt(currentInput[1]),ageMap);
                break;

            case "slot_number_for_car_with_number":
                if(slots.isEmpty()) {
                    System.err.println("Please Initialise Parking slot first");
                    break;
                }
                if(currentInput.length < 2 || currentInput[1].isBlank()) {
                    System.err.println("Invalid slot number for vehicle Command Please Provide correct vehicle number");
                    break;
                }
                Commands.vehicleSlotQuery(currentInput[1], slots);
                break;

            case "leave":
                if(slots.isEmpty()) {
                    System.err.println("Please Initialise Parking slot first");
                    break;
                }
                if(currentInput.length < 2 || currentInput[1].isBlank() || !Utils.isNumeric(currentInput[1])) {
                    System.err.println("Invalid Leave Command Please Provide slot number");
                    break;
                }
                Commands.removeVehicle(Integer.parseInt(currentInput[1]) - 1,slots,minSlotVacant,ageMap);
                break;

            default:
                System.err.println("Invalid Command");
                break;
        }
    }


}
