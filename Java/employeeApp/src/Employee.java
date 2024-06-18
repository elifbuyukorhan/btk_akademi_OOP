import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Employee implements Comparable {

    private String fullName;
    private Double salary;

    public Employee() {
        this.fullName = "Unknown";
        this.salary = 0.0;
    }

    public Employee(String fullName, Double salary)
    {
        this.fullName = fullName;
        this.salary = salary;
    }

    public String getFullName() {
        return this.fullName;
    }

    public void setFullName(String value) {
        this.fullName = value;
    }    

    public Double getSalary() {
        return this.salary;
    }

    public void setSalary(Double value) {
        this.salary = value;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return getFullName() + " " + getSalary();
    }

    @Override
    public int compareTo(Object other) {
        if(other instanceof Employee) {
            Employee emp = (Employee)other; // unboxing - cast
            return (int)Math.round(this.getSalary()-emp.getSalary());
            // return this.getFullName().compareTo(emp.getFullName());
        }
        throw new RuntimeException("An error occured.");
    }

};

