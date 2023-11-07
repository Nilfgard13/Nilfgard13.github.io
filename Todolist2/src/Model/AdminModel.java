package Model;

public class AdminModel {
    private static String name, status, role;

    public AdminModel(){

    }

    public static String getName() {
        return name;
    }

    public static void setName(String name) {
        AdminModel.name = name;
    }

    public static String getStatus() {
        return status;
    }

    public static void setStatus(String status) {
        AdminModel.status = status;
    }

    public static String getRole() {
        return role;
    }

    public static void setRole(String role) {
        AdminModel.role = role;
    }
}
