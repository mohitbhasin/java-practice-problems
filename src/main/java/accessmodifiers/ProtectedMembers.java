package accessmodifiers;

public class ProtectedMembers {
    private final int protectedExampleVal;
    public ProtectedMembers() {
        protectedExampleVal = 55;
    }


    protected int getProtectedExampleVal() {
        return protectedExampleVal;
    }
}
