package Service;

import Repository.UserRepository;

import java.util.ArrayList;
import java.util.Collection;
import Model.toDo;

public class UserService {
    UserRepository userRepository = new UserRepository();

    public boolean checkLogin(String email, String password) {
        return userRepository.checkLogin(email, password);
    }

    public boolean addUser(String name, String email, String password) {
        return userRepository.addUser(name, email, password) && userRepository.checkEmail(email);
    }

    public void addToDo(String ToDo) {
        if (userRepository.addToDo(ToDo)) {
            System.out.println("You have successfully added your To Do List");
        } else {
            System.out.println("You failed to add To Do List");
        }
    }

    public ArrayList<String> viewAllToDo() {
        ArrayList<String> toDoList = userRepository.viewAllToDo();
        if (toDoList != null) {
            for (int i = 0; i < toDoList.size(); i++) {
                System.out.println(i + 1 + ". " + toDoList.get(i));
            }
            System.out.println("Total To Do: " + getTotal(toDoList));
            System.out.println("\nYou Successfully Show To Do List");
        } else {
            System.out.println("You failed to View To Do List");
        }
        return toDoList;
    }

    public int getTotal(Collection<?> datas) {
        return userRepository.getTotal(datas);
    }
}
