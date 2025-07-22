package singleton;

public class SingleLogger {
    private static SingleLogger instance;

    // This is Eager loading.
    // Typically interviewers are looking for lazy loading implementation.
    // private static final SingleLogger instance2 = new SingleLogger();
    private SingleLogger() {
    }

    // this is lazy loading.
    public static SingleLogger getLogger() {
        synchronized (SingleLogger.class) {
            if(instance==null) {
                instance = new SingleLogger();
            }
        }
        return instance;
    }
}