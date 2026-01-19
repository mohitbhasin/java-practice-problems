package stream;

import java.util.List;

// Matching operations are of terminal type.
// They are used to check if elements with certain criteria are present or not in a stream.
// They are anyMatch(), allMatch(), noneMatch()
public class MatchingOperations {
    public static void main(String[] args) {
        System.out.println("anyMatch(): take a predicate & returns false if no such element or stream is empty, otherwise returns true.");
        List<Employee> list = Employee.getEmployees();
        boolean result = list.stream().anyMatch(a -> a.name.equals("Alex"));
        System.out.println("anyMatch() for Alex: "+result);
        result = list.stream().anyMatch(a -> a.name.equals("Jack"));
        System.out.println("anyMatch() for Jack: "+result);

        System.out.println("\nallMatch(): take a predicate & returns true if all elements match the criteria");
        result = list.stream().allMatch(a -> a.salary>=1000);
        System.out.println("allMatch() - everyone has salary more that equal to 1000? : "+result);
        result = list.stream().allMatch(a -> a.salary>=1001);
        System.out.println("allMatch() - everyone has salary more that equal to 1001? : "+result);

        System.out.println("\nnoneMatch(): take a predicate & returns true no element matches the predicate");
        result = list.stream().noneMatch(a -> a.department.equals("MARKETING"));
        System.out.println("noneMatch() - No employee with department MARKETING? : "+result);
        result = list.stream().noneMatch(a -> a.department.equals("HR"));
        System.out.println("noneMatch() - No employee with department HR? : "+result);
        System.out.println();
    }
}
