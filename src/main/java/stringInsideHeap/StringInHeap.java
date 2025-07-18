package stringInsideHeap;

public class StringInHeap {
    public static void main(String[] args) {
        // These are string literals and
        // are stored in String Constant Pool inside heap memory.
        // only one entry of hello and both a and b points to the same hello,
        String a = "hello";
        String b = "hello";
        // therefore a==b returns true;
        System.out.println(a==b);

        // Using the new keyword, objects are created inside the heap memory.
        // Even though they have the same value, they point to different objects.
        String c = new String("hello");
        String d = new String("hello");
        // c==d returns false;
        System.out.println("new keyword objects compared: "+(c==d));
        System.out.println("new objects compared with equals: "+c.equals(d));

        // intern() on any string (new or literal)
        // will return the object from String Constant Pool
        // x==a and x==b will return true.
        String x = c.intern();
        System.out.println("intern() of object compared with literal:"+(x==a));
    }
}
