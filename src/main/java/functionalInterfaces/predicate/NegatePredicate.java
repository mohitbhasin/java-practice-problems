package functionalInterfaces.predicate;

import java.util.function.Predicate;

public class NegatePredicate {
    public static void main(String[] args) {
        Predicate<String> greaterThanTen = word -> word.length()>10;

        String s = "Galaxy";
        System.out.println(s+" length greater than 10: "+greaterThanTen.test(s));
        System.out.println(s+" length greater than 10 (negated): "+greaterThanTen.negate().test(s));
    }
}
