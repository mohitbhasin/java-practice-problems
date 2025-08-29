package lambdaExpression.functionalInterfaces.predicate;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class AND_OR_PredicateDemo {
    public static void main(String[] args) {
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee("Felix", 15, 35));
        employeeList.add(new Employee("Alexa", 43, 46));
        employeeList.add(new Employee("Siri", 23, 29));
        employeeList.add(new Employee("Tom", 8, 55));

        Predicate<Employee> moreThanTwelveMonths = e -> e.monthsOfService > 12;
        Predicate<Employee> ageMoreThanForty = e -> e.age > 40;
        // and() predicate
        Predicate<Employee> accommodationEligible = moreThanTwelveMonths.and(ageMoreThanForty);
        // or() predicate
        Predicate<Employee> wFHEligible = moreThanTwelveMonths.or(ageMoreThanForty);
        for(Employee employee: employeeList) {
            System.out.println(employee.name + " is eligible for accommodation? :" + isEligible(employee, accommodationEligible));
            System.out.println(employee.name + " is WFH eligible? :" + isEligible(employee, wFHEligible));
            System.out.println("-------------------");
        }
        // If there is a need to use two parameters, BiPredicate can be used.
        System.out.println("----------Using BiPredicate--------------------------");
        BiPredicate<Employee, Integer> tenureMoreThanTwelveMonth = (e, m) -> e.monthsOfService > m;
        for(Employee employee: employeeList) {
            System.out.println(employee.name + " tenure is more than 12 months? :" + employeeTenureBiPredicate(employee, 12, tenureMoreThanTwelveMonth));
        }
    }

    public static boolean isEligible(Employee employee, Predicate<Employee> wFHPredicate) {
        return wFHPredicate.test(employee);
    }

    public static boolean employeeTenureBiPredicate(Employee employee, int tenure, BiPredicate<Employee, Integer> biPredicate) {
        return biPredicate.test(employee, tenure);
    }
}

