package stream;

import java.util.*;
import java.util.stream.Collectors;

public class MapVsFlatMap {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(4, 2, 6, 7, 1, 0, 4, 1, 3);

        int max = list.stream().map(a -> a*a).findFirst().get();
        System.out.println(max);

        List<List<String>> items = new ArrayList<>();
        items.add(Arrays.asList("Apple", "Orange", "Banana"));
        items.add(Arrays.asList("Coffee", "Tea", "Milk", "Water", "Soda"));
        items.add(Arrays.asList("Bread", "Pasta", "Muffin", "Cake", "Doughnut"));

        List<String> selected = items.stream().flatMap(Collection::stream).filter(a -> a.length()>5).collect(Collectors.toList());

        System.out.println(selected);
    }
}
