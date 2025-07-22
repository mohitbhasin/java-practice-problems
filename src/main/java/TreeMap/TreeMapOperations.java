package treeMap;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeMap;

public class TreeMapOperations {
    public static void main(String args[]) {
        TreeMap<Integer, String> map = new TreeMap<>(Comparator.reverseOrder());
        map.put(2, "Two");
        map.put(5, "Five");
        map.put(4, "Four");
        map.put(6, "Six");
        map.put(1, "One");
        map.put(3, "Three");

        for(int key: map.keySet()) System.out.println(key);
        Set<Integer> set = map.keySet();
        System.out.println(map.higherKey(11));
        for(int key: set) System.out.print(key+", ");
    }
}
