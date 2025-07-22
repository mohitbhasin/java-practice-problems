package stream;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SecondMaxAndMin {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(4, 2, 6, 7, 1, 0, 4, 1, 3);

        int secondMax = list.stream().sorted(Collections.reverseOrder()).distinct().skip(1).findFirst().get();
        System.out.println(secondMax);

        int secondMin = list.stream().sorted().distinct().skip(1).findFirst().get();
        System.out.println(secondMin);
    }
}
