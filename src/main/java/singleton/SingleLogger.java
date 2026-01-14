package singleton;

public class SingleLogger {
    // volatile is used to prevent caching in multi-threaded scenarios.
    private static volatile SingleLogger instance;

    // Below is Eager loading.
    // private static final SingleLogger instance2 = new SingleLogger();

    // Typically interviewers are looking for lazy loading implementation.
    // Here it is implemented and double-checked locking
    private SingleLogger() {
    }

    // this is lazy loading with thread safety and double-checked locking
    public static SingleLogger getLogger() {
        if(instance==null) { // first check
            synchronized (SingleLogger.class) {
                if(instance==null) { // second check
                    instance = new SingleLogger();
                }
            }
        }
        return instance;
    }

    // To prevent cloning from breaking singleton, override clone()
    // and either throw exception or existing instance.
    @Override
    public SingleLogger clone() throws CloneNotSupportedException {
        // option 1
        throw new CloneNotSupportedException("Cloning of singleton not allowed");
        // option 2 - less common
        // return instance;

        // option 3 - best option is to use enum
    }
}