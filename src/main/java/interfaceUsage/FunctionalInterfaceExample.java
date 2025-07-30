package interfaceUsage;
// Any interface having only one abstract method, is called functional interface.
// @FunctionalInterface annotation can be applied to the interface,
// so that compiler throws an error when more abstract methods are added.
public class FunctionalInterfaceExample {
    public static void main(String[] args) {
        FunctionalInterfaceExample obj = new FunctionalInterfaceExample();

        // using anonymous class to create object with implementation of the function
        obj.runDoSomething(new Functional() {
            @Override
            public int doSomething(int a, int b) {
                return a-b;
            }
        });

        // using lambda expression to pass implementation of the abstract method in functional interface.
        obj.runDoSomething((a,b) -> a+b);
    }

    public void runDoSomething(Functional f) {
        System.out.println(f.doSomething(2,4));
    }
}
// If using @FunctionalInterface, the interface must
// contain exactly one abstract method.
@FunctionalInterface
interface Functional {
    int doSomething(int a, int b);
}
