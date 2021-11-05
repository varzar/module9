package task2;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.util.List;

public class Task2Test {
    public static void main(String[] args) {
        String path = "src/main/resources/task2/file.txt";
        File file = new File(path);
        String path2 = "src/main/resources/task2/file2.txt";
        File file2 = new File(path2);
        Task2 readWrite = new Task2();
        List<Person> result = readWrite.getList(file);
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(result);
        readWrite.printToFile(file2, json);
    }
}
