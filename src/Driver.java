package src;

/**
 * this class will handle the driver details
 */
public class Driver {  
    //private String name;
    private int age;
    /**
     * @return the age
     */
    public int getAge() {
        return age;
    }
    /**
     * @param age the age to set
     */
    public void setAge(int age) {
        this.age = age;
    }
    /**
     * @param age
     */
    public Driver(int age) {
        this.age = age;
    }
}
