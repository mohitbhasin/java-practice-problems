package inheritance;

public class Car extends Vehicle{
    int milage;
    public static void main(String[] args) {
        // Case 1: Using default constructor of the car.
        // (default constructor of the Vehicle() must be present)
        Car car1 = new Car();
        car1.printCarInfo();

        System.out.println("-----------");

        // Case 2: Using param constructor for Car for param constructor of Vehicle.
        Car car2 = new Car("ABC Maker", "Red", "C-Type", 2025);
        car2.printCarInfo();
    }

    public Car() {

    }

    public Car(String make, String color, String model, int year) {
        super(make, color, model, year);
        milage = 30;
    }

    public void printCarInfo() {
        super.printDetails();
        System.out.println(milage);
    }
}
