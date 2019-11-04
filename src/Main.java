import java.lang.reflect.Array;
import java.util.ArrayList;

public class Main {
    public static void main (String[] args) {
        Ledger ledger = new Ledger();
        char[] alphabet = new char[] {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < 26; j++) {
                ledger.addCustomer(Character.toString(alphabet[i]) + Character.toString(alphabet[j]), i);
            }
        }
        ledger.printCustomers();
        System.out.println("UNO REVERSE CARD");
        ledger.sortCustomersName(true);
        ledger.printCustomers();
        System.out.println("Searching!");
        System.out.println("Account found:");
        ArrayList<BankAccount> t = ledger.savingsRange(24.0, 26.0, false);
        for (BankAccount current : t) {
            System.out.println(current);
        }
    }
}
