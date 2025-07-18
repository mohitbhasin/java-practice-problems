package accessmodifiers;

import java.util.Comparator;
import java.util.PriorityQueue;

public class ToggleString {
    public static void main(String[] args) {
        String[] arr = {"jaVA...", "   sTriNG", "EXCEption"};
        for(String s: arr) {
            System.out.println(toggle(s));
        }
    }

    public static int funtionalInterfaceTest() {
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return 0;
            }
        };

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        return 0;
    }

    public static String toggle(String s) {
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if(Character.isUpperCase(c)) {
                sb.append(Character.toLowerCase(c));
            } else if(Character.isLowerCase(c)) {
                sb.append(Character.toUpperCase(c));
            } else {
                sb.append(c);
                System.out.println(c+" neither");
            }
        }
        return sb.toString();
    }
}
