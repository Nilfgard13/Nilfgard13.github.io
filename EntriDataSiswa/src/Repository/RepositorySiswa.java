package Repository;

public class RepositorySiswa {
    public String[][] userDataList;

    public RepositorySiswa() {
        userDataList = new String[0][4];
    }
    public boolean checkLogin(String email, String password){
        for (String[] userData : userDataList) {
            if (userData[1].equals(email) && userData[3].equals(password)) {
                return true;
            }
        }
        return false;
    }

    public boolean addSiswa(String name, String email, String Student_number, String password){
        int length = userDataList.length;
        String[][] newUserList = new String[length + 1][4];

        for (int i = 0; i < length; i++) {
            newUserList[i] = userDataList[i];
        }

        newUserList[length][0] = name;
        newUserList[length][1] = email;
        newUserList[length][2] = Student_number;
        newUserList[length][3] = password;

        userDataList = newUserList;

        return true;
    }
}
