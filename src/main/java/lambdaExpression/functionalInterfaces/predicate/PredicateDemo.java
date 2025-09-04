package lambdaExpression.functionalInterfaces.predicate;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

// Predicate functional interface has one abstract method called boolean Test(T t).
// It evaluates the given input and return true or false.

// Predicate<T> can take any object as its type, evaluates its value and return true or false.
// Similarly, there are other predicates for wrapper classes
// eg. - DoublePredicate, IntPredicate and LongPredicate
// that take their respective data types as arguments.
public class PredicateDemo {
    public static void main(String[] args) {
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee("Felix", 15, 35));
        employeeList.add(new Employee("Alexa", 43, 40));
        employeeList.add(new Employee("Siri", 3, 25));
        employeeList.add(new Employee("Tom", 12, 55));

        // defining predicate
        Predicate<Employee> benefitsEligibilityPredicate = emp -> emp.monthsOfService > 10;

        for(Employee employee: employeeList) {
            System.out.println(employee.name + " is eligible for benefits or not? : " + isEligibleForBenefits(employee, benefitsEligibilityPredicate));
        }
    }

    public static boolean isEligibleForBenefits(Employee employee, Predicate<Employee> predicate) {
        return predicate.test(employee);
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
