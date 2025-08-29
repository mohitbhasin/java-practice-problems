package lambdaExpression.functionalInterfaces.consumer;

import stream.Employee;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

// Consumers are functional interfaces that take a parameter and do not return anything.
// They have a abstract method void accept(T t)
// Some examples of consumer interfaces are Consumer<T>, DoubleConsumer, IntConsumer
// LongConsumer, BiConsumer<T, U> etc
public class ConsumerDemo {
    public static void main(String[] args) {
        // Consumer can be any object String, Employee etc.
        Consumer<String> cons_str = a -> System.out.println(a);

        cons_str.accept("Consumer for string");

        // Consumer of Employee object.
        Consumer<List<Employee>> cons_emp = emp_list -> System.out.println("Employee list size: "+emp_list.size());
        cons_emp.accept(Employee.getEmployees());

        // BiConsumer takes two arguments instead of just one.
        BiConsumer<Integer, Integer> bi_cons = (a, b) -> System.out.println(a+" X "+b+" = "+a*b);
        bi_cons.accept(3,5);

        System.out.println();
        // Chaining consumers
        chainingConsumers();
    }

    // Consumer can be chained with another consumer using andThen().
    // Parameter of accept(T) is passed to all the chained consumers
    // They must be of the same type. String with String.
    public static void chainingConsumers() {
        Consumer<String> cons1 = a -> System.out.println(a+" can be chained together using andThen()");

        Consumer<String> cons2 = a -> System.out.println(a+" must be of same type");

        cons1.andThen(cons2).accept("Consumer");
    }
}
