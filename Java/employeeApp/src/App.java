import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        List<Employee> employees = Arrays.asList( 
            new Employee("Zehra Dağ", 29d),
            new Employee("Ege Deniz", 22d),
            new Employee("Mutlu Kara", 40d),
            new Employee("Figen Canan", 25d),
            new Employee("Ahmet Yaş", 30d));
        writeList(employees);

        Collections.sort(employees);
        System.out.println("------------");
        writeList(employees);

    }

    /*private static void writeList(List<Integer> collection)
    {
        for(Integer item : collection) {
            System.out.println(item);
        }
    }*/

    private static void writeList(Iterable collection)
    {
        for(Object item : collection) {
            System.out.println(item);
        }
    }
}
