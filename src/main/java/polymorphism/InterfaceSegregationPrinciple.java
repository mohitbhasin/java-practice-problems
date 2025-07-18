package polymorphism;

// If some method from parent class is not required in derived class,
// segregate it into an interface.

// Trade-off to this approach is, the object of derived class using interface segregation cannot be created using generic base class.
// Derived class (Sparrow) extends Animal and implements Bird (with fly())
// Animal sparrow = new Sparrow();
// sparrow.fly() is not known to Animal.
// Work around (like sparrow instanceOf Sparrow OR Sparrow sparrow = new Sparrow()) is required.
public class InterfaceSegregationPrinciple {
    public static void main(String[] args) {
        Animal dog = new Dog();
        Animal sparrow = new Sparrow();
        dog.walk();
        // fly() is not needed in dog class;
        dog.fly();

        sparrow.walk();
        sparrow.fly();

        System.out.println("--------------------");
        // Using derived class reference type
        Animal2 dog2 = new Dog2();
        Sparrow2 sparrow2 = new Sparrow2();
        // dog.fly() does not exist.
        dog2.walk();
        sparrow2.walk();
        sparrow2.fly();
        System.out.println("--------------------");
        // using interface as reference type.
        Bird sparrow3 = new Sparrow2();
        sparrow3.fly();
    }
}

class Animal {
    public void walk() {
        System.out.println("Animal is walking");
    }

    public void fly() {
        System.out.println("Animal is Flying");
    }
}

// Dog doesn't need the fly()
// but it will be inherited from Animal class.
class Dog extends Animal {

}

class Sparrow extends Animal {
    public void fly() {
        System.out.println("Sparrow is Flying");
    }
}

// Remove fly() from Animal class and introduce
// an abstract class or interface for it.
abstract class Animal2 {
    public void walk() {
        System.out.println("Animal2 is walking");
    }
}

interface Bird {
    public void fly();
}

class Dog2 extends Animal2 {
    public void walk() {
        System.out.println("Dog is walking");
    }
}

class Sparrow2 extends Animal2 implements Bird {
    @Override
    public void walk() {
        System.out.println("Sparrow is walking");
    }
    @Override
    public void fly() {
        System.out.println("Sparrow is flying");
    }
}

