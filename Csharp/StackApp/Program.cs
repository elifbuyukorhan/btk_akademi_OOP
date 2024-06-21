using StackApp.Models;

var numbers = new int[] {1,2,3};

var stack_numbers = new StackApp.Models.Stack<int>(numbers);
stack_numbers.Push(10);

System.Console.WriteLine(stack_numbers.Peek());

var stack_cities = new StackApp.Models.Stack<string>(new List<String>() {
    "İstanbul", "Ankara", "Samsun"
}); 

System.Console.WriteLine(stack_cities.Peek());

var stack_employees = new StackApp.Models.Stack<Employee>(new Employee[] {
    new Employee("Ahmet", "Güneş", 27),
    new Employee("Can", "Dağ", 25),
    new Employee("Merve", "Yılmaz", 30)
});

System.Console.WriteLine(stack_employees.Pop());