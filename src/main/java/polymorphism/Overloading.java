package polymorphism;

// Overloading - Binding done at compile time, as opposed to runtime in method overriding.
// Faster than overriding because of compile time binding.
public class Overloading {
    public static void main(String[] args) {

    }

    public int getVal() {
        return 0;
    }

    // Only one getVal() can exist.
    // return type does not make a difference to distinguish the two functions.
    // Methods must be different based on parameters.
    // Below commented methods are not allowed.

    // public void getVal() {
    //
    // }

    // public double getVal() {
    //     return 0.0;
    // }

    public int getArea(int a, int b) {
        return a*b;
    }
    // Different parameter numbers
    public double getArea(int r) {
        return r*r;
    }
    // Different parameter type and same number of parameters will work as well.
    public double get(double r) {
        return r*r;
    }
}
