package View;

import Controller.UserController;
import Model.UserModel;
import java.util.Scanner;

public class UserView {
    UserModel userModel = new UserModel();
    UserController userController = new UserController();
    Scanner scanner = new Scanner(System.in);

    public void firstMenu(){
        boolean flag = true;
        while (flag) {
            System.out.println("1. Log In");
            System.out.println("2. Sign Up");
            System.out.print("Enter your choice: ");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    showLogin();
                    flag = false;
                    break;
                case 2:
                    showSignUp();
                    flag = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public void showLogin() {
        System.out.println("Don't have an account? (y/n)");
        String choice = scanner.nextLine();
        switch (choice){
            case "y":
                showSignUp();
                break;
            case "n":
                boolean logIn = true;
                while (logIn) {
                    System.out.println("\t\t----- LOG IN -----");
                    System.out.print("Email: ");
                    String email = scanner.nextLine();
                    System.out.print("Password: ");
                    String password = scanner.nextLine();
                    System.out.println();
                    if (userController.checkLogin(email, password)) {
                        if (userModel.getRole().equals("User")){
                            showMenuUser();
                            logIn = false;
                        } else {
                            System.out.println("Login failed. Invalid credentials.");
                        }
                    } else {
                        System.out.println("Login failed. Invalid credentials.");
                    }
                }
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }

    public void showSignUp(){
        System.out.println("Have an account? (y/n)");
        String choice = scanner.nextLine();
        switch (choice){
            case "y":
                showLogin();
                break;
            case "n":
                System.out.println("\t\t----- SIGN UP -----");
                System.out.print("\nName: ");
                String name = scanner.nextLine();
                System.out.print("Email: ");
                String email = scanner.nextLine();
                System.out.print("Password: ");
                String password = scanner.nextLine();
                userController.addUser(name, email, password);
                System.out.println("You will switch to the Log In menu");
                showLogin();
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }

    public void showMenuUser() {
        boolean loggedIn = true;
        while (loggedIn) {
            System.out.println("\nUser Menu:");
            System.out.println("Hello, " + userModel.getName() + "\t\tStatus: " + userModel.getStatus());
            System.out.println("1. Add To Do");
            System.out.println("2. View All To Do");
            System.out.println("3. Logout");
            System.out.print("Enter your choice: ");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    System.out.println("Input To Do");
                    String toDo = scanner.nextLine();
                    userController.addToDo(toDo);
                    break;
                case 2:
                    userController.viewAllToDo();
                    break;
                case 3:
                    loggedIn = false;
                    System.out.println("Logged out.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public static void main(String[] args) {
        UserView userView = new UserView();
        userView.firstMenu();
    }
}
