package stream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class SumOfNumbers {
    public static void main(String[] args) {
        printSumOfNumbers();
    }

    // Using the reduce(), which is a terminal operation.
    // It combines all elements into a single result by applying binary operation.
    public static void printSumOfNumbers() {
        List<Integer> nums = Arrays.asList(4,2,6,7,1,8,5,9,3);
        // Here it works like a+=b, where b is the next element in the stream.
        int sum = nums.stream().reduce((a, b) -> a+b).get();
        System.out.println(sum);
    }
}
