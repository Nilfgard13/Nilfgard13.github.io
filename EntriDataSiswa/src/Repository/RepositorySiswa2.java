package Repository;

import Model.Siswa;

public class RepositorySiswa2 {
    private Stack stack;
    Siswa s = new Siswa();

    public RepositorySiswa2() {
        stack = new Stack(100);
    }

    public boolean checkLogin(String email, String password) {
        Stack tempStack = new Stack(100);
        boolean loginSuccess = false;

        while (!stack.isEmpty()) {
            String dataSiswa = stack.pop();
            String[] userData = dataSiswa.split(" ");

            String storedEmail = userData[1];
            String storedPassword = userData[3];

            if (email.equals(storedEmail) && password.equals(storedPassword)) {
                loginSuccess = true;
                break;
            } else {
                tempStack.push(dataSiswa);
            }
        }

        while (!tempStack.isEmpty()) {
            stack.push(tempStack.pop());
        }

        return loginSuccess;
    }

    public boolean addSiswa(String name, String email, String student_number, String password) {
        String dataSiswa = name + " " + email + " " + student_number + " " + password;
        stack.push(dataSiswa);
        return true;
    }


}

class Stack {
    private int maxSize;
    private String[] stackArray;
    private int top;

    public Stack(int size) {
        maxSize = size;
        stackArray = new String[maxSize];
        top = -1;
    }

    public void push(String item) {
        if (!isFull()) {
            stackArray[++top] = item;
        } else {
            System.out.println("Stack is full. Cannot push.");
        }
    }

    public String pop() {
        if (!isEmpty()) {
            return stackArray[top--];
        } else {
            System.out.println("Stack is empty. Cannot pop.");
            return null;
        }
    }

    public boolean isEmpty() {
        return (top == -1);
    }

    public boolean isFull() {
        return (top == maxSize - 1);
    }
}
