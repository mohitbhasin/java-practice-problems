package staticKeyword;

public class StaticBlock {
    static int val1;
    int val2;
    public static void main(String[] args) {
        System.out.println(val1);
        System.out.println();
    }
    static {
        val1 = 12;
        System.out.println("static block executed first");
        // non static variable cannot be initialized in static block.
        // val2 = 11;
    }


}
