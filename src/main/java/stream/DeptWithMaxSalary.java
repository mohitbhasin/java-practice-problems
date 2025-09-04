package stream;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class DeptWithMaxSalary {
    public static void main(String[] args) {
        List<Employee> employeeList = Employee.getEmployees();
        System.out.println(maxSalaryDept(employeeList));
    }

    public static String maxSalaryDept(List<Employee> employeeList) {
        Map<String, Double> map = employeeList.stream().
                collect(Collectors.groupingBy(a -> a.department, Collectors.summingDouble(a -> a.salary)));

        System.out.println(map);

        return map.entrySet().
                stream().
                max((a,b) -> (int) (a.getValue() - b.getValue())).
                get().
                getKey();
    }
}
