
import java.util.Scanner;

public class Authentication {
    private static final int MAX_ATTEMPTS = 3;
    private int failedAttempts = 0;
    private User user;
    private Scanner scanner;

    public Authentication(User user) {
        this.user = user;
        this.scanner = new Scanner(System.in);
    }

    public boolean login() {
        while (failedAttempts < MAX_ATTEMPTS) {
            System.out.print("Enter PIN: ");
            String enteredPIN = scanner.nextLine();
            if (EncryptionUtil.verifyPIN(enteredPIN, user.getEncryptedPIN())) {
                System.out.println("Login successful!");
                return true;
            } else {
                failedAttempts++;
                System.out.println("Incorrect PIN. Attempts left: " + (MAX_ATTEMPTS - failedAttempts));
            }
        }
        System.out.println("Account locked due to too many failed attempts.");
        return false;
    }
}
