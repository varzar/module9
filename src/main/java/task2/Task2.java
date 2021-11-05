package task2;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Task2 {
    private List<Person> people;

    public Task2() {
        this.people = new ArrayList<>();;
    }

    public List<Person> getList(File file){
        checkFileExist(file);
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String data;
            while ((data = bufferedReader.readLine()) != null){
                String [] dataPerson = data.split(" ");
                if(data.isEmpty()){
                    continue;
                }
                if (!(dataPerson[1].toString().matches("-?\\d+"))){
                    continue;
                }
                Person person = new Person(dataPerson[0], Integer.parseInt(dataPerson[1]));
                people.add(person);
            }
        }catch (IOException e){
            System.err.println(e.getMessage());
        }
        return people;
    }

    public void printToFile(File file, String json){
        checkFileAvailable(file);
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            writer.write(json);
        }catch (IOException e){
            System.err.println(e.getMessage());
        }
    }

    private void checkFileExist(File file) {
        if(!file.exists()){
            throw new RuntimeException("File with name " + file.getName() + " not exist");
        }
    }

    private  void checkFileAvailable(File file) {
        if(!file.exists()){
            file.getParentFile().mkdirs();
            try {
                file.createNewFile();
            }catch (IOException e){
                System.err.println(e.getMessage());
            }
        }
    }
}
