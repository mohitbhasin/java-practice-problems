package stream;


import java.util.*;
import java.util.stream.Collectors;

// The Collectors.groupBy() groups the elements and returns a Map.
// It is similar to group by clause of SQL
// There are 3 overloaded versions - classifier,
public class GroupingByOperations {
    public static void main(String[] args) {
        groupBy_I();
        groupBy_II();
        groupBy_III();
        groupByConcurrent_I_II_III();
        partitioningBy();
    }
    static List<Employee> employeeList = Employee.getEmployees();

    // Takes one parameter - classifier
    public static void groupBy_I() {
        System.out.println("groupBy(classifier): maps the key(classifier) to the stream's element");
        Map<String, List<Employee>> map = employeeList.stream()
                .collect(Collectors.groupingBy(emp -> emp.department));

        map.entrySet().stream().forEach(System.out::println);
    }

    // Takes two parameters - classifier, collector
    public static void groupBy_II() {
        System.out.println("\ngroupBy(classifier, collector): stores the values in user provided collector");
        Map<String, Long> map = employeeList.stream()
                .collect(Collectors.groupingBy(emp -> emp.department, Collectors.counting()));

        map.entrySet().stream().forEach(System.out::println);

        System.out.println("\ngroupBy(classifier, collector): grouping on multiple conditions - department: salary: count");
        Map<String, Map<Integer, Long>> depAndSalaryGroup = employeeList.stream()
                .collect(Collectors.groupingBy(emp -> emp.department, Collectors.groupingBy(emp -> emp.salary, Collectors.counting())));

        depAndSalaryGroup.entrySet().stream().forEach(System.out::println);

        System.out.println("\ngroupBy(classifier, collector): grouping on multiple conditions - department: salary sum");
        Map<String, Integer> depAndSalarySum = employeeList.stream()
                .collect(Collectors.groupingBy(emp -> emp.department, Collectors.summingInt(emp -> emp.salary)));

        depAndSalarySum.entrySet().stream().forEach(System.out::println);

        System.out.println("\ngroupBy(classifier, collector): grouping on multiple conditions - department: emp with max salary");
        Map<String, Optional<Employee>> depAndSalarySMax = employeeList.stream()
                .collect(Collectors.groupingBy(emp -> emp.department,  Collectors.maxBy((a,b) -> a.salary - b.salary)));
        depAndSalarySMax.entrySet().stream().forEach(System.out::println);
    }

    // Takes three parameters - classifier, Supplier, Collector
    // Supplier is used if we need to provide implementation of a map (TreeMap below).
    public static void groupBy_III() {
        System.out.println("\ngroupBy(classifier, suppler, collector): the supplier is used if we need to provide our own implementation of Map");
        Map<String, Set<Employee>> map = employeeList.stream()
                .limit(5)
                .collect(Collectors.groupingBy(emp -> emp.department, TreeMap::new, Collectors.toSet()));

        map.entrySet().stream().forEach(System.out::println);
    }

    // groupByConcurrent is similar to groupBy(), the only difference is it return ConcurrentMap.
    // It has the same respective 3 overloaded methods.
    public static void groupByConcurrent_I_II_III() {
        System.out.println("\ngroupByConcurrent(classifier): Similar to groupBy(), but return ConcurrentMap");
        Map<String, Long> concurrentMap = employeeList.stream()
                .collect(Collectors.groupingByConcurrent(emp -> emp.department, Collectors.counting()));

        concurrentMap.entrySet().stream().forEach(System.out::println);
    }

    // Collectors.partitioningBy() partitions elements as per the predicate and return Map<Boolean, List<T>>
    public static void partitioningBy() {
        System.out.println("\npartitioningBy(predicate): takes a predicate to partition elements, returns a map");
        Map<Boolean, List<Employee>> partioningMap = employeeList.stream()
                .limit(5)
                .collect(Collectors.partitioningBy(emp -> emp.salary > 2000));

        partioningMap.entrySet().stream().forEach(System.out::println);

        System.out.println("\npartitioningBy(predicate, collector): takes a predicate to partition elements, returns based on collectors");
        Map<Boolean, Long> partitionAndCollectMap = employeeList.stream()
                .collect(Collectors.partitioningBy(emp -> emp.salary > 3000, Collectors.counting()));
        partitionAndCollectMap.entrySet().stream().forEach(System.out::println);
        System.out.println();
    }
}
