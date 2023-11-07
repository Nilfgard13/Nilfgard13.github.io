package Controller;

import Service.UserService;

import java.util.Collection;
import java.util.regex.*;

public class UserController {
    private UserService userService = new UserService();
    final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,100}$";
    final Pattern pattern = Pattern.compile(PASSWORD_PATTERN);

    public boolean checkLogin(String email, String password) {
        Matcher matcher = pattern.matcher(password);
        if (matcher.matches() && userService.checkLogin(email, password)){
            return true;
        } else {
            return false;
        }
    }

    public void addUser(String name, String email, String password){
        Matcher matcher = pattern.matcher(password);
        if (matcher.matches()){
            if (userService.addUser(name, email, password)){
                System.out.println("You have successfully added a new user");
            } else {
                System.out.println("The email has arrived");
            }
        } else {
            System.out.println("Password should be at least 8 characters using numbers, uppercase, lowercase, and symbols");
        }
    }

    public void addToDo(String ToDo){
        if (ToDo.length() >= 50){
            System.out.println("To Do Minimal 50 characters");
        } else {
            userService.addToDo(ToDo);
        }
    }

    public void viewAllToDo() {
        userService.viewAllToDo();
    }
}

