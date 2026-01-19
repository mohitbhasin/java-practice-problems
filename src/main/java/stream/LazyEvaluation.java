package stream;
import java.util.stream.Stream;

// Below code describes the flow of operations in a stream
// Intermediate operations in stream are not evaluated until terminal operation is called.
// Every intermediate operation creates a new stream and stores the provided operations,
// When terminal operation is called, then traversal of stream begins and functions are performed.
public class LazyEvaluation {
    public static void main(String[] args) {
        long result = Stream.of(4,5,6,7,8,9)
                .filter(num -> {
                    System.out.println("First filter - num > 5: "+num);
                    return num>5;
                })
                .filter(num -> {
                    System.out.println("Second filter - num % 3: "+num);
                    return num%3==0;
                })
                .count();
        System.out.println(result);
    }
}
