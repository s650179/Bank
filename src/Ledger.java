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
                if (customers.get(j).getAccountNumber().compareTo(customers.get(j+1).getAccountNumber()) <= 0 && !reverses) {
                    BankAccount temp = customers.get(j);
                    customers.set(j, customers.get(j+1));
                    customers.set(j+1, temp);
                } else if (customers.get(j).getAccountNumber().compareTo(customers.get(j+1).getAccountNumber()) > 0 && reverses) {
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
           if (current.getName().equals(name)) {
               results.add(current);
           }
       }
       return results;
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
