package stream;

import java.util.ArrayList;
import java.util.List;

// Filter operation filters the elements based on the predicate and returns a new stream.
// filter() is an intermediate operation in the Stream interface.
// Stream filter(predicate<? super T> predicate)
public class Filtering {
    public static void main(String[] args) {
        example();
        filterWithCustomObjects();
        filterChaining();
    }

    public static void example() {
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<=20; i++) {
            list.add(i);
        }
        list.stream().filter(a -> a%2==0).forEach(even -> System.out.print(even+", "));
        System.out.println();
    }

    public static void filterWithCustomObjects() {
        List<Employee> empList = Employee.getEmployees();
        System.out.print("Employees with salary more than 3000 ----> ");
        empList.stream().filter(emp -> emp.salary>3000).forEach(System.out::print);
        System.out.println();
    }

    public static void filterChaining() {
        List<Employee> employeeList = Employee.getEmployees();
        System.out.println("Filter Chaining: Salary>2000 Dep==201 id>9:");
        employeeList.stream()
                .filter(employee -> employee.salary>2000)
                .filter(employee -> employee.dep_id==201)
                .filter(employee -> employee.id>9)
                .forEach(employee -> System.out.println(employee));
        System.out.println();
    }
}
