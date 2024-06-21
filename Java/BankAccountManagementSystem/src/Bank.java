import java.util.ArrayList;
import java.util.List;
import java.time.LocalTime;
import java.time.LocalDate;

public class Bank {

    public static List<String> transactionHistory = new ArrayList<>();
    //public static String[] transactionHistory = new transactionHistory[1000];

    public static void displayBankInfo() {
        System.out.println("Bank name is Elif Bank. Bank branch is Eryaman/Göksu.");
    }

    public static void trackTransaction(String description) {

        // Şu anki saat
        LocalTime now = LocalTime.now();
        // Şu anki gün
        LocalDate today = LocalDate.now();

        transactionHistory.add(description + " - " + now + " - " + today);

    }

}
