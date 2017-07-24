import java.util.Arrays;
import java.util.Objects;

public class Employee implements Comparable{
    private Integer id;
    private  String firstName;
    private String lastName;
    private int[] grades;

    Employee(int id, String firstName, String lastName, int[] grades) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.grades = grades;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employee employee = (Employee) o;

        return Objects.equals(id, employee.id) && (firstName != null ? firstName.equals(employee.firstName) : employee.firstName == null) && (lastName != null ? lastName.equals(employee.lastName) : employee.lastName == null) && Arrays.equals(grades, employee.grades);
    }

    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public int compareTo(Object o) {
        Employee employee = (Employee) o;
        return this.id.compareTo((employee.id));
    }
}
