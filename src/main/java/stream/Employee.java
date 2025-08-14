package stream;

import java.util.ArrayList;
import java.util.List;

public class Employee {
    int id;
    String name;
    String department;
    int dep_id;

    public Employee(int id, String name, String department, int dep_id) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.dep_id = dep_id;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", department='" + department + '\'' +
                ", dep_id=" + dep_id +
                '}';
    }

    public static List<Employee> getEmployees() {
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee(1,"Warner","OPERATIONS", 201));
        employeeList.add(new Employee(2,"George","FINANCE", 208));
        employeeList.add(new Employee(3,"Byrd","OPERATIONS", 201));
        employeeList.add(new Employee(4,"Sampson","FINANCE", 208));
        employeeList.add(new Employee(5,"Snow","HR", 215));
        employeeList.add(new Employee(6,"Brady","OPERATIONS", 201));
        employeeList.add(new Employee(7,"Hanna","OPERATIONS", 201));
        employeeList.add(new Employee(8,"Leonard","HR", 215));
        employeeList.add(new Employee(9,"Black","TECH", 205));
        employeeList.add(new Employee(10,"McCall","FINANCE", 208));
        employeeList.add(new Employee(11,"Douglas","FINANCE", 208));
        employeeList.add(new Employee(12,"Rosario","FINANCE", 208));
        employeeList.add(new Employee(13,"Ferguson","TECH", 205));
        employeeList.add(new Employee(14,"Hahn","TECH", 205));
        employeeList.add(new Employee(15,"Clark","OPERATIONS", 201));
        employeeList.add(new Employee(16,"Serrano","TECH", 205));
        employeeList.add(new Employee(17,"Kim","HR", 215));
        employeeList.add(new Employee(18,"Lynn","OPERATIONS", 201));
        employeeList.add(new Employee(19,"Green","OPERATIONS", 201));
        employeeList.add(new Employee(20,"Nichols","FINANCE", 208));
        return employeeList;
    }
}
