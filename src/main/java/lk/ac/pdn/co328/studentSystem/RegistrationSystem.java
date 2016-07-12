// all functions are implemented

package lk.ac.pdn.co328.studentSystem;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Scanner;

public class RegistrationSystem {

    static Scanner stdin = new Scanner(System.in);
    static StudentRegister register = new StudentRegister();

    public static void main(String[] args) {
        System.out.println("Student management system command line version for CO328");
        while (true) {
            try {
                printSelection();
                int command = Integer.parseInt(stdin.nextLine());
                switch (command) {
                    case 0:
                        return;
                    case 1:
                        addStudent();
                        break;
                    case 2:
                        removeStudent();
                        break;
                    case 3:
                        viewStudent();
                        break;
                    case 4:
                        searchStudentByName();
                        break;
                    case 5:
                        cleanStudentRegister();
                        break;
                    case 6:
                        getAllStudents();
                        break;
                    case 7:
                        saveStudent();
                        break;
                    case 8:
                        loadStudent();
                        break;
                    default:
                        System.out.println("Please select an available feature");
                }
            } catch (Exception ex) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }
    }

    private static void printSelection() {
        System.out.println("Select an option : ");
        System.out.println("  0 - Exit");
        System.out.println("  1 - Add a student");
        System.out.println("  2 - Remove a student");
        System.out.println("  3 - Search a student by registration number");
        System.out.println("  4 - Search students by name [Feature implementation ongoing]");
        System.out.println("  5 - Clean student register [Feature implementation ongoing]");
        System.out.println("  6 - Get all the students [Feature implementation ongoing]");
        System.out.println("  7 - Save to file/DB [Feature implementation ongoing]");
        System.out.println("  8 - Load from file/DB [Feature implementation ongoing]");
    }

    private static void addStudent() {
        int regNo = 0;
        System.out.println("Enter reg number");
        try {
            regNo = Integer.parseInt(stdin.nextLine());
        } catch (Exception ex) {
            System.out.println("Invalid inputs.");
            return;
        }

        System.out.println("Enter first name");
        String firstName = stdin.nextLine();
        System.out.println("Enter last name");
        String lastName = stdin.nextLine();

        Student student = new Student(regNo, firstName, lastName);
        try {
            register.addStudent(student);
        } catch (Exception ex) {
            System.out.println("Error in adding student : " + ex.getMessage());
        }
    }

    private static void removeStudent() {
        int regNo = 0;
        System.out.println("Enter reg number");
        try {
            regNo = Integer.parseInt(stdin.nextLine());
        } catch (Exception ex) {
            System.out.println("Invalid inputs.");
            return;
        }

        try {
            register.removeStudent(regNo);
        } catch (Exception ex) {
            System.out.println("Error in removing student : " + ex.getMessage());
        }
    }

    private static void viewStudent() {
        int regNo = 0;
        System.out.println("Enter reg number");
        try {
            regNo = Integer.parseInt(stdin.nextLine());
        } catch (Exception ex) {
            System.out.println("Invalid inputs.");
            return;
        }

        Student student;
        try {
            student = register.findStudent(regNo);
        } catch (Exception ex) {
            System.out.println("Error in searching student : " + ex.getMessage());
            return;
        }

        if (student != null) {
            System.out.println("First name : " + student.getFirstName());
            System.out.println("Last name : " + student.getLastName());
        } else {
            System.out.println("Student not found");
        }
    }

    private static void searchStudentByName() {
        String name;
        System.out.println("Enter name");
        name = stdin.nextLine();

        ArrayList<Student> student;
        try {
            student = register.findStudentsByName(name);
        } catch (Exception ex) {
            System.out.println("Error in searching student : " + ex.getMessage());
            return;
        }
        int k = 0;
        for (Student stud : student) {
            if (student != null) {
                System.out.print(++k);
                System.out.println("\tFirst name : " + stud.getFirstName());
                System.out.println("\tLast name : " + stud.getLastName());
            } else {
                System.out.println("Student not found");
            }
        }
    }

    private static void cleanStudentRegister() {
        register.reset();
        System.out.println("Student register cleaned successfully.");
    }

    private static void getAllStudents() {
        ArrayList<Integer> regs = register.getAllRegistrationNumbers();
        if (register.isEmpty()) {
            System.out.println("No students in the register currently.");
        }
        for (Integer reg : regs) {
            System.out.println(reg + "\tFirst Name: " + register.findStudent(reg).getFirstName() + " Last Name: " + register.findStudent(reg).getLastName());
        }
    }

    private static void saveStudent() throws FileNotFoundException, UnsupportedEncodingException {
        ArrayList<Integer> regs = register.getAllRegistrationNumbers();
        if (register.isEmpty()) {
            System.out.println("No students in the register currently.");
        }

        String workingDir = System.getProperty("user.dir");
        PrintWriter writer = new PrintWriter(workingDir + "\\students.txt", "UTF-8");

        for (Integer reg : regs) {
            writer.print(reg);
            writer.print(",");
            writer.print(register.findStudent(reg).getFirstName());
            writer.print(",");
            writer.print(register.findStudent(reg).getLastName());
            writer.println();
        }
        writer.close();
        System.out.println("Saved successfully.");
    }

    private static void loadStudent() throws IOException {
        String workingDir = System.getProperty("user.dir");
        String fileName = workingDir + "\\students.txt";

        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            String line;
            while ((line = br.readLine()) != null) {
                String splittedStudent[] = line.split(",");
                Student student = new Student(Integer.parseInt(splittedStudent[0]), splittedStudent[1], splittedStudent[2]);
                try {
                    register.addStudent(student);
                } catch (Exception ex) {
                    System.out.println("Error in adding student : " + ex.getMessage());
                }
            }
            System.out.println("Load students successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
