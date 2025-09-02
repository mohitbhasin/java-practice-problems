package lambdaExpression.functionalInterfaces.function;

import stream.Employee;

import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.IntBinaryOperator;

// BinaryOperator<T> is inherited from BiFunction<T, T, T>.
// It takes one type object for both input and output.
// Like BiFunction, it takes two param as input and returns an output.
// All the types of input and output are of type T.

// There are other BinaryOperators such as:
// IntBinaryOperator, DoubleBinaryOperator, LongBinaryOperator,
// which takes primitive int, double, long
// These are not inherited from any other interfaces.
public class BinaryOperatorDemo {
    public static void main(String[] args) {
        BinaryOperator<Employee> empWithLessSalary = (emp1, emp2) -> emp1.salary<emp2.salary ? emp1 : emp2;

        List<Employee> employeeList = Employee.getEmployees();

        Employee emp1 = employeeList.get((int) (Math.random()*employeeList.size()));
        Employee emp2 = employeeList.get((int) (Math.random()*employeeList.size()));

        System.out.println(emp1);
        System.out.println(emp2);

        System.out.println(empWithLessSalary.apply(emp1, emp2));
    }
}
