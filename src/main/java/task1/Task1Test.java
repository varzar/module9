package task1;

import java.io.*;

public class Task1Test {
    public static void main(String[] args) {
        String path = "src/main/resources/task1/file.txt";
        File file = new File(path);
        Task1 task1 = new Task1();
        task1.getValidNumbers(file);
    }
}
