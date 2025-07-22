package tryCatchFinally;

public class TryCatchFinallyExample {
    public static void main(String[] args) {
        int[] arr = {4,1,5,0};
        for(int i=1; i<arr.length; i+=2) {
            execute(arr[i-1], arr[i]);
            System.out.println("-----------");
        }
    }

    public static void execute(int a, int b) {
        try {
            System.out.println(a/b+" <- divided by 1");
        } catch (Exception e) {
            System.out.println("dividing by zero not allowed");
        } finally {
            System.out.println("Finally executed");
        }
    }
}
