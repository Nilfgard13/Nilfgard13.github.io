package View;

import Controller.ControllerSiswa;
import Repository.RepositorySiswa;
import Repository.RepositorySiswa2;
import Model.Siswa;
import java.util.Scanner;

public class ViewStudent {

    Scanner scanner = new Scanner(System.in);
    ControllerSiswa controllerSiswa = new ControllerSiswa();
    Siswa siswa = new Siswa();
    RepositorySiswa repositorySiswa = new RepositorySiswa();
    RepositorySiswa2 repositorySiswa2 = new RepositorySiswa2();

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
                    if (controllerSiswa.checkLogin(email, password)) {
                        showMenuUser();
                        logIn = false;
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
                System.out.print("NIM: ");
                String Student_number = scanner.nextLine();
                System.out.print("Password: ");
                String password = scanner.nextLine();
                controllerSiswa.addSiswa(name, email, Student_number, password);
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
                //System.out.println("Hello, " + siswa.getName() + "\t\tNIM: " + siswa.getStudent_number());
                System.out.println("Congratulation you have successfully Login :)");

                System.out.println("Type 'y' for exit");
                String choice = scanner.nextLine();
                if(choice.equals("y")){
                    break;
                }
            }
        }


    public static void main(String[] args) {
        ViewStudent StudentView = new ViewStudent();
        StudentView.firstMenu();
    }
}
