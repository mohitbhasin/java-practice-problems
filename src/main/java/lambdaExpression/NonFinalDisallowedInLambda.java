package lambdaExpression;

import java.util.function.Consumer;
import java.util.function.Supplier;

// Local variables that are not final or are not effectively final,
// cannot be used inside lambda expression.
// It is done to ensure thread safety
public class NonFinalDisallowedInLambda {
    public static void main(String[] args) {
        int num = 12;
        // Able to use num inside lambda, because it is effectively final.
        // Its value is not getting modified before or after lambda expression.
        Consumer<Integer> multiplyToNum = a -> System.out.println(num*a);
        // If num is incremented even after lambda declaration,
        // Lambda will throw an error.
        // If num is incremented here, it will not work --> num++;
        multiplyToNum.accept(3);

        // Same for any other variables like string for instance.
        // While string objects are immutable/final,
        // if the variable used for it is not final or effectively final,
        // it will throw an error.
        // If gm is changed to final, then it cannot be modified anyway.
        String gm = "Good Morning ";
        Consumer<String> greetings = name -> {
            // modifying string will not work as well
            // gm+="Mr. ";
            System.out.println(gm+name);
        };

    }
}
