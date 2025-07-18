package staticKeyword;

public class StaticKeywordExamples {
    final int val1 = 10;
    final int val2;
    static final int val3 = 3;
//    static final int val4; // static does not belong to instance so cannot be initialized in constructor.
    static final int val5;
    static {
        val5 = 9;
    }
    public static void main(String[] args) {
        StaticKeywordExamples obj = new StaticKeywordExamples();
        obj.staticNotAccessible();
    }

    public StaticKeywordExamples() {
        val2 = 0; // allowed to initialize in constructor
//        val1 = 0; // not allowed to change in the constructor
//        val4 = 0; // static not allowed to initialize in the constructor
    }

    public void staticNotAccessible() {
//        val1 = 9; // not allowed to change final value
    }
}
