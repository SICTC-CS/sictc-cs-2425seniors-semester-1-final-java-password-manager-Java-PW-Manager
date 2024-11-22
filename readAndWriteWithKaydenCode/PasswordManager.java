import java.util.*;
import java.io.FileWriter; 
import java.io.FileReader; 
import java.io.IOException; 
import java.io.FileNotFoundException;  

public class PasswordManager {

    private static Scanner scanner = new Scanner(System.in);
    private static boolean isLoggedIn = false;
    private static ArrayList <String> passwords = new ArrayList<>();
    private static ArrayList <String> users = new ArrayList<>();
    private static String loggedInUser = "";

    public static void main(String[] args) throws IOException{
        System.out.println("Welcome to the Password Manager!");

        // This is for Loading any and all existing accounts
        String file = DataPersistence.read();

        // While statement for the Login and Registering the user accounts 
        while (!isLoggedIn) {
            System.out.println("Please login or create a new account:");
            System.out.println("1. Login");
            System.out.println("2. Register");
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                login();
            } else if (choice == 2) {
                register();
            }
        }

        // Menu That will be shown after the person logs in 
        while (isLoggedIn) {
            showMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume the newline
            handleMenuChoice(choice);
        }
    }

    public static void login() throws IOException{
        System.out.println(DataPersistence.getUsernames()+"\n");
        System.out.println(DataPersistence.getPasswords());
    }

    public static void register() {
        
    }

    public static void showMenu() {
        System.out.println("\nWelcome " + loggedInUser + "!");
        System.out.println("1. Add a new account");
        System.out.println("2. View all accounts");
        System.out.println("3. View accounts by category");
        System.out.println("4. Modify an account");
        System.out.println("5. Delete an account");
        System.out.println("6. Generate a password");
        System.out.println("7. Logout");
        System.out.print("Choose an option: ");
    }

    public static void handleMenuChoice(int choice) {
        switch (choice) {
            case 1:
                addAccount();
                break;
            case 2:
                //AccountManager.listAccounts();
                break;
            case 3:
                viewAccountsByCategory();
                break;
            case 4:
                modifyAccount();
                break;
            case 5:
                deleteAccount();
                break;
            case 6:
                generatePassword();
                break;
            case 7:
                logout();
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }

    public static void addAccount() {
        
    }

    public static void viewAccountsByCategory() {

    }

    public static void modifyAccount() {
        
    }

    public static void deleteAccount() {
        
    }

    public static void generatePassword() {
        //String password = PasswordGenerator.generatePassword();
        //System.out.println("Generated password: " + password);
    }

    public static void logout() {
        //System.out.println("Logging out...");
        //isLoggedIn = false;
        //loggedInUser = "";
        // OStack overflow said we could but save the user data
        //DataPersistence.saveToFile();
    }
}
