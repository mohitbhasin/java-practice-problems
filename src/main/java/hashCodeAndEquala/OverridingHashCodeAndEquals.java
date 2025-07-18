package hashCodeAndEquala;

public class OverridingHashCodeAndEquals {
    public static void main(String[] args) {
        Person a = new Person(1);
        Person b = new Person(1);
        Person c = new Person(1);
        c.id = 5;
        System.out.println(a.equals(b));
        System.out.println(a.equals(c));
        System.out.println(a.hashCode());
        System.out.println(b.hashCode());
    }
}

class Person {
    int id;
    public Person(int id) {
        this.id = id;
    }
    @Override
    public int hashCode() {
        return this.id;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj  instanceof Person) {
            return this.id== ((Person) obj).id;
        }
        return false;
    }
}
