package stream;

import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// Collectors class has some methods that help in performing aggregation functions.
// Eg: Sum, Average, Count etc
public class AggregationOperations {
    public static void main(String[] args) {
        counting();
        summingInt();
        averagingInt();
        minBy();
        maxBy();
        summarizingInt();
        joining();
    }
    static List<Employee> list = Employee.getEmployees();
    public static void counting() {
        long count = list.stream()
                .filter(emp -> emp.salary>3000)
                .collect(Collectors.counting());

        System.out.println("collect(Collectors.counting()) - Counting employees having salary more than 3000: "+count);
    }

    public static void summingInt() {
        int idSum = list.stream()
                .collect(Collectors.summingInt(emp -> emp.id));
        System.out.println("collect(Collectors.summingInt()) - sum of employees ids: "+idSum);
    }

    public static void averagingInt() {
        double avgId = list.stream()
                .collect(Collectors.averagingInt(emp -> emp.id));
        System.out.println("collect(Collectors.averagingInt()) - average of employees ids: "+avgId);
    }

    public static void minBy() {
        Optional<Employee> empWithMinSal = list.stream()
                .collect(Collectors.minBy((a,b) -> (int) (a.salary-b.salary)));

        if(empWithMinSal.isPresent()) {
            System.out.println("\ncollect(Collectors.minBy()) - Employee with min salary: "+empWithMinSal.get());
        }
    }

    public static void maxBy() {
        Optional<Employee> empWithMaxSal = list.stream()
                .collect(Collectors.maxBy((a,b) -> (int) (a.salary-b.salary)));

        if(empWithMaxSal.isPresent()) {
            System.out.println("collect(Collectors.maxBy()) - Employee with max salary: "+empWithMaxSal.get());
        }
    }

    public static void summarizingInt() {
        IntSummaryStatistics summary = list.stream()
                .collect(Collectors.summarizingInt(emp -> emp.salary));
        System.out.println("\ncollect(Collectors.summarizingInt()) - Provides summary of salaries: "+summary);

        IntSummaryStatistics summarizingStringNums = Stream.of("1", "2", "3", "70")
                .collect(Collectors.summarizingInt(Integer::parseInt));
        System.out.println("collect(Collectors.summarizingInt()) - Can also take numbers as string: "+summarizingStringNums);
    }

    public static void joining() {
        String joinedString = Stream.of("Good", "Job", "Jayden")
                .collect(Collectors.joining());
        System.out.println("\ncollect(Collectors.joining()) - Appends the elements into a string: "+joinedString);

        joinedString = Stream.of("Happy", "Holidays", "And", "A", "Happy", "New", "Year")
                .collect(Collectors.joining("-"));
        System.out.println("collect(Collectors.joining(\"-\")) - Joining with delimiter: "+joinedString);

        joinedString = Stream.of("Hello", "World")
                .collect(Collectors.joining(" ", "[", "]"));
        System.out.println("collect(Collectors.joining( , prefix, suffix)) - Joining with delimiter, prefix and suffix: "+joinedString);
        System.out.println();
    }
}
