package threads;

import accessmodifiers.ProtectedMembers;

public class ProtectedMemberTest {
    public static void main(String[] args) {
        ProtectedMembers protectedMembers = new ProtectedMembers();
        // unable to access protected member
//        System.out.println(protectedMembers.getProtectedExampleVal());
    }
}
