package staticKeyword;

// Static methods cannot be overridden because
// they belong to a class and not to the instance.
public class NoOverrideAllowed extends ExampleClass {
    /* printClassInfo() not allowed to be overridden*/
    // @Override
    // void printClassInfo() {
    // }

    @Override
    void printValue() {
        System.out.println("Value is "+null);
    }

    public static void main(String[] args) {
        NoOverrideAllowed obj = new NoOverrideAllowed();
        obj.printValue();
        // Calling static method using object is discouraged
        obj.printClassInfo();
        ExampleClass.printClassInfo();
        ExampleClass obj2 = new ExampleClass();
        obj2.printValue();
    }
}

class ExampleClass {
    static void printClassInfo() {
        System.out.println("static inside class ExampleClass");
    }
    void printValue() {
        System.out.println("value is "+0);
    }
}