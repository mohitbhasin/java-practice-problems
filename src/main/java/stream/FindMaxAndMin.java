package stream;

import java.util.*;
import java.util.stream.Collectors;

public class FindMaxAndMin {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(4,2,6,7,1,0,4,1,3);

        int max = list.stream().mapToInt(a -> a).max().getAsInt();
        System.out.println(max);

        int min = list.stream().mapToInt(a -> a).min().getAsInt();
        System.out.println(min);
    }
}
