package stream;

import java.util.*;

public class SecondMaxAndMin {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(4, 2, 6, 7, 1, 0, 4, 1, 3);

        int secondMax = list.stream().sorted(Collections.reverseOrder()).distinct().skip(1).findFirst().get();
        System.out.println(secondMax);

        int secondMin = list.stream().sorted().distinct().skip(1).findFirst().get();
        System.out.println(secondMin);

        // for IntStream (primitive type) requires to be boxed into wrapper class stream.
        int[] arr = {4,2,8,9,5,2};
        Optional<Integer> result = Arrays.stream(arr)
                .boxed()
                .distinct()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst();

        System.out.println(result);
    }
}
