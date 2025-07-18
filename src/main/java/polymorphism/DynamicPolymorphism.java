package polymorphism;

// Dynamic Polymorphism - During runtime it is decided which method to run.
public class DynamicPolymorphism {
    public static void main(String[] args) {
        Shape obj1 = new Circle(4);
        Shape obj2 = new Rectangle(5,6);

        // obj1.getArea() will execute getArea() of circle.
        // obj2.getArea() will execute getArea() of rectangle.
        // This will be decided at the runtime.
        obj1.getArea();
        obj2.getArea();

    }
}

