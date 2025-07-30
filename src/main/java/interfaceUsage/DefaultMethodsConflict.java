package interfaceUsage;

public class DefaultMethodsConflict {
    public static void main(String[] args) {
        //General usage of default method
        ClassB classB = new ClassB();
        classB.foo();
        System.out.println("--------------");
        // Overridden default method to resolve diamond inheritance problem.
        Bar bar = new Bar();
        bar.foo();
    }
}

class ClassB implements A {

}

//-----------------
// What happens if more than one interface are implemented by a class,
// and these interfaces have same default methods names?
// It will not compile and raine an error - unrelated default methods for foo().
// This is because of the diamond problem.
// To resolve it, the methods foo() must be overridden.
interface A {
    default void foo() {
        System.out.println("inside A's foo");
    }
}
interface B {
    default void foo() {
        System.out.println("inside B's foo");
    }
}
class Bar implements A, B {
    @Override
    public void foo() {
        System.out.println("Inside overridden default method from class Bar");
        // If need to use parent implementation, then use 'interface.super.foo()'
        A.super.foo();
        B.super.foo();
    }
}
