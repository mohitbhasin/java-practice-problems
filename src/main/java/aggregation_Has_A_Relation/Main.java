package aggregation_Has_A_Relation;

public class Main {
    public static void main(String[] args) {
        Country country = new Country("India", 1000);
        {
            Person person = new Person("Max", country);
            person.printDetails();
        }
        // Scope of parent (Person) is over.
        System.out.println(country.name);
        // Child object (Country) still exist.
    }

}
