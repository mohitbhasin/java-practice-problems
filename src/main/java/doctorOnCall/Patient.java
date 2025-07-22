package doctorOnCall;

public class Patient {
    private String name;
    private int age;
    private int code;
    private static int nextCode=1;

    public Patient(String patientName, int age) {
        this.name = patientName;
        this.age = age;
        this.code = nextCode++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "Patient:-\n"+
                "\tName: "+this.name+"\n"+
                "\tAge: "+this.age+"\n"+
                "\tCode: "+this.code +"\n";
    }
}
