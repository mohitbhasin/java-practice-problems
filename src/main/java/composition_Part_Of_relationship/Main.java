package composition_Part_Of_relationship;
// Composition or Part-Of relationship between Toyota and ToyotaEngine
// lifecycle of Toyota engine depends upon Toyota.

class Car {
    private int id;
    private String model;
    private String color;

    public void carFeatures() {
        System.out.println("Model of the car is: "+model);
        System.out.println("Color of the car is: "+color);
    }
    public void setModel(String model) {
        this.model = model;
    }

    public void setColor(String color) {
        this.color = color;
    }
}

class Toyota extends Car {
    public void setStart() {
        ToyotaEngine engine = new ToyotaEngine();
        engine.start();
    }
}

class ToyotaEngine {
    public void start() {
        System.out.println("Engine Started");
    }
    public void stop() {
        System.out.println("Engine Stopped");
    }
}

class Main {

    public static void main(String[] args) {
        Toyota toy = new Toyota();
        toy.setModel("Camry");
        toy.setColor("Blue");
        toy.carFeatures();
        toy.setStart();
    }

}