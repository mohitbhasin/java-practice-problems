package stream;


import java.util.stream.Stream;

// Stream is not a data structure.
// It is a set of operation that can be applied to a source.
// The source can be a collection or arrays.
// Streams are lazy meaning any number of intermediate operations
// can be piped together and result is produced only when the terminal operation is applied
// All intermediate operations return a stream which can be chained together.
// A single stream can be created using objects of different classes.
// eg. Stream.Of(Integer, String, Employee) etc
public class Introduction{
    public static void main(String[] args) {
        basicStream();
    }

    public static void basicStream() {
        // Stream of Integers
        Stream<Integer> intStream = Stream.of(2,5,6,18,24);
        // forEach is a terminal operation, which has a parameter of Consumer type.
        intStream.forEach(val -> System.out.print(val+", "));
        System.out.println();
        // Stream of objects
        Stream<Object> differentTypes = Stream.of(2, "Star", Employee.getEmployees());
        differentTypes.forEach(val -> System.out.print(val+" "));
        System.out.println("\n");
    }

    public void variableLengthArgument(int... args) {

    }
}
