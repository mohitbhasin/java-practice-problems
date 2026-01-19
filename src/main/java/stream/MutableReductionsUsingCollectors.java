package stream;

// Collectors are terminal operations which are used to perform mutable reduction.
// Unlike reduce() (immutable reduction) which produces a single value,
// mutable reductions collect the results into mutable container objects
// like java.util.Collection or an array.
// There are two overloaded methods of collect():
// - collect(Collector< super T, A, R> collector)
// - R collect(Supplier, BiConsumer<> accumulator, BiConsumer<> combiner)

// collect() takes an instance of Collector as the argument.
// There are two options for a collector
// 1. Implement Collector class
// 2. Use predefined implementations in Collectors final class.

import java.util.*;
import java.util.stream.Collectors;

public class MutableReductionsUsingCollectors {
    public static void main(String[] args) {
        Collectors();
    }

    // Collectors is a final class, meaning it cannot be subclassed and methods remain unaltered.
    // It provides common mutable reductions that can be applied as static methods.
    // Some common collector methods include:
    // toList(), toSet(), toMap(), SummingInt(), reducing(), counting(), groupBy(), joining(), mapping()
    public static void Collectors() {
        List<Employee> employeeList = Employee.getEmployees();
        List<String> employeesInTech = employeeList.stream()
                .filter(emp -> emp.department.equals("TECH"))
                .map(e -> e.name)
                .collect(Collectors.toList());

        System.out.println("Using Collectors.toList(): "+employeesInTech);

        Set<String> departmentSet = employeeList.stream()
                .map(e -> e.department)
                .collect(Collectors.toSet());

        System.out.println("Using Collectors.toSet(): "+departmentSet);

        // Collectors.toCollection(supplier) takes a supplier and stores the values in it.
        // In the below example - supplier is passed as new LinkedList
        LinkedList<String> firstFive = employeeList.stream()
                .map(emp -> emp.name)
                .limit(5)
                .collect(Collectors.toCollection(() -> new LinkedList<>()));

        System.out.println("Using Collectors.toCollections() "+firstFive);

        // Collectors.toMap(keyMapper, valueMapper)
        System.out.println("\nUsing Collectors.toMap() to map employee object to name:department");
        Map<String, String> empMap = employeeList.stream()
                .collect(Collectors.toMap(emp -> emp.name, emp -> emp.department ));
        empMap.entrySet().stream()
                .limit(5)
                .forEach(entry -> System.out.println(entry));

        // If the stream has duplicate values, then toMap() will throw an exception.
        // Below mapping will throw an error because there cannot be duplicate keys.
        System.out.println("\nCollectors.toMap(keyMapper, valueMapper) will throw an exception if there are duplicate keys like below.");
        List<String> numList = Arrays.asList("one", "two", "three", "two", "four", "seventy", "eighty");
        System.out.println(numList);
        //Map<String, Integer> numMap = numList.stream()
        //       .collect(Collectors.toMap(str -> str, str -> str.length()));

        System.out.println("\nTo solve the conflict, overloaded method of toMap(keyMapper, valueMapper, BinaryOperator) can be used.");
        System.out.println("Below example considers the old value and ignores the new value when there is a duplicate");
        Map<String, Integer> numMap = numList.stream()
               .collect(Collectors.toMap(str -> str, str -> str.length(), (v1, v2) -> v1));

        System.out.println(numMap);


        // There is another overloaded method with forth argument,
        // which is used to specify which implementation of map to use.
        System.out.println("\nAnother variation of toMap() provides an extra argument to specify the implementation of map to use \n(TreeMap used below).");
        Map<String, Integer> numTreehMap = numList.stream()
                .collect(Collectors.toMap(str -> str, str -> str.length(), (v1, v2) -> v1, TreeMap::new));
        System.out.println(numTreehMap);

        System.out.println("\nUsing Collectors.collectingAndThen() to apply additional function after collecting.");
        List<String> unmodifiableNameList = employeeList.stream()
                .skip(5)
                .limit(4)
                .map(employee -> employee.name)
                .collect(Collectors.collectingAndThen(Collectors.toList(), list -> Collections.unmodifiableList(list)));

        System.out.println("Collecting to list and then creating unmodifiable list: "+unmodifiableNameList);
        System.out.println();
    }
}
