package Service;

import Repository.AdminRepository;
/**
 *
 * @author HP
 */
public class AdminService {

    AdminRepository adminRepository = new AdminRepository();

    public <T> boolean checkLogin(T email, T password){
        if (adminRepository.checkLogin(email, password)) {
            return true;
        } else {
            return false;
        }
    }

    public <T> boolean addAdmin (T name, T email, T password){
        if (adminRepository.addAdmin(name, email, password)) {
            return true;
        } else if (adminRepository.checkEmail(email)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean viewAllUser (){
        if (adminRepository.viewAllUser()!=null) {
            return true;
        } else {
            return false;
        }
    }

    public <T> boolean changeStatus(T email) {
        return adminRepository.changeStatusNonActive(email);
    }

}