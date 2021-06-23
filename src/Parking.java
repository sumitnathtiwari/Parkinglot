package src;
/**
*This class will handle vehicle number and their slot number
*/

public class Parking {
  private String vehicleNumber;
  private int slotNumber;
  private Driver driver;
/**
 * @param vehicleNumber
 * @param slotNumber
 * @param age
 */
public Parking(String vehicleNumber, int slotNumber, int age) {
    this.vehicleNumber = vehicleNumber;
    this.slotNumber = slotNumber;
    this.driver = new Driver(age);
}
/**
 * @return the driver
 */
public Driver getDriver() {
    return driver;
}
/**
 * @param driver the driver to set
 */
public void setDriver(Driver driver) {
    this.driver = driver;
}
/**
 * @return the vehicleNumber
 */
public String getVehicleNumber() {
    return vehicleNumber;
}
/**
 * @param vehicleNumber the vehicleNumber to set
 */
public void setVehicleNumber(String vehicleNumber) {
    this.vehicleNumber = vehicleNumber;
}
/**
 * @return the slotNumber
 */
public int getSlotNumber() {
    return slotNumber;
}
/**
 * @param slotNumber the slotNumber to set
 */
public void setSlotNumber(int slotNumber) {
    this.slotNumber = slotNumber;
}

}