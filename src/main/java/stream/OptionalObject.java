package stream;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Supplier;

// Optional<T> is a wrapper class that store an object of type T.
// The object my or may not present in it.
// It is used to avoid null values and NullPointerException.
// It is a container for the value which is probably absent or null.
// It is a final class present in java.util.
public class OptionalObject {
    public static void main(String[] args) {
        optionalApplication();
        differentWaysOfCreatingOptional();
        additionalFunctions();
    }

    static Map<Integer, Employee> map = new HashMap<>();

    public static void optionalApplication() {
        Employee emp1 = getEmployee(1);
        // emp1 will be null
        System.out.println(emp1);

        // emp2 will be null. It will be of Optional type
        Optional<Employee> emp2 = getOptionalEmployee(1);
        System.out.println(emp2);

        // Check for value if present
        if(emp2.isPresent()) {
            System.out.println(emp2.get());
        } else {
            System.out.println("Optional.isPresent() is false - Employee not present");
        }
    }

    public static void differentWaysOfCreatingOptional() {
        System.out.println("Different ways of creating optional object -->");
        // Empty optional - It will contain a null object.
        Optional<Employee> emptyEmp = Optional.empty();

        Employee employee = new Employee(1, "Bob", "HR", 104, 1000);
        // The optional.of() is used to create an Optional of type T, which cannot be null.
        Optional<Employee> nonEmptyOptional = Optional.of(employee);
        System.out.println("Optional.of() with non-null object: "+nonEmptyOptional);

        // If null is assigned to the of(null), then NullPointerException will be thrown;
        // Optional<Employee> nonEmptyOptionalNull = Optional.of(null);
        System.out.println("Optional.of() with null will throw NullPointerException");

        // Use ofNullable() when not sure if the value is null or not null.
        Optional<Employee> empNotNull = Optional.ofNullable(employee);
        Optional<Employee> empNull = Optional.ofNullable(null);

        System.out.println("Optional.ofNullable(non-null object): "+empNotNull);
        System.out.println("Optional.ofNullable(null): "+empNull);
    }


    private static void additionalFunctions() {
        System.out.println("\nOptional.isPresent(Consumer<T>) - If present then pass a consumer");
        // void isPresent(Consumer<? super T> consumer).
        // It returns nothing and if the value is present then consumer is invoked with the value.
        Optional<Employee> optionalEmp = Optional.of(Employee.getEmployees().get(1));
        optionalEmp.ifPresent(OptionalObject::printSalary);
        optionalEmp.ifPresent(emp -> System.out.println(emp.name+"'s "+emp.salary));
        optionalEmp.ifPresent(System.out::println);

        System.out.println("\nOptional.get() - get() throws NoSuchElementException if value is null. Always use isPresent() when using get()");
        System.out.println(optionalEmp.get());

        System.out.println("\nOptional.orElse(T other) - returns the value if present, otherwise returns the provided value as default");
        Optional<Employee> emptyOptional = Optional.empty();
        System.out.println(emptyOptional.orElse(Employee.getEmployees().get(5)));

        // Similarly, orElseGet(Supplier<? extends T> other) returns the other object,
        // It accepts argument of type Supplier.
        System.out.println("\nOptional.orElseGet(Supplier<? extends T> other) takes argument of type Supplier");
        System.out.println(emptyOptional.orElseGet(() -> Employee.getEmployees().get(9)));

        // Optional.orElseThrow(Supplier<? extends T> other) will throw an Exception if value not available.
        System.out.println("\nOptional.orElseThrow(Supplier<? extends T> other) can throw an Exception if value not present");
        // System.out.println(emptyOptional.orElseThrow(() -> new RuntimeException("emptyOptional object is empty :(")));

        // filter() in the optional checks if the value matches the provided filter condition.
        // It matches the return the value, otherwise return empty optional.
        System.out.println("\nOptional.filter(Predicate< ? super T> predicate) checks if the value matches the condition");
        Optional<String> aliceOptional = Optional.of("Alice");
        System.out.println(aliceOptional.filter(a -> a.startsWith("A")));

        // map() allows to apply mapping function if the value is present.
        // otherwise return empty
        System.out.println("\nOptional.map(Function<? super T, ? extends U> mapper) applies the mapping function");
        System.out.println(optionalEmp.map(a -> a.name.length()));
        System.out.println(emptyOptional.map(a -> a.name.length()));
        optionalEmp
                .map(a -> a.salary)
                .filter(a ->  a>1000)
                .ifPresent(System.out::println);

        // flatMap()
        System.out.println("\nOptional.flatMap()");
        System.out.println("mapping of Optional<Optional<T>> will return an Optional");
        optionalEmp.map(emp -> emp.getSalary()).ifPresent(System.out::println);
        System.out.println("flatMap of Optional<Optional<T>> will return the object of type T");
        optionalEmp.flatMap(emp -> emp.getSalary()).ifPresent(System.out::println);
        System.out.println();
    }

    private static void printSalary(Employee emp) {
        System.out.println(emp.name+"'s department is: "+emp.department);
    }

    private static Employee getEmployee(Integer id) {
        return map.get(id);
    }

    private static Optional<Employee> getOptionalEmployee(Integer id) {
        return Optional.ofNullable(map.get(id));
    }
}
