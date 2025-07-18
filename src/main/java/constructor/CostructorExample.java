package constructor;

public class CostructorExample {
    public static void main(String[] args) {
        // default constructor required to create no parametrized object.
        // Animal obj = new Animal(); // it will not work
        Animal obj = new Animal("Elephant");
    }
}

class Animal {
    Animal(String name) {
        System.out.println("parameterized: "+name);
    }
}
