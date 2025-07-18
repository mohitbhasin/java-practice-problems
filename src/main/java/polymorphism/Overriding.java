package polymorphism;

// Polymorphism - Method overriding
public class Overriding {
    public static void main(String[] args) {
        Shape[] shape = new Shape[2];

        shape[0] = new Rectangle(7, 9);
        shape[1] = new Circle(14);

        System.out.println("Area of the Rectangle: " + shape[0].getArea());
        System.out.println("Area of the Circle: " + shape[1].getArea());
    }

}

class Shape {
    public double getArea() {
        return 0;
    }
}

class Rectangle extends Shape {

    private double length;
    private double breadth;

    public Rectangle(double length, double breadth) {
        this.length = length;
        this.breadth = breadth;
    }

    public double getArea() {
        return length * breadth;
    }

}

class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }
    public double getArea() {
        return 3.14 * radius * radius;
    }
}



