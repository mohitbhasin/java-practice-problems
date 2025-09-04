package lambdaExpression;
// Lambda expression is used to pass the definition of a function as a parameter,
// when the parameter is a functional interface that corresponds tp the function.
// Therefore, the return type of lambda expression depends on
// the abstract method of the functional interface called.

// The parameter of a function must be a type of functional interface.
// Lambda expression is an improvement over anonymous class
// as javac generates .class file during compilation in the case of anonymous classes.
// For lambda expression, invokedynamic is used at runtime to generate synthetic class.
public class LambdaAndAnonymousClass {
    public static void main(String[] args) {
        // Using Anonymous class to implement multiply function
        Multiplication m = new Multiplication() {
            @Override
            public int multiply(int a, int b) {
                return a*b;
            }
        };
        LambdaAndAnonymousClass obj = new LambdaAndAnonymousClass();
        obj.printProduct(12,3,m);

        // Using lambda expression to implement multiply function.
        obj.printProduct(11,11, (a,b) -> a*b);
    }

    public void printProduct(int a, int b, Multiplication m) {
        System.out.println(m.multiply(a,b));
    }
}

@FunctionalInterface
interface Multiplication {
    int multiply(int a, int b);
}
