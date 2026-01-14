package stream;

import java.util.List;
import java.util.Optional;

public class Samples {
    public static void main(String[] args) {

        departmentWithMaxSalary();
        departmentsWithMaxSalary();
    }

    // Returns department having max salary.
    // If multiple departments exists, return the first one seen.
    public static void departmentWithMaxSalary() {
        List<Employee> employees = Employee.getEmployees();

        Optional<Employee> emp = employees.stream()
                .max((a,b) -> a.salary - b.salary);
        if(emp.isPresent()) {
            System.out.println(emp.get().department);
        }

        // ----------- alternate -----------
        employees.stream()
                .max((a,b) -> a.salary - b.salary)
                .ifPresent(e -> System.out.println(e.department));

        // ----------- alternate -----------
        String dep = employees.stream()
                .max((a,b) -> a.salary - b.salary)
                .map(e -> e.department)
                .orElse("No employee present");
        System.out.println(dep);
    }

    // List all the departments having same max salary.
    public static void departmentsWithMaxSalary() {
        List<Employee> employees = Employee.getEmployees();
        double maxSalary = employees.stream()
                .mapToDouble(e -> e.salary)
                .max()
                .orElse(0.0);

        List<String> departments = employees.stream()
                .filter(e -> e.getSal() == maxSalary)
                .map(e -> e.department)
                .distinct()
                .toList();

        System.out.println(departments);
    }
}
