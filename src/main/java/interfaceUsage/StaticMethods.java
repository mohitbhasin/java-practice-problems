package interfaceUsage;
// static methods in interfaces example.
// Similar to default methods, but the difference is static methods cannot be overridden.
// (No override for static methods is not exclusive to interface. it applied to all static methods in general)
// If the need is to not allow overriding then static method is used, else use default method.
public class StaticMethods extends ExampleClass implements Ex1 {
    // Any static method from a class or an interface cannot be overridden
//    @Override
//    public void printInfo() {
//    }
//    @Override
//    public void printClassInfo() {
//
//    }
    public static void main(String[] args) {

    }
}

class ExampleClass {
    static void printClassInfo() {
        System.out.println("static inside class ExampleClass");
    }
}

interface Ex1 {
    static void printInfo() {
        System.out.println("static inside interface A");
    }
}

interface Vehicle {
    // static methods do not belong to any instance.
    // They are hidden from the objects of classes implementing the interface.
    static void cleanVehicle(){
        System.out.println("I am cleaning vehicle");
    }
}

class Sedan implements Vehicle {

    public static void main(String args[]){
        Sedan sedan = new Sedan();
        Vehicle.cleanVehicle();
        // static methods hidden from object of Sedan.
        // sedan.cleanVehicle(); // will not compile.

    }
}