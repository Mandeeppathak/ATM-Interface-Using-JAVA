
public class User {
    private String name;
    private String encryptedPIN;
    private double balance;

    public User(String name, String pin) {
        this.name = name;
        this.encryptedPIN = EncryptionUtil.encryptPIN(pin);
        this.balance = 1000.00;
    }

    public String getName() { return name; }
    public String getEncryptedPIN() { return encryptedPIN; }
    public double getBalance() { return balance; }

    public void deposit(double amount) { balance += amount; }
    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
        } else {
            System.out.println("Insufficient balance!");
        }
    }
}
