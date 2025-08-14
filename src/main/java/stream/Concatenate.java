package stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Concatenate {
    public static void main(String[] args) {
        List<Employee> employeeList = Employee.getEmployees();
        concatEmpFromDepartments(employeeList);
        System.out.println("-------------------");
        moveZeros();
    }

    public static void concatEmpFromDepartments(List<Employee> employeeList) {
        List<Employee> result = Stream.concat(employeeList.stream().filter(a -> a.department.equals("TECH")),
                employeeList.stream().filter(a -> a.department.equals("HR"))).collect(Collectors.toList());

        System.out.println(result);
    }

    public static void moveZeros() {
        List<Integer> numList = Arrays.asList(4,0,12,-5,0,1,32,0,-1);

        List<Integer> result = Stream.concat(numList.stream().filter(a -> a!=0), numList.stream().filter(a -> a==0)).collect(Collectors.toList());

        System.out.println(result);
    }
}
