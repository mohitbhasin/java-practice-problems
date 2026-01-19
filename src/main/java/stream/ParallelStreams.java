package stream;

import java.util.stream.Stream;

// Parallel Streams allow for parallel processing.
// Parallel processing performs operations faster
// as they can run on multiple cores of CPU.
// Parallel steam uses all CPU cores in parallel.
// Parallel streams can be created using:
//      parallelStream()
//      parallel() from already created stream
public class ParallelStreams {
    public static void main(String[] args) {
        parallelStreamDemo();
    }

    public static void parallelStreamDemo() {
        // serial vs parallel streams
        System.out.println("Serial stream is single threaded");
        Stream.of(1,2,3,4,5,6)
                .forEach(num -> System.out.println(num + " "+Thread.currentThread().getName()));

        System.out.println("\nParallel stream is multi threaded - It uses all CPU threads in parallel");
        Stream.of(1,2,3,4,5,6)
                .parallel()
                .forEach(num -> System.out.println(num + " "+Thread.currentThread().getName()));

        // Cases where parallel streams are discouraged:
        // - They have a lot of overhead. Coordinating threads takes significant time.
        // We can use them when:
        //        - Large amount of data to process.
        //        = Performance problems.

        // Things to consider when using parallel streams
        // - Splitting is not expensive than doing the work.
        // - Task dispatch or management cost is not too high.
        // - Result combination cost in not too high.
        // - Use the formula to decide:
        //      - N * Q > 1000
        //      - N is number of data items
        //      - Q is amount of work per item
        System.out.println();
    }
}
