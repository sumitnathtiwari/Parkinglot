package src;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * this class will handle all the commands functionality
 */
public class Commands {

    /**
     * 
     * @param i
     * @param slots
     * @param minSlotVacant
     * @param ageMap
     * this function will remove the vehicle from the slot
     */

    public static void removeVehicle(int i, List<Parking> slots, PriorityQueue<Integer> minSlotVacant,
            Map<Integer, List<Parking>> ageMap) {

        if(i < 0 || i >= slots.size()) {
            System.err.println("Invalid Slot Number To Leave");
            return;
        }
        if(slots.get(i) != null) {
            // remove the vehicle from the age map
            System.out.println("Slot number" + (i + 1) + " vacated,the car with vehicle registration number "
            + slots.get(i).getVehicleNumber() + " left the space, the driver of the car was of age "
            + slots.get(i).getDriver().getAge());

            ageMap.get(slots.get(i).getDriver().getAge()).remove(slots.get(i));
            // remove the vehicle from the slots
            slots.set(i, null);
            // move the vacant space into heap
            minSlotVacant.add(i);
            // print to user screen
        } else {
            System.err.println("Slot is already Vacant");
        }
    }

    /**
     * 
     * @param vehicleNumber
     * @param slots
     * this function is responsible for returning slot number for vehicle number
     */

    public static void vehicleSlotQuery(String vehicleNumber, List<Parking> slots) {
        //we can optimse this query by using map
        //since using more data structre will just complicate things when need for extension
        //so until time is a constarint we are good to go with O(n) traversal
        boolean vehiclePresent = false;
        for (Parking parking : slots) {
            //since it doesn't mentioned about case senstivity we are ignoring case
            if(parking.getVehicleNumber().equalsIgnoreCase(vehicleNumber)) {
                System.out.println(parking.getSlotNumber() + 1);
                vehiclePresent = true;
                break;
            }
        }
        if(!vehiclePresent) {
            System.err.println("No Vehicle present with given number " + vehicleNumber);
        }
    }

    /**
     * 
     * @param age
     * @param ageMap
     * this function will be responsible for returning vehicles number
     *  by comma seperated for the given age
     */
    public static void ageVehicleNumberQuery(int age, Map<Integer, List<Parking>> ageMap) {
        if(ageMap.get(age) != null) {
            int counter = 0;
            for (Parking vehicle : ageMap.get(age)) {
                System.out.print(vehicle.getVehicleNumber());
                if(++counter != ageMap.get(age).size()) {
                    System.out.print(",");
                }
            }
            System.out.println("");
        } else {
            System.err.println("No vehicle present for the given age");
        }
    }

    /**
     * 
     * @param age
     * @param ageMap
     * this function is responsible for returning slots aquired by the given age
     */

    public static void ageSlotQuery(int age, Map<Integer, List<Parking>> ageMap) {
        int counter = 0;
        if(ageMap.get(age) != null) {
            for (Parking vehicle : ageMap.get(age)) {
                System.out.print(vehicle.getSlotNumber() + 1);
                if(++counter != ageMap.get(age).size()) {
                    System.out.print(",");
                }
            }
            System.out.println("");
        } else {
            System.err.println("No vehicle slot present for the given age");
        }
    }

    /**
     * 
     * @param currentInput
     * @param slots
     * @param minSlotVacant
     * @param ageMap
     * 
     * this function is used for parking the vehicle
     */
    public static void parkVehicle(String[] currentInput, List<Parking> slots, PriorityQueue<Integer> minSlotVacant,
            Map<Integer, List<Parking>> ageMap) {
        if(minSlotVacant.isEmpty()) {
            System.err.println("All Slot full, Please come later");
            return ;
        }
        int age = Integer.parseInt(currentInput[3]);
        int slotNumber = minSlotVacant.poll();
        //park the vehicle
        Parking parkVehicle = new Parking(currentInput[1], 
                slotNumber , age);

        //add it to parked slot
        slots.set(slotNumber,parkVehicle);
        
        if (ageMap.get(age) == null) {
            ageMap.put(age, new ArrayList<>());
        }

        //add it to age map
        ageMap.get(age).add(parkVehicle);
        //print to screen
        System.out.println("Car with vehicle registration number " + 
        parkVehicle.getVehicleNumber() + " has been parked at slot number " 
        + (parkVehicle.getSlotNumber() + 1));
    }

    /**
     * 
     * @param size
     * @param slots
     * @param minSlotVacant
     * this function will initialise the parking space
     */
    public static void initialiseParkingLot(int size, List<Parking> slots, PriorityQueue<Integer> minSlotVacant) {
        if(slots.size() > 0) {
            System.err.println("Parking already Intitalised");
            return;
        }
        for (int i = 0; i < size; i++) {
            slots.add(null);
            minSlotVacant.add(i);
          }
        System.out.println("Created parking of "+ size + " slots");
    }
    
}
