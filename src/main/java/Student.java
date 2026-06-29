import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Student {
    private ArrayList<Integer> grades;
    private String name;

    //constructor
    public Student(String name){
        this.name = name;
        this.grades = new ArrayList<>();
    }


    //Add grade
    void addGrade(int grade){
        grades.add(grade);
    }

    //calculate student average
    double getAverage(){
        double total = 0;
        for (int mark: grades){
            total+= mark;
        }
        double average;
        if (grades.isEmpty()){
           return average = 0;
        }
        return average = total/grades.size();
    }

    //get student name
    public String getName() {
        return name;
    }

    //get student grades
    public ArrayList<Integer> getGrades() {
        return grades;
    }
}
