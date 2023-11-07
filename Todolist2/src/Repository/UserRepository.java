package Repository;

import java.util.ArrayList;
import java.util.Collection;

public class UserRepository {
    private ArrayList<String[]> userDataList;
    private ArrayList<String> toDoList;

    public UserRepository() {
        userDataList = new ArrayList<>();
        toDoList = new ArrayList<>();
    }

    public boolean checkLogin(String email, String password) {
        for (String[] userData : userDataList) {
            if (userData[1].equals(email) && userData[2].equals(password)) {
                return true;
            }
        }
        return false;
    }

    public boolean addUser(String name, String email, String password) {
        String[] newUser = {name, email, password};
        userDataList.add(newUser);
        return true;
    }

    public boolean checkEmail(String email) {
        for (String[] userData : userDataList) {
            if (userData[1].equals(email)) {
                return false;
            }
        }
        return true;
    }

    public boolean addToDo(String toDo) {
        toDoList.add(toDo);
        return true;
    }

    public ArrayList<String> viewAllToDo() {
        return toDoList;
    }

    public int getTotal(Collection<?> datas) {
        return datas.size();
    }
}