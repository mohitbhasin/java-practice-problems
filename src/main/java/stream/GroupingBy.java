package stream;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

// There are three groupingBy functions available:
// groupingBy(function)
// groupingBy(function, collector)
// groupingBy(function, supplier, collector)

public class GroupingBy {
    public static void main(String[] args) {
        List<Employee> employeeList = Employee.getEmployees();
        depIdToEmp(employeeList);
        System.out.println("-------------");
        depWithMostEmp(employeeList);
        System.out.println("-------------");
        depWithMostEmpAlternate(employeeList);
    }

    public static void depIdToEmp(List<Employee> employeeList) {
        Map<Integer, List<Employee>> map = employeeList.stream().collect(Collectors.groupingBy(a -> a.dep_id, Collectors.toList()));
        map.forEach((a , b)-> System.out.println(a + ": "+b));
    }

    public static void depWithMostEmp(List<Employee> employeeList) {
        Map<String, List<Employee>> departFrequency = employeeList.stream().collect(Collectors.groupingBy(emp -> emp.department));
        departFrequency.forEach((dep, freq) -> System.out.println(dep+" : "+freq.size()));

        Optional<Map.Entry<String, List<Employee>>> maxDep = departFrequency.entrySet().stream().max((entryA, entryB)-> entryA.getValue().size() - entryB.getValue().size());
        if(maxDep.isPresent()) {
            System.out.println("Dept with most EMP: "+ maxDep.get().getKey());
        }
    }

    public static void depWithMostEmpAlternate(List<Employee> employeeList) {
        Map<String, Long> departFrequency = employeeList.stream().collect(Collectors.groupingBy(emp -> emp.department, Collectors.counting()));
        departFrequency.forEach((dep, freq) -> System.out.println(dep+" : "+freq));

        Optional<Map.Entry<String, Long>> maxDep = departFrequency.entrySet().stream().max((entryA, entryB)-> entryA.getValue().compareTo(entryB.getValue()));
        if(maxDep.isPresent()) {
            System.out.println("Dept with most EMP: "+ maxDep.get().getKey());
        }
    }
}
