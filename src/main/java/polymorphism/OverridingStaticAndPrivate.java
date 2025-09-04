package polymorphism;

public class OverridingStaticAndPrivate {
    public static void main(String[] args) {
        Child child = new Child();
        Child.displayStatic();


    }
}

class Parent {
    public static void displayStatic() {
        System.out.println("Displaying from parent");
    }
    public void concrete() {
        System.out.println("Parent's concrete");
    }
}

class Child extends Parent{
    public static void displayStatic() {
        System.out.println("Displaying from Child");
    }

//    private void concrete() {
//        System.out.println("Parent's concrete");
//    }
}