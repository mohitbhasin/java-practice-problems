package abstractClass;

public class AbstractUserExample extends AbstractUser {
    @Override
    public void logIn() {

    }

    @Override
    public String getName() {
        return null;
    }

    // viewReport() method from interface implemented by AbstractUser class.
    @Override
    public void viewReport() {

    }
    // class method
    public void printUserDetails() {
        System.out.println(getUserDetails());
    }
}

// Abstract class can implement other interfaces.
abstract class AbstractUser implements UserProperties {
    // Abstract class can have constructors and static variables
    public AbstractUser() {
    }

    // Abstract methods - cannot be set as private
    public abstract void logIn();
    public abstract String getName();

    // Abstract class can contain concrete methods.
    public String getUserDetails() {
        return this.getName();
    }

    private void privateInAbstract() {
        System.out.println("private method in abstract class");
    }
}

interface UserProperties {
    // All the variables by default are public static final
    static String userStatus = "Active";

    // all methods(declared or implemented) are by default public
    public void viewReport();


    // However, private, default and static, private static and public static can exist.
    default void printInterface() {
    }
    // Private concrete methods introduced in Java 9.
    private void privateMethod() {

    }
    public static void publicStaticMethod() {

    }

    // public concrete methods cannot exist in an interface.
    // public void publicMethod() {
    // }

}