package lambdaExpression.functionalInterfaces.predicate;

import java.util.function.Predicate;

// negate() is a default method of predicate.
// It simply negates the result of test()
public class NegatePredicate {
    public static void main(String[] args) {
        Predicate<String> greaterThanTen = word -> word.length()>10;

        String s = "Galaxy";
        System.out.println(s+" length greater than 10: "+greaterThanTen.test(s));
        System.out.println(s+" length greater than 10 (negated): "+greaterThanTen.negate().test(s));
    }
}
