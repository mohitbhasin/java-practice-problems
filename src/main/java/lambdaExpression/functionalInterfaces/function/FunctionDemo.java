package lambdaExpression.functionalInterfaces.function;

import java.util.function.Function;
// Function functional interface takes an object of type t and return an object of type R
// Advantage of function is, we can specify the input and output types.
// It is different from Supplier, Consumer and Predicate because:
// - Supplier: doesn't take argument, simply returns the object of the type provided.
// - Consumer: doesn't return any object, just consumes the object of a type.
// - Predicate: returns only boolean value.

// The abstract method used is R apply(T), and return object of type R.

// Function are of different types:
// Function<T,R>, IntFunction<R>, DoubleFunction<R>,ToIntFunction<T>
public class FunctionDemo {
    public static void main(String[] args) {
        Function<String, Integer> str_len = (a) -> a.length();
        System.out.println(str_len.apply("function interface"));
        composeDemo();
    }

    // compose(Function) is used to chain two functions togather.
    // The inner function is applied first and then its output is applied to the outer function.
    // The return type of inner function must match the input type of outer function.
    public static void composeDemo() {
        Function<Integer, Integer> increment = a -> a+1;
        Function<String, Integer>  square = a -> a.length()*a.length();
        System.out.println(increment.compose(square).apply("bob"));
    }
}
