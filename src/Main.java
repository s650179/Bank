import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main (String[] args) {
        Ledger ledger = new Ledger();
        char[] alphabet = new char[] {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < 26; j++) {
                ledger.addCustomer(Character.toString(alphabet[i]) + Character.toString(alphabet[j]), i);
            }
        }

        Scanner myScanner = new Scanner(System.in);

        System.out.println("Please enter your desired operation: add, delete, sort, search, total, display, or exit.");
        String operation = myScanner.nextLine();

        while (!operation.equals("exit")) {
            if (operation.toLowerCase().equals("add")) {

                System.out.println("Enter the account holder's name:");
                String name = myScanner.nextLine();
                System.out.println("Enter the account number: (Leave blank to automatically assign a number)");
                String number = myScanner.nextLine();
                System.out.println("Enter the balance of the account holder:");
                double balance = myScanner.nextDouble();
                myScanner.nextLine();

                if(number.equals("")) {
                    ledger.addCustomer(name, balance);
                } else {
                    ledger.addCustomer(name, number, balance);
                }

                System.out.println("Customer successfully added!");

            } else if (operation.toLowerCase().equals("delete")) {

                System.out.println("Enter the number of the customer to delete:");
                String number = myScanner.nextLine();
                ledger.deleteCustomer(number);

            } else if (operation.toLowerCase().equals("sort")) {

                System.out.println("Sort by: (savings, name, number)");
                String order = myScanner.nextLine();
                System.out.println("Sort ascending or sort descending?");
                boolean descending = myScanner.nextLine().toLowerCase().equals("descending");

                if (order.toLowerCase().equals("savings")) {
                    ledger.sortCustomersSavings(descending);
                    System.out.println("Sorting successful!");
                } else if (order.toLowerCase().equals("name")) {
                    ledger.sortCustomersName(descending);
                    System.out.println("Sorting successful!");
                } else if (order.toLowerCase().equals("number")) {
                    ledger.sortAccountNumber(descending);
                    System.out.println("Sorting successful!");
                } else {
                    System.out.println("No such search order: \"" + order + "\"");
                }

            } else if (operation.toLowerCase().equals("search")) {

                System.out.println("Search for name or range?");
                String option = myScanner.nextLine();

                if (option.toLowerCase().equals("name")) {
                    System.out.println("Enter the name of the account to search for:");
                    String name = myScanner.nextLine();
                    ArrayList<BankAccount> results = ledger.searchCustomers(name);

                    for (BankAccount customer : results) {
                        System.out.println("--------------------------------------------------");
                        System.out.println("Name: " + customer.getName() + "\nAccount#: " + customer.getAccountNumber() + "\nSavings: " + customer.getSavings());
                    }
                    System.out.println("--------------------------------------------------");

                } else if (option.toLowerCase().equals("range")) {
                    System.out.println("Enter the minimum value of the savings range:");
                    double min = myScanner.nextDouble();
                    myScanner.nextLine();
                    System.out.println("Enter the maximum value of the savings range:");
                    double max = myScanner.nextDouble();
                    myScanner.nextLine();
                    System.out.println("Inclusive? (y/n)");
                    boolean inclusive = myScanner.nextLine().toLowerCase().equals("y");
                    ArrayList<BankAccount> results = ledger.savingsRange(min, max, inclusive);

                    for (BankAccount customer : results) {
                        System.out.println("--------------------------------------------------");
                        System.out.println("Name: " + customer.getName() + "\nAccount#: " + customer.getAccountNumber() + "\nSavings: " + customer.getSavings());
                    }
                    System.out.println("--------------------------------------------------");
                } else {
                    System.out.println("No such option: \"" + option + "\"");
                }


            } else if (operation.toLowerCase().equals("save")) {

                ledger.save();

            } else if (operation.toLowerCase().equals("read")) {

                ledger.read();

            } else if (operation.toLowerCase().equals("total")) {
                ledger.printTotalBalance();

            } else if (operation.toLowerCase().equals("display")) {

                ledger.printCustomers();

            } else {
                System.out.println("The command \"" + operation + "\" was not recognized.");
            }

            System.out.println("Please enter your desired operation: add, delete, sort, search, total, display, or exit.");
            operation = myScanner.nextLine();
        }

        System.out.println("Exiting.");
    }
}
