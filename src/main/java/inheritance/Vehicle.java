package inheritance;

public class Vehicle {
    public String make;
    public String color;
    public String model;
    public int year;

    public Vehicle(String make, String color, String model, int year) {
        this.make = make;
        this.color = color;
        this.model = model;
        this.year = year;
    }

    public Vehicle() {

    }

    public void printDetails() {
        System.out.println("Make: "+this.make);
        System.out.println("Model: "+this.model);
        System.out.println("Year: "+this.year);
        System.out.println("Color: "+this.color);
    }
}
