package lambdaExpression;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorUsingLambda {
    public static void main(String[] args) {
        List<Person> personList = new ArrayList<>();
        personList.add(new Person("Brad", 59));
        personList.add(new Person("Bob", 56));
        personList.add(new Person("Victor", 45));
        personList.add(new Person("Alex", 30));

        // Without lambda expression to sort personList
        personList.sort(new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.name.compareTo(o2.name);
            }
        });
        System.out.println(personList);

        // Using lambda expression
        personList = new ArrayList<>();
        personList.add(new Person("Shiv", 17));
        personList.add(new Person("Adam", 20));
        personList.add(new Person("Matt", 39));
        personList.add(new Person("Angela", 100));

        personList.sort((a,b) -> a.name.compareTo(b.name));
        System.out.println(personList);
    }
}

class Person {
    String name;
    int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return this.name;
    }
}