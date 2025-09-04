package lambdaExpression;

import java.util.function.Supplier;
import java.util.function.UnaryOperator;

// Lambda expression is called Capturing Lambda if it is accessing
// instance variable of class or local variables (final or effectively final),
// Three types of variables a lambda can capture:
// 1. static, 2. instance, 3. local
// Effective final variables whose value is not changed after initialization.

public class CapturingLambdas {
    public static void main(String[] args) {
        CapturingLambdas obj = new CapturingLambdas();
        obj.nonLocalVariable();
    }
    // The nonLocalVal is the instance variable and not the local variable,
    // therefore, final and effective final condition does not apply.
    int nonLocalVal = 4;
    public void nonLocalVariable() {
        nonLocalVal*=35;
        Supplier<Integer> square = () -> nonLocalVal*nonLocalVal;
        nonLocalVal/=35;
    }

    // Final and effective final requirement applies to local variables only.
    // This is because, the local variables are stored in the stack and
    // lambdas capture the value not the variable it is stored in.
    // If the local variable value is changed, lambda will still have old value,
    // which will give unexpected behavior.
    // Also, if using lambdas in multithreading and are allowed to change local variables,
    // it can lead to concurrency issues.
    public static void effectiveFinal() {
        // val is not changed after initialization, so it is valid to be used in lambda.
        int val = 87;
        Supplier<Integer> supplier = () -> {
            return val*val;
        };

        // value change before or even after lamda declaration is not allowed.
        // val2++ after supplier2 is not allowed.
        int val2 = 12;
        // val2*=9;
        Supplier<Integer> supplier2 = () -> {
            // not even allowed to change inside the lambda.
            // val2+=45;
            return val2 * val2;
        };
        // val2++;
    }
}
