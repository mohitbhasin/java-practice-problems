package threads;

// A class that implements Runnable, becomes a task for executor service
// and can be submitted to it.
public class RunnableExample {
    public static void main(String[] args) {
        new MyThread(new MyRunnable()).start();
        System.out.println();
    }
}

class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("Inside Runnable");
    }
}