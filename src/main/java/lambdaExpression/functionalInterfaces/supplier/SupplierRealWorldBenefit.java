package lambdaExpression.functionalInterfaces.supplier;

import java.util.function.Supplier;

// Since supplier is lazy, the object is not created until get() is called.
// The createMethod() in eager loading will be called in the first trace().
// While createMethod() in lazy loading will not be called using supplier in second trace().
public class SupplierRealWorldBenefit {
    public static void main(String[] args){
        Logger logger = new Logger();
        // The creteMessage() will be called.
        logger.trace(createMessage());
        // createMessage() will not be called until supplier get() is called.
        // Can be verified by setting break points.
        logger.trace(() -> createMessage());
        System.out.println("Process finished");
    }

    public static String createMessage() {
        return "Some long and expensive message is created.";
    }
}

class Logger {
    public void trace(String log) {
    }

    public void trace(Supplier<String> log) {
    }
}
