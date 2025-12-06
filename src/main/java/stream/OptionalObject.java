package stream;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

// Optional<T> is a wrapper class that store an object of type T.
// The object my or may not present in it.
// It is used to avoid null values and NullPointerException.
// It is a container for the value which is probably absent or null.
// It is a final class present in java.util.
public class OptionalObject {
    public static void main(String[] args) {
        optionalApplication();
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
            System.out.println("Employee not present");
        }
    }

    public static Employee getEmployee(Integer id) {
        return map.get(id);
    }

    public static Optional<Employee> getOptionalEmployee(Integer id) {
        return Optional.ofNullable(map.get(id));
    }
}
