package Model;

public class UserModel {
    private static String id, name, status, role, todo;

    public static String getTodo() {
        return todo;
    }

    public static void setTodo(String todo) {
        UserModel.todo = todo;
    }

    public static String getId() {
        return id;
    }

    public static void setId(String id) {
        UserModel.id = id;
    }

    public static String getName() {
        return name;
    }

    public static void setName(String name) {
        UserModel.name = name;
    }

    public static String getStatus() {
        return status;
    }

    public static void setStatus(String status) {
        UserModel.status = status;
    }

    public static String getRole() {
        return role;
    }

    public static void setRole(String role) {
        UserModel.role = role;
    }
}
