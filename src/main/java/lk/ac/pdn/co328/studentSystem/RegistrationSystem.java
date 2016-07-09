/*
E/12/302
 */
package lk.ac.pdn.co328.studentSystem;

import java.util.ArrayList;
import java.util.Scanner;

public class RegistrationSystem {
    private static Scanner stdin = new Scanner(System.in);
    private static StudentRegister register = new StudentRegister();

    public static void main(String[] args) {
        System.out.println("Student management system command line version for CO328");
        while (true) {
            try {
                printSelection();
                //int command = Integer.parseInt(stdin.nextLine()); // no need to use parseInt when we can scan a int directly
                int command = stdin.nextInt();
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
        System.out.println("  4 - Search students by name");
        System.out.println("  5 - Clean student register");
        System.out.println("  6 - Get all the students [Feature implementation ongoing]");
        System.out.println("  7 - Save to file/DB [Feature implementation ongoing]");
        System.out.println("  8 - Load from file/DB [Feature implementation ongoing]");
    }

    private static void addStudent() {
        int regNo;
        System.out.println("Enter reg number");
        try {
            //regNo = Integer.parseInt(stdin.nextLine()); Do not need this told you so
            regNo = stdin.nextInt();
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
        int regNo;
        System.out.println("Enter reg number");
        try {
            //regNo = Integer.parseInt(stdin.nextLine()); // not going to tell again
            regNo = stdin.nextInt();
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
        int regNo;
        System.out.println("Enter reg number");
        try {
            //regNo = Integer.parseInt(stdin.nextLine());
            regNo = stdin.nextInt();
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
            System.out.print("First name : " + student.getFirstName() + "\nLast name : " + student.getLastName());
            //System.out.println("Last name : " + student.getLastName()); can do this in a one soutprln
        } else {
            System.out.println("Student not found");
        }
    }

    private static void searchStudentByName() {
        System.out.println("Enter the name you want to search: ");
        String name = stdin.nextLine();
        try {
            ArrayList<Student> students = register.findStudentsByName(name);
            for (Student student : students) {
                System.out.println("ID: " + student.getId() + "First Name: " + student.getFirstName() + "Last Name" + student.getLastName());
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }

    private static void cleanStudentRegister() {
        register.reset(); //clean the regitera
    }
}
