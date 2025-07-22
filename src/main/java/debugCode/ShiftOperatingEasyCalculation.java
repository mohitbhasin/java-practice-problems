package debugCode;

public class ShiftOperatingEasyCalculation {
    public static void main(String args[]) {
        int a = 3;
        int b = a<<4;
        // Shift left of 3 (0011) 4 times --> (110000)
        // 2^5 2^4 2^3 2^2 2^1 2^0
        // 32 +16 + 0 + 0 + 0 + 0 = 46

        // Instead of above, we can do 3 * 2^4
        System.out.println(b); // 3*2*2*2*2 = 48

        a = 13;
        b = a<<4; // 13*16 = 208
        System.out.println(b);
    }

}
