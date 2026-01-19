package stream;

import java.util.Arrays;
import java.util.List;

// Slicing operations are intermediate operations.
// Like the name suggest, they are used to slice or subset of the stream.
// The common slicing operations are limit() and skip().
public class SlicingOperations {
    public static void main(String[] args) {
        System.out.println("Slicing operations are used to select subset of a stream");
        System.out.println("\nlimit(long maxSize) will truncate the stream so that it's no longer then the max size");
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8);
        list.stream().limit(3).map(a -> a+",").forEach(System.out::print);

        System.out.println("\nskip(long n) is used to discard elements at the beginning");
        list.stream().skip(5).map(a -> a+",").forEach(System.out::print);

        System.out.println("\nUsing skip() and limit() in combination");
        list.stream().skip(3).limit(3).map(a -> a+",").forEach(System.out::print);
        System.out.println("\n");
    }
}
