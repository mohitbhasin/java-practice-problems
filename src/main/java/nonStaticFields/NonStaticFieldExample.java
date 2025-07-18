package nonStaticFields;

public class NonStaticFieldExample {
    public static void main(String[] args) {
        Car obj1 = new Car();
        System.out.println("default non-static value of fuel cap:"+obj1.fuelCap);
        System.out.println("default static value of top speed:"+obj1.topSpeed);
        obj1.fuelCap = 10;
        obj1.topSpeed = 150;
        System.out.println("non static field fuel cap changed:"+obj1.fuelCap);
        System.out.println("static field top speed changed:"+obj1.topSpeed);
        Car obj2 = new Car();
        System.out.println("object2 took default fuel cap:"+obj2.fuelCap);
        System.out.println("object2 took updated static fuel cap:"+obj2.topSpeed);
    }
}

class Car {
    int fuelCap = 12;
    static int topSpeed = 200;
}
