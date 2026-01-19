package lambdaExpression;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

// When using lambda expression, methods can be referred providing a concise syntax.
// Its syntax is ClassName::MethodName
public class MethodReference {
    public static void main(String[] args) {
        methodReferenceTypes();
    }

    // Four types of method reference
    public static void methodReferenceTypes() {
        // Static method - className::staticMethodName
        List<Integer> list = Arrays.asList(1,2,3,4);
        list.forEach(System.out::println);

        // Instance method of already created object - objectReference::instanceMethodName
        Temp myObj = new Temp();
        list.stream().forEach(myObj::printEven);

        // Instance method of arbitrary object
        // Used when lamda's first parameter is the target object
        // and remaining params are passed to the method,
        List<String> names = Arrays.asList("Brad","Alex","Carter","Carl","ben");
        names.sort(String::compareToIgnoreCase);
        System.out.println(names);

        // Reference to constructor
        List<Person> personList = names.stream()
                .map(Person::new)
                .collect(Collectors.toList());
        System.out.println(personList);
        System.out.println();
    }

    static class Temp {
        public void printEven(int num) {
            if(num%2==0) {
                System.out.println(num+" is even");
            } else {
                System.out.println(num+" is odd");
            }
        }
    }

    static class Person {
        String name;
        public Person(String name) {
            this.name = name;
        }
        public String toString() {
            return "*"+name+"*";
        }
    }
}

