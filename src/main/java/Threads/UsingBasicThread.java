package threads;

public class UsingBasicThread {
    public static void main(String[] args) {
        new MyThread().start();
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
