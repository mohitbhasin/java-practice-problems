package stream;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamForCustomObjects {
    private static void printDepartment(List<Employee> employeeList) {

        System.out.println(employeeList.stream().collect(Collectors.groupingBy(e -> e.department, Collectors.counting())));
        System.out.println("-------");


        // First group the departments by number of employees.
        // It will create a map with name of department as key and count of occurrences as value
        // TECH: 4, Operations: 7, HR: 3, Finance:6
        Map<String, Long> map = employeeList.stream().collect(Collectors.groupingBy(a -> a.department, Collectors.counting()));
        System.out.println(map);

        // To find the department with the highest value
        Optional<Map.Entry<String, Long>> department = map.entrySet().stream().max(Map.Entry.comparingByValue());
        if(department.isPresent()) {
            System.out.println(department.get().getKey());
        }
        // Alternative approach for finding max department
        String key = map.entrySet().stream().sorted((a,b) -> b.getValue().compareTo(a.getValue())).findFirst().get().getKey();
        System.out.println(key);
    }

    public static void main(String[] args) {
        List<Employee> employeeList = Employee.getEmployees();
        printDepartment(employeeList);
    }
}

