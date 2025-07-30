package interfaceUsage;

// The most important usage of default methods in an interface, is to provide
// additional functionalities without breaking down the classes implementing it.

// Before java 8, if any new methods are added to an interface,
// then all the classes implementing it would break if the implementation is not provided.

public class DefaultMethods {
    public static void main(String[] args) {
        Ride ride = new Ride();
        ride.startEngine();
        ride.hitBrake();
    }
}

class Ride implements Car {
    @Override
    public void hitBrake() {
        System.out.println("Brake is pressed!");
    }
}

interface Car {
    public void hitBrake();

    // default method can be overridden by the implementing class.
    default void startEngine() {
        System.out.println("Engine is running");
    }
}