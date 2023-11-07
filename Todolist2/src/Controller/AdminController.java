package Controller;

import Service.AdminService;
import java.util.regex.*;

/**
 *
 * @author HP
 */
public class AdminController {
    private AdminService adminservice = new AdminService();
    final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,100}$";
    final Pattern pattern = Pattern.compile(PASSWORD_PATTERN);

    public <T> boolean checkLogin(T email, T password) {
        Matcher matcher = pattern.matcher(password.toString());
        if (matcher.matches() && adminservice.checkLogin(email, password)){
            return true;
        } else {
            return false;
        }
    }

    public <T> void addAdmin(T name, T email, T password){
        Matcher matcher = pattern.matcher(password.toString());
        if (matcher.matches()){
            if (adminservice.addAdmin(name, email, password)){
                System.out.println("You have successfully added a new Admin");
            } else {
                System.out.println("The email has arrived ");
            }
        } else {
            System.out.println("password of at least 8 characters using numbers, uppercase, lowercase and symbols");
        }
    }

    public void viewUser(){
        if (adminservice.viewAllUser()){
            System.out.println("Successfully displayed all");
        } else {
            System.out.println("Unsuccessful displaying all users");
        }
    }

    public <T> void changeStatus(T email){
        if (adminservice.changeStatus(email)){
            System.out.println("Successfully changed user status");
        } else {
            System.out.println("Unsuccessful changing user status");
        }
    }
}
