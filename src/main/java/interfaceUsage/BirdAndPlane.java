package interfaceUsage;

public class BirdAndPlane {
    public static void main(String[] args) {
        Penguin peng = new Penguin();
        Sparrow spar = new Sparrow();
        Plane plane = new Plane();

        spar.sleep();
        spar.walk();
        spar.fly();
        System.out.println("---------");
        peng.sleep();
        peng.walk();
        System.out.println("---------");
        plane.fly();
    }
}

class Bird {
    public void sleep() {
        System.out.println("Bird is sleeping");
    }
}

interface CanFly {
    public void fly();
}

interface CanWalk {
    public void walk();
}

class Penguin extends Bird implements CanWalk {
    @Override
    public void walk() {
        System.out.println("Penguin is walking");
    }
}

class Plane implements CanFly {
    @Override
    public void fly() {
        System.out.println("Plane is flying");
    }
}

class Sparrow extends Bird implements CanWalk, CanFly{
    @Override
    public void fly() {
        System.out.println("Sparrow is flying");
    }

    @Override
    public void walk() {
        System.out.println("Sparrow is walking");
    }
}
