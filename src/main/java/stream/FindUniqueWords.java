package stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FindUniqueWords {
    public static void main(String[] args) {
        String sentence = "Some people like mangoes and some people like oranges";
        System.out.println(getUniqueWords(sentence));
    }

    public static List<String> getUniqueWords(String sentence) {
        Map<String, Long> map = Arrays.stream(sentence.split(" ")).
                map(a -> a.toLowerCase()).collect(Collectors.groupingBy(a -> a, Collectors.counting()));

        return map.entrySet().stream().
                filter(a -> a.getValue()==1).
                map(a -> a.getKey()).
                sorted().
                collect(Collectors.toList());
    }
}
