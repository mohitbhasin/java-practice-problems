package lambdaExpression.functionalInterfaces.unaryOperator;
import stream.Employee;

import java.util.function.Function;
import java.util.function.UnaryOperator;
// UnaryOperator<T> represents a function that take one arg of type T,
// and returns a value of the same type T.
// It is the similar to Function interface, Function takes <T, R> where R is the return type.
// It is a child of Function interface. It just takes <T> which is also the return its type.
// It does not define a new abstract method.
// It inherits and uses R apply(T) from Function interface.
// It extends Function and set its types as <T,T>,
// This makes return type to be same as the argument type.
public class UnaryOperatorDemo {
    public static void main(String[] args) {
        UnaryOperator<Integer> cube_unary = a -> (int) Math.pow(a, 3);

        // When return type is same as the arg type,
        // instead of using Function<T, T>, simply use UnaryOperator<T>
        Function<Integer, Integer> cube_func = a -> (int) Math.pow(a,3);

        System.out.println(cube_unary.apply(4));
        System.out.println(cube_unary.apply(4));

        // Another example using custom object.
        UnaryOperator<Employee> increment_salary = a -> {
            a.salary+=1;
            return a;
        };

        Employee emp = new Employee(12, "Matt", "Operations", 4, 999);
        System.out.println(emp);
        System.out.println(increment_salary.apply(emp));
    }
}
