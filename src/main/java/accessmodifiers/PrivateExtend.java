package accessmodifiers;

public class PrivateExtend extends PrivateExample {
    public void printParentName() {
        super.setName("Parent Class");
        // cannot access private fields directly even after extending it.
        // System.out.println(super.name);
    }
}
