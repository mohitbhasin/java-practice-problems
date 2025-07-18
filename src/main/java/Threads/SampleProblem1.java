package Threads;

public class SampleProblem1 {
    public static void main(String[] args) {
        // Both statements will print "Inside Thread"
        new MyThread().start();
        // For this, although MyRunnable is passed to the Thread constructor using super(r)
        // it is, however is overridden by tge run() in MyThread.
        // Therefore "Inside Thread" is printed.
        new MyThread(new MyRunnable()).start();

        // If run() was not overridden inside MyThread,
        // then, "Inside Runnable" would be printed.
    }
}

class MyThread extends Thread {
    MyThread() {};
    MyThread(Runnable r) {
        super(r);
    }
    public void run() {
        System.out.println("Inside Thread");
    }
}

class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("Inside Runnable");
    }
}
