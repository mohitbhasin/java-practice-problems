package stream;

import java.util.Arrays;
import java.util.List;

public class StreamExamples {
    public static void main(String[] args) {
        // Intermediate operations: filter(), map(), sorted()
        // Terminal operations: toList(), forEach(), collect()
        List<String> list = Arrays.asList("USA", "India", "Canada", "Australia", "UK", "Africa");
        List<String> output1 = list.stream().filter(a -> a.startsWith("U")).toList();
        System.out.println(output1);

        List<String> output2 = list.stream().filter(name -> name.toLowerCase().startsWith("a")).toList();
        System.out.println(output2);

        // Map: mapping every object to a function?? maybe
        List<String> output3 = list.stream().map(String::toLowerCase).toList();
        System.out.println(output3);

        List<Integer> output4 = list.stream().map(String::length).toList();
        System.out.println(output4);
    }
}
