package lambdaExpression.functionalInterfaces.unaryOperator;

import java.util.function.IntUnaryOperator;

// IntUnaryOperator is a unary operator that takes
// primitive int as the argument and returns int as the result.

// The function to call is applyAsInt(int)
public class IntUnaryOperatorDemo {
    public static void main(String[] args) {
        IntUnaryOperator randomNum = a -> (int) (Math.random() * 11);

        System.out.println(randomNum.applyAsInt(11));
    }
}
