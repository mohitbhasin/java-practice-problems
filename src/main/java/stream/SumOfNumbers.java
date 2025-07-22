package stream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class SumOfNumbers {
    public static void main(String[] args) {
        printSumOfNumbers();
    }

    public static void printSumOfNumbers() {
        List<Integer> nums = Arrays.asList(4,2,6,7,1,8,5,9,3);
        Optional<Integer> sum = nums.stream().reduce((a, b) -> a+b);
        System.out.println(sum.get());
    }
}
