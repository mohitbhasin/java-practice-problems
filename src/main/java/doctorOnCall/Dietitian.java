package doctorOnCall;

public class Dietitian implements Doctor {
    private String name;
    private int age;
    private boolean availability;

    public Dietitian(String doctorName, int age) {
        this.name = doctorName;
        this.age = age;
        this.availability = true;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean getAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    public void printDietitian() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "Dietitian:-\n"+
                "\tName: "+this.name+"\n"+
                "\tAge: "+this.age+"\n"+
                "\tAvailable: "+this.availability;
    }
}
