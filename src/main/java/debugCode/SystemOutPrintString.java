package debugCode;

public class SystemOutPrintString {
    public static void main(String args[]) {
        int a = 3;
        int b = 4;

        // the expression is evaluated from left to right
        // If there is no string, then the val is calculated.
        System.out.println(3+4); // 7
        System.out.println(a+b); // 7
        // If there is a string, then operands are printed as is
        System.out.println(foo()+a+b); // foo34
        System.out.println(foo()+3+4); // foo34
        // If there are integers appearing before and after a string,
        // then val is calculated for operands appearing before string
        // and operands will be printed which are appearing after the string.
        System.out.println(3+4+foo()+3+4); // 7foo34
    }

    public static String foo() {
        return "foo";
    }
}
