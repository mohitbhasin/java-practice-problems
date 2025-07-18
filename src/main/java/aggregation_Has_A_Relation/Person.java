package aggregation_Has_A_Relation;

public class Person {
    String name;
    Country country;

    public Person(String name, Country country) {
        this.name = name;
        this.country = country;
    }

    public void printDetails() {
        System.out.println(this.name+" is from:"+this.country.getName());
    }
}
