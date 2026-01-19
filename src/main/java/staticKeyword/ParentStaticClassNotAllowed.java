package staticKeyword;

// The parent level class cannot be static because
// static is used to describe a relationship with an enclosing class.
// Therefore, the nested class can be static.
// Example usage is the Builder Design Pattern.
public class ParentStaticClassNotAllowed {
    static class NestedStaticClass {
        void printInfo() {
            System.out.println("Nested static class");
        }
    }

    class NestedRegularClass {
        void printInfo() {
            System.out.println("Nested regular class");
        }
    }

    public static void main(String[] args) {
        // Accessing static nested class requires no object.
        ParentStaticClassNotAllowed.NestedStaticClass staticObj = new ParentStaticClassNotAllowed.NestedStaticClass();
        staticObj.printInfo();

        // Accessing nested regular class requires object.
        ParentStaticClassNotAllowed parentObj = new ParentStaticClassNotAllowed();
        ParentStaticClassNotAllowed.NestedRegularClass innerObj = parentObj.new NestedRegularClass();
        innerObj.printInfo();
    }

}
