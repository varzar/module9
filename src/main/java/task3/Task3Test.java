package task3;

import java.io.File;

public class Task3Test {
    public static void main(String[] args) {
        String path = "src/main/resources/task3/words.txt";
        File file = new File(path);
        Task3 task3 = new Task3();
        task3.printWordsSortedByFrequency(file);
    }
}
