package implicitExplicitTypeConversion;

public class Conversion {
    public static void main(String[] args) {
        // Implicit conversion: smaller to larger
        int a = 10;
        double b = a;
        System.out.println(b);
        // Explicit conversion: manually converting larger to smaller
        double c = 2.9;
        int d = (int) c;
        System.out.println(d);
    }
}
