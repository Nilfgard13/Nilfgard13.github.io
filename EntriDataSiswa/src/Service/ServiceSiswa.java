package Service;

import Repository.RepositorySiswa;
import Repository.RepositorySiswa2;

public class ServiceSiswa {
    RepositorySiswa repositorySiswa = new RepositorySiswa();
    RepositorySiswa2 repositorySiswa2 = new RepositorySiswa2();

    public boolean checkLogin(String email, String password){
        if (repositorySiswa2.checkLogin(email, password)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean addSiswa(String name, String email, String Student_number, String password){
        if (repositorySiswa2.addSiswa(name, email, Student_number, password)) {
            return true;
        } else {
            return false;
        }
    }

}
