import java.util.ArrayList;

public class Ledger {
    private ArrayList<BankAccount> customers = new ArrayList<BankAccount>();

    public void addCustomer(String name, String number, double savings) {
        customers.add(new BankAccount(name, number, savings));
    }

    public void addCustomer(String name, double savings) {
        customers.add(new BankAccount(name, savings));
    }

    public void deleteCustomer(String number) {
        int index = 0;
        for (BankAccount customer:customers) {
            if (number.equals(customer.getAccountNumber())) {
                customers.remove(index);
            }
            index++;
        }
    }

    public void printTotalBalance() {
        double total = 0;
        for (BankAccount customer:customers) {
            total += customer.getSavings();
        }
        System.out.println("Total Bank Balance: " + total);
    }

    public void printCustomers() {
        for (BankAccount customer:customers) {
            System.out.println(customer);
        }
    }
}
