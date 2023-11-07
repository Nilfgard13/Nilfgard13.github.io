package View;

import Controller.AdminController;
import Model.AdminModel;
import java.util.Scanner;

/**
 *
 * @author HP
 */
public class AdminView {

    AdminModel adminModel = new AdminModel();
    AdminController adminController = new AdminController();
    Scanner scanner = new Scanner(System.in);

    public void showLogin() {
        boolean logIn = true;
        while (logIn) {
            System.out.println("\t\t----- LOGIN -----");
            System.out.print("Email: ");
            String email = scanner.nextLine();
            System.out.print("Password: ");
            String password = scanner.nextLine();
            System.out.println();
            if (adminController.checkLogin(email, password)) {
                if (adminModel.getRole().equals("Admin")){
                    showMenuAdmin();
                    logIn = false;
                } else {
                    System.out.println("Login failed. Invalid credentials.");
                }
            } else {
                System.out.println("Login failed. Invalid credentials.");
            }
        }
    }

    public void showMenuAdmin() {
        boolean loggedIn = true;
        while (loggedIn) {
            System.out.println("\nAdmin Menu:");
            System.out.println("Halo, " + adminModel.getName() + "\t\tStatus: " + adminModel.getStatus());
            System.out.println("1. Add Admin");
            System.out.println("2. View All Users");
            System.out.println("3. Change User Status");
            System.out.println("4. Logout");
            System.out.print("Enter your choice: ");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    System.out.print("\nName: ");
                    String name = scanner.nextLine();
                    System.out.print("Email: ");
                    String email = scanner.nextLine();
                    System.out.print("Password: ");
                    String password = scanner.nextLine();
                    adminController.addAdmin(name, email, password);
                    break;
                case 2:
                    adminController.viewUser();
                    break;
                case 3:
                    System.out.print("Email: ");
                    String email1 = scanner.nextLine();
                    adminController.changeStatus(email1);
                    break;
                case 4:
                    loggedIn = false;
                    System.out.println("Logged out.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public static void main(String[] args) {
        AdminView adminView = new AdminView();
        adminView.showLogin();
    }
}
