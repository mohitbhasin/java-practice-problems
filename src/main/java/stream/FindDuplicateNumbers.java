package stream;

import java.util.*;
import java.util.stream.Collectors;

public class FindDuplicateNumbers {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(4,2,6,7,1,0,4,1,3);

        // Preferred approach
        Set<Integer> duplicate = list.stream().filter(a -> Collections.frequency(list, a)>1).collect(Collectors.toSet());
        System.out.println(duplicate);

        // Using extra set to keep track of nums added.
        Set<Integer> set = new HashSet<>();

        Set<Integer> dupNums = list.stream().filter(a -> !set.add(a)).collect(Collectors.toSet());
        System.out.println(dupNums);
    }
}
