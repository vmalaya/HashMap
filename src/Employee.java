import java.util.Arrays;

public class Employee implements Comparable{
    private Integer id;
    private  String firstName;
    private String lastName;
    private int[] grades;

    public Employee(int id,String firstName, String lastName, int[] grades) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.grades = grades;
    }

    public String getFirstName() {
        return firstName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employee employee = (Employee) o;

        if (id != employee.id) return false;
        if (firstName != null ? !firstName.equals(employee.firstName) : employee.firstName != null) return false;
        if (lastName != null ? !lastName.equals(employee.lastName) : employee.lastName != null) return false;
        return Arrays.equals(grades, employee.grades);
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
