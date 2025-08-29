package lambdaExpression.functionalInterfaces.supplier;

import java.util.function.IntSupplier;

public class IntSupplierDemo {
    public static void main(String[] args) {
        // random integer between 0-10
        IntSupplier randIntSupplier = () -> (int) (Math.random() * 10);
        System.out.println(randIntSupplier.getAsInt());

        // random integer between range 4-9
        IntSupplier randRangeSupplier = () -> (int) (Math.random() * (9 - 4 + 1)) + 4;
        System.out.println(randRangeSupplier.getAsInt());

        // random integer between between 0-33
        IntSupplier largeRandSupplier = () -> (int) (Math.random() * 33);
        System.out.println(largeRandSupplier.getAsInt());
    }
}
