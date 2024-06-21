namespace StackApp.Models;

public class Employee 
{
    public Employee()
    {
        
    }
    public Employee(string firstName, string lastName, Decimal salary)
    {
        FirstName = firstName;
        LastName = lastName;
        Salary = salary;
    }

    public String FirstName { get; set; } = string.Empty;
    public String LastName { get; set; }
    public Decimal Salary { get; set; } = 0;
    public String FullName => FirstName + " " + LastName;

    public override string ToString()
    {
        return string.Concat(FullName, " ", Salary);
    }

}