import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class FileHandler {
    void saveToFile(HashMap<String, Student> students){
        try{
            FileWriter myWriter = new FileWriter("StudentData.csv");
            myWriter.write("Name,Grade\n");
            for (Map.Entry<String, Student> entry: students.entrySet()){
                String line = entry.getKey();
                for (int mark: entry.getValue().getGrades()){
                    line += "," + mark;
                }
                myWriter.write(line + "\n");
            }
            myWriter.close();
            System.out.println("Data saved successfully");
        }catch (Exception e){
            System.out.println("Error");
        }
    }

//    void loadFromFile(HashMap<String, Student> students){
//
//        try(BufferedReader read = new BufferedReader(new FileReader("StudentData.csv"))) {
//            read.readLine();
//            String line;
//            while (line = read.readLine() != null){
//                //split into several parts
//                String[] parts = line.split(",");
//                String name = parts[0];
//                Student student = new Student(name);
//
//                for (int i = 1; i < parts.length; i++){
//                    student.addGrade(i);
//                }
//                students.put(student);
//
//            }
//
//        }catch (IOException e){
//            System.out.println("Error reading file");
//        }
//    }
}
