package stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StreamPractice {

    public static void main(String[] args) {
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David", "Eve", "Christopher");

        // Example 1: Filtering
        // Get names that start with "A"
        List<String> namesStartingWithA = names.stream()
                .filter(name -> name.startsWith("A"))
                .collect(Collectors.toList());
        System.out.println("Names starting with A: " + namesStartingWithA);

        // More complex filtering: names starting with "C" and length > 5
        List<String> complexFilter = names.stream()
                .filter(name -> name.startsWith("C") && name.length() > 5)
                .collect(Collectors.toList());
        System.out.println("Names starting with C and length > 5: " + complexFilter);


        // Example 2: Mapping
        // Get the length of each name
        List<Integer> nameLengths = names.stream()
                .map(String::length)
                .collect(Collectors.toList());
        System.out.println("Name lengths: " + nameLengths);

        // More complex mapping: map to a custom object
        List<Person> people = names.stream()
                .map(name -> new Person(name, name.length() * 2)) // age is just an example
                .collect(Collectors.toList());
        System.out.println("People objects: " + people);


        // Example 3: Sorting
        // Sort names alphabetically
        List<String> sortedNames = names.stream()
                .sorted()
                .collect(Collectors.toList());
        System.out.println("Sorted names: " + sortedNames);

        // More complex sorting: sort by name length
        List<String> sortedByLength = names.stream()
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());
        System.out.println("Names sorted by length: " + sortedByLength);


        // Example 4: Reducing
        // Concatenate all names into a single string
        String concatenatedNames = names.stream()
                .reduce("", (a, b) -> a + " " + b);
        System.out.println("Concatenated names:" + concatenatedNames);

        // More complex reducing: sum of lengths of all names
        int sumOfNameLengths = names.stream()
                .mapToInt(String::length)
                .sum();
        System.out.println("Sum of name lengths: " + sumOfNameLengths);
    }

    static class Person {
        String name;
        int age;

        Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }
}
