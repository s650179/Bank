import java.util.ArrayList;

public class Main {
    public static void main (String[] args) {
        Ledger ledger = new Ledger();
        char[] alphabet = new char[] {'a'};
        for (int i = 0; i < 10; i++) {
            ledger.addCustomer(Integer.toString(i), i);
        }
        ledger.printCustomers();
        System.out.println("UNO REVERSE CARD");
        ledger.sortCustomersSavings(false);
        ledger.printCustomers();
        System.out.println("7".compareTo("7"));
    }
}
