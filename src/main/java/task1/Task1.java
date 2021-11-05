package task1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Pattern;

public class Task1 {
    public void getValidNumbers(File file){
        checkFileExist(file);
        String regex = "^\\([0-9]{3}\\) [0-9]{3}-[0-9]{4}|^[0-9]{3}-[0-9]{3}-[0-9]{4}";
        Pattern pattern = Pattern.compile(regex);
        try(BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line = reader.readLine();
            while (line != null){
                if (pattern.matcher(line).matches()){
                    System.out.println(line);
                }
                line = reader.readLine();
            }
        }catch (IOException e){
            System.err.println(e.getMessage());
        }
    }

    private void checkFileExist(File file) {
        if(!file.exists()){
            throw new RuntimeException("File with name " + file.getName() + " not exist");
        }
    }
}
