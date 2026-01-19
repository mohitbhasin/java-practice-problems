package stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Mapping operation transform the elements of a stream and return a new stream.
// There are two common methods of transforming - map() and flatMap()
public class Mapping {
    public static void main(String[] args) {
        usingMap();
        usingMapToInt();
        usingFlatMap();
    }

    // map() take lambda expression as it argument to change every element in the stream.
    // The count of elements, after map() is applied, never changes.
    // map(Function<? super T, ? extends R> mapper)
    // T is the argument type and R is the return type
    public static void usingMap() {
        System.out.println("map() Employee object to Employee name");
        Employee.getEmployeesSublist().stream()
                .map(employee -> employee.name)
                .forEach(System.out::println);
    }

    // If we are dealing with primitives and want the returned stream to be of primitive type,
    // then use the map of respective primitive
    // map() returns Stream<Integer>, mapToInt() return IntStream
    // Similarly there are mapToDouble and mapToLong
    public static void usingMapToInt() {
        System.out.println();
        System.out.println("mapToInt() Employee object to name's length");
        Employee.getEmployeesSublist().stream()
                .mapToInt(employee -> employee.name.length())
                .forEach(len -> System.out.print(len+","));
        System.out.println("\n");
    }

    // flatMap() is used to flatten a stream of multiple collections into a single stream.
    // Convert Stream<String[]> --> flatMap() --> Stream<String>
    // Convert Stream<List<String>> --> flatMap() --> Stream<String>
    // Convert Stream<Set<String>> --> flatMap() --> Stream<String>
    // Why flatMap() is required?
    // Methods like filter(), distinct() expect individual elements in a stream,
    // They cannot work with a collection like List<List<>>
    // similar to mapToInt(), primitive variants are available - flatMapToInt, flatMapToDouble etc.
    public static void usingFlatMap() {
        List<List<String>> list = new ArrayList<>();
        list.add(Arrays.asList("Brad","Alex","Carter","Carl","Ben"));
        list.add(Arrays.asList("Ashu","Cloe","Adam","Alice","Ava"));
        list.add(Arrays.asList("Charan","Betty","Brandon","Casey","Bunty"));
        // List of names starting from 'B' cannot be filtered directly.
        // Need to flatten it into a single stream.
        System.out.println("flatMap() on List<List<String>>:"+list);
        list.stream()
                .flatMap(names -> names.stream())
                .filter(name -> name.startsWith("B"))
                .forEach(name -> System.out.print(name+", "));
        System.out.println("\n");
    }
}
