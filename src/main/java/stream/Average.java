package stream;

import java.util.Arrays;
import java.util.List;

public class Average {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(4,2,6,7,1,8,5,9,3);
        double avg = list.stream()
                .mapToInt(a -> a)
                .average()
                .getAsDouble();

        System.out.println(avg);
        double squareAvg = list.stream().map(a -> a*a).mapToInt(a -> a).average().getAsDouble();
        System.out.println(squareAvg);
    }
}
