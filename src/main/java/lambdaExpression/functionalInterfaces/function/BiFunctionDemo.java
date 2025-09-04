package lambdaExpression.functionalInterfaces.function;

import java.util.function.BiFunction;
import java.util.stream.IntStream;

// BiFunction<T, U, R> is similar to Functions<T, R>,
// but it takes two arguments (T, U) as input instead of just one(T).
public class BiFunctionDemo {
    public static void main(String[] args) {
        BiFunction<String, Integer, String> concatenateString = (str, count) -> {
            StringBuilder sb = new StringBuilder();
            for(int i=0; i<count; i++) {
                sb.append(str);
            }
            return sb.toString();
        };

        System.out.println(concatenateString.apply("*****", 5));
    }
}
