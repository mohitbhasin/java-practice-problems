package throwVsThrows;

import java.io.FileNotFoundException;

public class ThrowVsThrows {
    public static void main(String[] args) {
        caller();
    }

    public static void caller() {
        int result = 0;
        // checked exception handling
        try {
            result = divideByZero();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        System.out.println(result);
    }
    // throws is mandatory for checked exceptions
    public static int divideByZero() throws FileNotFoundException {
        return 0;
    }
}
