public class BankAccount {
    private String name;
    private String accountNumber;
    private double savings;
    private static int nextAccountNumber = 1;

    public BankAccount (String name, String accountNumber, double savings) {
        this.name = name;
        this.accountNumber = accountNumber;
        this.savings = savings;
    }

    public BankAccount (String name, double savings) {
        this.name = name;
        this.accountNumber = String.format("%06d", nextAccountNumber);
        this.savings = savings;
        nextAccountNumber += 1;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setSavings(double savings) {
        this.savings = savings;
    }

    public String getName() {
        return this.name;
    }

    public String getAccountNumber() {
        return this.accountNumber;
    }

    public double getSavings() {
        return this.savings;
    }

    public String toString() {
        return "Bank Account [Name: " + this.name + ", Account Number: " + this.accountNumber + ", Savings: " + this.savings;
    }
}
