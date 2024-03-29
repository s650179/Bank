import java.io.*;
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
                System.out.println("Customer successfully deleted!");
                return;
            }
            index++;
        }
        System.out.println("There was an error, the account could not be deleted.");
    }

    public void deleteCustomer(BankAccount account) {
        customers.remove(account);
    }

    public void sortCustomersSavings() {
        for (int i = 0; i < customers.size()-1; i++) {
            for (int j = 0; j < customers.size()-1; j++) {
                if (customers.get(j).getSavings() > customers.get(j+1).getSavings()) {
                    BankAccount temp = customers.get(j);
                    customers.set(j, customers.get(j+1));
                    customers.set(j+1, temp);
                }
            }
        }
    }

    public void sortCustomersSavings(boolean reverses) {
        for (int i = 0; i < customers.size()-1; i++) {
            for (int j = 0; j < customers.size()-1; j++) {
                if (customers.get(j).getSavings() > customers.get(j+1).getSavings() && !reverses) {
                    BankAccount temp = customers.get(j);
                    customers.set(j, customers.get(j+1));
                    customers.set(j+1, temp);
                }else if (customers.get(j).getSavings() < customers.get(j+1).getSavings() && reverses) {
                    BankAccount temp = customers.get(j);
                    customers.set(j, customers.get(j+1));
                    customers.set(j+1, temp);
                }
            }
        }
    }

    public void sortCustomersName() {
        for (int i = 0; i < customers.size()-1; i++) {
            for (int j = 0; j < customers.size()-1; j++) {
                if (customers.get(j).getName().compareTo(customers.get(j+1).getName()) <= 0) {
                    BankAccount temp = customers.get(j);
                    customers.set(j, customers.get(j+1));
                    customers.set(j+1, temp);
                }
            }
        }
    }

    public void sortCustomersName(boolean reverses) {
        for (int i = 0; i < customers.size()-1; i++) {
            for (int j = 0; j < customers.size()-1; j++) {
                if (customers.get(j).getName().compareTo(customers.get(j+1).getName()) <= 0 && !reverses) {
                    BankAccount temp = customers.get(j);
                    customers.set(j, customers.get(j+1));
                    customers.set(j+1, temp);
                } else if (customers.get(j).getName().compareTo(customers.get(j+1).getName()) > 0 && reverses) {
                    BankAccount temp = customers.get(j);
                    customers.set(j, customers.get(j+1));
                    customers.set(j+1, temp);
                }
            }
        }
    }

    public void sortAccountNumber() {
        for (int i = 0; i < customers.size()-1; i++) {
            for (int j = 0; j < customers.size()-1; j++) {
                if (customers.get(j).getAccountNumber().compareTo(customers.get(j+1).getAccountNumber()) <= 0) {
                    BankAccount temp = customers.get(j);
                    customers.set(j, customers.get(j+1));
                    customers.set(j+1, temp);
                }
            }
        }
    }

    public void sortAccountNumber(boolean reverses) {
        for (int i = 0; i < customers.size()-1; i++) {
            for (int j = 0; j < customers.size()-1; j++) {
                if (customers.get(j).getAccountNumber().compareTo(customers.get(j+1).getAccountNumber()) >= 0 && !reverses) {
                    BankAccount temp = customers.get(j);
                    customers.set(j, customers.get(j+1));
                    customers.set(j+1, temp);
                } else if (customers.get(j).getAccountNumber().compareTo(customers.get(j+1).getAccountNumber()) < 0 && reverses) {
                    BankAccount temp = customers.get(j);
                    customers.set(j, customers.get(j+1));
                    customers.set(j+1, temp);
                }
            }
        }
    }

    public ArrayList<BankAccount> searchCustomers(String name) {
       ArrayList<BankAccount> results = new ArrayList<BankAccount>();
       for (BankAccount current : customers) {
           if (current.getName().toLowerCase().contains(name.toLowerCase())) {
               results.add(current);
           }
       }
       return results;
    }

    public ArrayList<BankAccount> savingsRange(double lower, double upper, boolean inclusive){
        ArrayList<BankAccount> results = new ArrayList<BankAccount>();
        for (BankAccount current:customers) {
            if (current.getSavings() >= lower && current.getSavings() <= upper && inclusive) {
                results.add(current);
            } else if (current.getSavings() > lower && current.getSavings() < upper && !inclusive) {
                results.add(current);
            }
        }
        return results;
    }

    public void save() {
        try {
            FileWriter fw = new FileWriter("SavedAccounts.txt");
            BufferedWriter bw = new BufferedWriter(fw);

            for (BankAccount account : customers) {
                bw.write(account.getName() + ", " + account.getAccountNumber() + ", " + account.getSavings() + "\n");
                //System.out.println("Wrote one entry: " + account);
            }

            bw.close();
            fw.close();
        } catch(IOException e) {
            System.out.println("There was an error saving the file and data could not be saved.");
        }
    }

    public void read() {
        ArrayList<BankAccount> temp = new ArrayList<BankAccount>();
        try {
            FileReader fr = new FileReader("SavedAccounts.txt");
            BufferedReader br = new BufferedReader(fr);

            String next = br.readLine();
            while (next != null) {
                String[] split = next.split( ", ", -1);
                String name = split[0];
                String number = split[1];
                double savings = Double.valueOf(split[2]);
                temp.add(new BankAccount(name, number, savings));
                next = br.readLine();
            }

            customers = temp;

        } catch(IOException e) {

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
            System.out.println("--------------------------------------------------");
            System.out.println("Name: " + customer.getName() + "\nAccount#: " + customer.getAccountNumber() + "\nSavings: " + customer.getSavings());
        }
        System.out.println("--------------------------------------------------");
    }
}
