package stream;

import java.util.List;

// They don't search for an element, They simply find and return and element in the stream.
// They do not take any arguments.
// They are different from matching operations as matching operations return true or false.
// These return the Optional<T> if element is present or return empty Optional
// These operations are typically used with filter().
public class FindingOperations {
    public static void main(String[] args) {
        findFirstOperation();
        findAnyOperation();
    }

    // findFirst() will look for the element and
    // returns first element found of Optional <T> or return empty.
    // Optional<T> findFirst();
    public static void findFirstOperation() {
        List<Employee> list = Employee.getEmployees();
        System.out.println("findFirst() returning first element in the stream");
        list.stream().findFirst().ifPresent(System.out::println);
        System.out.println("\nfindFirst() after filter(), filtering by \"HR\" department and returning first element");
        list.stream().filter(a -> a.department.equals("HR")).findFirst().ifPresent(System.out::println);

    }

    public static void findAnyOperation() {
        List<Employee> list = Employee.getEmployees();
        System.out.println("\nfindAny() also returns some element in the stream like findFirst().");
        System.out.println("However, It is particularly useful in parallel streams");
        System.out.println("\nSimilarly, using findAny() with filter(), filtering by \"TECH\" department and returning any element it finds");
        list.stream().filter(a -> a.department.equals("TECH")).findAny().ifPresent(System.out::println);
        System.out.println();
    }
}
