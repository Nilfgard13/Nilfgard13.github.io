package Model;

public class Siswa {
    private String name;
    private String email;
    private String Student_number;
    private String password;


    public void setEmail(String email) {
        this.email = email;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setStudent_number(String student_number) {
        Student_number = student_number;
    }

    public String getEmail() {
        return email;
    }
    public String getName() {
        return this.name;
    }

    public String getStudent_number() {
        return this.Student_number;
    }
    public String getPassword() {
        return password;
    }
}