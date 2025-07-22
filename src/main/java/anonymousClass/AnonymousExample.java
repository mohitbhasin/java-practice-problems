package anonymousClass;

import java.util.*;

public class AnonymousExample {
    public static void main(String[] args) {
        // Example 1
        Queue<Integer> list = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return 0;
            }
        });
        // Example 2
        interface Person {
            public void getName();
        }
        Person person = new Person() {
            @Override
            public void getName() {
                System.out.println("Person Name");
            }
        };
    }
}