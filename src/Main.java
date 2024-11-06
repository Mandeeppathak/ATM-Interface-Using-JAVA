
public class Main {
    public static void main(String[] args) {
        User user = new User("John Doe", "1234");
        Authentication auth = new Authentication(user);
        ATMService atmService = new ATMService(user);
        if (auth.login()) {
            atmService.showMenu();
        } else {
            System.out.println("Access Denied.");
        }
    }
}
