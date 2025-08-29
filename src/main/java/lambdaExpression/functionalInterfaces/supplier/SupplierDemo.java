package lambdaExpression.functionalInterfaces.supplier;
// Supplier functional interface doesn't take any parameter
// but produces a value when get() is called.
// Supplier<T> produces result of reference type T.
// Similarly, there are DoubleSupplier, IntSupplier, LongSupplier and BooleanSupplier
// that produces result of their respective type
// Supplier functional interface is Lazy in nature, while consumer is not.
import java.util.function.Predicate;
import java.util.function.Supplier;

//
public class SupplierDemo {
    public static void main(String[] args) {
        Supplier<Employee> supplier = () -> {
            System.out.println("supplier");
            return new Employee("Allen", 23, 35);
        };
        System.out.println("main");
        Predicate<Employee> eligibilityPredicate = e -> e.monthsOfService > 12;
        System.out.println("Employee benefits availability: "+isEligibleForBenefits(supplier, eligibilityPredicate));
    }

    public static boolean isEligibleForBenefits(Supplier<Employee> supplier, Predicate<Employee> predicate) {
        return predicate.test(supplier.get());
    }
}

class Employee {
    String name;
    int monthsOfService;
    int age;

    Employee(String name, int monthsOfService, int age) {
        this.name = name;
        this.monthsOfService = monthsOfService;
        this.age = age;
    }
}