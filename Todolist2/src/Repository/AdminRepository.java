package Repository;

import Model.AdminModel;

import java.util.ArrayList;
//public class AdminRepository {
//    private String[][] userDataList;
//    AdminModel adminModel = new AdminModel();
//    public AdminRepository() {
//        userDataList = new String[0][3]; // Inisialisasi array 2D dengan 3 kolom (name, email, password)
//    }
//
//    public String[][] viewAllUser() {
//        return userDataList;
//    }
//
//    public boolean checkLogin(String email, String password) {
//        for (String[] userData : userDataList) {
//            if (userData[1].equals(email) && userData[2].equals(password)) {
//                return true;
//            }
//        }
//        return false;
//    }
//
//    public void addAdmin(String name, String email, String password) {
//        int length = userDataList.length;
//        String[][] newUserList = new String[length + 1][3];
//
//        for (int i = 0; i < length; i++) {
//            newUserList[i] = userDataList[i];
//        }
//
//        newUserList[length][0] = name;
//        newUserList[length][1] = email;
//        newUserList[length][2] = password;
//
//        userDataList = newUserList;
//    }
//
//    public String[][] changeStatusNonActive(String email) {
//        for (String[] userData : userDataList) {
//            if (userData[1].equals(email)) {
//                userData[3] = "non active";
//                break;
//            }
//        }
//        return userDataList;
//    }
//}

public class AdminRepository<T> {
    private T[][] userDataList;


    public AdminRepository() {
        userDataList = (T[][]) new Object[0][3];
    }

    public T[][] viewAllUser() {
        return userDataList;
    }

    public boolean checkLogin(T email, T password) {
        for (T[] userData : userDataList) {
            if (userData[1].equals(email) && userData[2].equals(password)) {
                return true;
            }
        }
        return false;
    }

    public boolean addAdmin(T name, T email, T password) {
        int length = userDataList.length;
        T[][] newUserList = (T[][]) new Object[length + 1][3];

        for (int i = 0; i < length; i++) {
            newUserList[i] = userDataList[i];
        }

        newUserList[length][0] = name;
        newUserList[length][1] = email;
        newUserList[length][2] = password;

        userDataList = newUserList;

        return true;
    }

    public boolean changeStatusNonActive(T email) {
        for (T[] userData : userDataList) {
            if (userData[1].equals(email)) {
                T in = (T) "non active";
                userData[3] = in;
                return true;
            }
        }
        return false;
    }

    public boolean checkEmail(T email) {
        for (T[] userData : userDataList) {
            if (userData[1].equals(email)) {
                return false;
            }
        }
        return true;
    }
}