package Controller;

import java.util.regex.*;
import Service.ServiceSiswa;

public class ControllerSiswa {

    private ServiceSiswa serviceSiswa = new ServiceSiswa();
    final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,100}$";
    final Pattern pattern = Pattern.compile(PASSWORD_PATTERN);
    public boolean checkLogin(String email, String password){
        Matcher matcher = pattern.matcher(password);
        if (matcher.matches() && serviceSiswa.checkLogin(email, password)){
            return true;
        } else {
            return false;
        }
    }

    public void addSiswa(String name, String email, String Student_number, String password){
        Matcher matcher = pattern.matcher(password);
        if (matcher.matches()){
            if (serviceSiswa.addSiswa(name, email, Student_number, password)){
                System.out.println("You have successfully added a new user");
            } else {
                System.out.println("The email has arrived");
            }
        } else {
            System.out.println("Password should be at least 8 characters using numbers, uppercase, lowercase, and symbols");
        }
    }
}
