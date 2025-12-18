package stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

// Reduction operations are terminal that reduces the stream into a single value.
// Key concepts of reduction includes:
// Identity - it's an initial value and/or default value of reduction operation.
// Accumulator - It's a function that takes two parameters.
//      First is the partial result of the reduction operation.
//      Second is next element in the stream.
// Combine - It's a function that combines the partial result when:
//      Reduction is parallelized
//      There's a mismatch b/w types of accumulator arguments and its implementations.
public class MutableReduction {
    public static void main(String[] args) {
        reduceOperation_i();
        reduceOperation_ii();
        reduceOperation_iii();
        reduceBeyondMath();
        findMaxAndMin();
    }

    // The reduce() iteratively applies the accumulator function on th current input.
    // reduce() can used instead of sum() since sum() requires intStream().
    // Optional<T> reduce(BinaryOperator<T> accumulator) - It takes binary operator as input.
    public static void reduceOperation_i() {
        List<Employee> employeeList = Employee.getEmployeesSublist();
        employeeList.stream()
                .map(emp -> emp.salary)
                .reduce((a,b) -> a+b)
                .ifPresent(a -> System.out.println("Total salary of employees is (using reduce()): "+ a));

        double totalSal = employeeList.stream()
                .mapToDouble(emp -> emp.salary)
                .sum();
        System.out.println("Total salary of employees is (using DoubleStream.sum()): "+ totalSal);
    }

    // T reduce(T identity, BinaryOperator<T> accumulator) -
    // It performs reduction with identity as initial value.
    // Since the identity value is the default value if the stream is empty,
    // it doesn't return an optional.
    // The identity value is added to the stream after applying accumulator.
    public static void reduceOperation_ii() {
        List<Integer> list = Arrays.asList(1,2,3,4,5);
        // Identity value will be added to the sum of [1 through 6]
        int result = list.stream()
                .reduce(100, (a,b) -> a+b);
        System.out.println("\nidentity value is applied to the accumulator. If the stream is empty, identity value is returned.");
        System.out.println("identity=100 plus sum(1 to 5): "+result);
    }

    // Three argument reduce() is used in parallel streams.
    // It adds a combiner.
    // When streams are processed in parallel, different chunks of stream
    // are reduced separately and the combiner merges those partial results.
    public static void reduceOperation_iii() {
        List<Integer> list = Arrays.asList(1,2,3,4,5);
        int result = list.stream()
                .reduce(0, (a, b) -> a+b, Integer::sum);
        System.out.println("\nUsing combiner (3 arg reduce()) typically for parallel streams for sum: "+result);
    }

    // Using reduce to find the largest string in the list
    public static void reduceBeyondMath() {
        List<String> list = Arrays.asList("Warner","George","Byrd","Sampson","Snow");
        String result = list.stream()
                .reduce(list.get(0),(a,b) -> a.length()>b.length() ? a : b);
        System.out.println("\nLargest string in the list is: "+result);
        System.out.println();
    }

    // max() and min() are special forms of reduce functions.
    // They take a comparator as parameter and return an Optional.
    public static void findMaxAndMin() {
        List<Integer> list = Arrays.asList(14,2,36,24,5);

        int result = list.stream()
                .max(Comparator.naturalOrder())
                .orElse(0);

        System.out.println("Max numer in the list is : "+result);

        result = list.stream()
                .min(Comparator.naturalOrder())
                .orElse(0);

        System.out.println("Smallest numer in the list is : "+result);
        System.out.println();
    }
}
