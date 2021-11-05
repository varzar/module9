package task3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Task3 {
    private HashMap<String, Integer> map;

    public Task3() {
        map = new HashMap<String, Integer>();
    }

    public void printWordsSortedByFrequency(File file){
        checkFileExist(file);
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String data;
            while ((data = bufferedReader.readLine()) != null){
                String [] dataPerson = data.split("\\s+");
                if(data.isEmpty()){
                    continue;
                }
                for (int i = 0; i < dataPerson.length; i++) {
                    if(map.containsKey(dataPerson[i])){
                        int count = map.get(dataPerson[i]);
                        count++;
                        map.put(dataPerson[i], count);
                    }else {
                        map.put(dataPerson[i], 1);
                    }
                }
            }
        }catch (IOException e){
            System.err.println(e.getMessage());
        }
             List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String,Integer>>(){
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });
        for (Map.Entry<String, Integer> entry: list ){
            System.out.println(entry.getKey()  + " " + entry.getValue());
        }
    }

    private void checkFileExist(File file) {
        if(!file.exists()){
            throw new RuntimeException("File with name " + file.getName() + " not exist");
        }
    }
}
