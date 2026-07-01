import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class StudentManagement {
    private HashMap<String, Student> students;

    public StudentManagement(){
        this.students = new HashMap<>();
    }

    public void run(){
        FileHandler fileHandler = new FileHandler();
        fileHandler.loadFromFile(students);
        Scanner scanner = new Scanner(System.in);

        while (true){
            try {
                //System.out.println("***Here are your options***");

                System.out.println("╔═════════════════════════════════════╗");
                System.out.println("║     STUDENT MANAGEMENT SYSTEM       ║");
                System.out.println("║═════════════════════════════════════║");
                System.out.println("║1. Add student                       ║");
                System.out.println("║2. Add grade to student              ║");
                System.out.println("║3. View all students and grades      ║");
                System.out.println("║4. View a specific student's report  ║");
                System.out.println("║5. Remove student                    ║");
                System.out.println("║6. Get top performer                 ║");
                System.out.println("║7. Exit                              ║");
                System.out.println("╚═════════════════════════════════════╝");
                System.out.println("Choose your option: ");

                int option = Integer.parseInt(scanner.nextLine());
                if (option == 1){
                    System.out.println("Enter student name: ");
                    String name = scanner.nextLine().toLowerCase();
                    addStudent(name);
                } else if (option == 2) {
                    System.out.println("Enter student name: ");
                    String name = scanner.nextLine().toLowerCase();
                    System.out.println("Enter student mark: ");
                    int mark = Integer.parseInt(scanner.nextLine());
                    addGrade(name,mark);

                } else if (option == 3) {
                    viewAll();

                } else if (option == 4) {
                    System.out.println("Enter student name: ");
                    String name = scanner.nextLine().toLowerCase();
                    viewStudent(name);
                } else if (option == 5) {
                    System.out.println("Enter student name: ");
                    String name = scanner.nextLine().toLowerCase();
                    removeStudent(name);
                } else if (option == 6) {
                    topPerformer();
                } else {
                    fileHandler.saveToFile(students);
                    exitSystem();
                }
            }catch (NumberFormatException e){
                System.out.println("Invalid option");
            }catch (InputMismatchException e){
                System.out.println("Invalid input");
        }
        }

    }
    void addStudent(String name){
        Student student = new Student(name);
        if (!students.containsKey(name)){
            //add the student name with a new list
            students.put(name, student);
        }else {
            System.out.println("Name already taken!");
        }
    }

    void addGrade(String name, int mark){
        //check student's name and add mark
        if (students.containsKey(name)) {
            if (mark >= 0 && mark <= 100){
                students.get(name).addGrade(mark);
            }else {
                System.out.println("Mark must be between 0 and 100");
            }
        }else {
            System.out.println("Student not found");
        }
    }
    void viewAll(){
        for (Map.Entry<String, Student> entry : students.entrySet()){
            Student student = entry.getValue();
            ArrayList<Integer> grades = student.getGrades();

            double average = student.getAverage();
            System.out.println("Student: "+ entry.getKey());
            System.out.println("Grades: "+ grades);
            System.out.println("Average: " + average);
        }
    }
    void viewStudent(String name){
        if (students.containsKey(name)){
            Student student = students.get(name);
            ArrayList<Integer> grades = student.getGrades();

            //calculate the sum of grades
            double average = student.getAverage();
            System.out.println("Student: "+ name);
            System.out.println("Grades: " + grades);
            System.out.println("Average: " + average);
        }else {
            System.out.println("Student not found");
        }
    }

    void removeStudent(String name){
        if (students.remove(name) != null){
            System.out.println("Student removed");
        }else {
            System.out.println("Student not found");
        }
    }

    void topPerformer(){
        double highest = Integer.MIN_VALUE;
        String topStudent = null;
        for (Map.Entry<String, Student> entry: students.entrySet()){
            Student student = entry.getValue();

            //get average
            double average = student.getAverage();

            //find top student
                if (average > highest){
                    highest = average;
                    topStudent = entry.getKey();
            }
        }
        if (topStudent != null){
            System.out.println("The top student is: "+ topStudent +",with an average of:" + highest);
        }else {
            System.out.println("Top student not found");
        }

    }
    void exitSystem(){
        System.exit(0);
    }

}
