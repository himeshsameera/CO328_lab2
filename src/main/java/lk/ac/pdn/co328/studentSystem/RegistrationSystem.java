package lk.ac.pdn.co328.studentSystem;
import java.util.ArrayList;
import java.util.Scanner;

public class RegistrationSystem
{
    static Scanner stdin = new Scanner(System.in);
    static StudentRegister register = new StudentRegister();
    public static void main(String[] args)
    {
        System.out.println("Student management system command line version for CO328");
        while(true)
        {
            try
            {
                printSelection();
                int command = Integer.parseInt(stdin.nextLine());
                switch (command)
                {
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
                        findStudentsByName();
                        break;
                    case 5:
                        cleanStudentRegister();
                        break;
                    case 6:
                        getAllRegistrationNumbers();
                        break;
                    default:
                        System.out.println("Please select an available feature");
                }
            }
            catch(Exception ex)
            {
                System.out.println("Invalid input. Please enter a number.");
            }
        }
    }



    private static void printSelection()
    {
        System.out.println("Select an option : ");
        System.out.println("  0 - Exit");
        System.out.println("  1 - Add a student");
        System.out.println("  2 - Remove a student");
        System.out.println("  3 - Search a student by registration number");
        System.out.println("  4 - Search students by name ");
        System.out.println("  5 - Clean student register ");
        System.out.println("  6 - Get all the students ");
        System.out.println("  7 - Save to file/DB [Feature implementation ongoing]");
        System.out.println("  8 - Load from file/DB [Feature implementation ongoing]");
    }

    private static void addStudent()
    {
        int regNo = 0;
        System.out.println("Enter reg number");
        try
        {
            regNo = Integer.parseInt(stdin.nextLine());
        }
        catch (Exception ex)
        {
            System.out.println("Invalid inputs.");
            return;
        }

        System.out.println("Enter first name");
        String firstName = stdin.nextLine();
        System.out.println("Enter last name");
        String lastName = stdin.nextLine();

        Student student = new Student(regNo,firstName,lastName);
        try
        {
            register.addStudent(student);
        }
        catch (Exception ex)
        {
            System.out.println("Error in adding student : " + ex.getMessage());
        }
    }

    private static void removeStudent()
    {
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

    private static void viewStudent()
    {
        int regNo = 0;
        System.out.println("Enter reg number");
        try
        {
            regNo = Integer.parseInt(stdin.nextLine());
        }
        catch (Exception ex)
        {
            System.out.println("Invalid inputs.");
            return;
        }

        Student student;
        try
        {
            student = register.findStudent(regNo);
        }
        catch (Exception ex)
        {
            System.out.println("Error in searching student : " + ex.getMessage());
            return;
        }

        if(student != null)
        {
            System.out.println("First name : " + student.getFirstName());
            System.out.println("Last name : " + student.getLastName());
        }
        else
        {
            System.out.println("Student not found");
        }
    }

    private static void findStudentsByName() {

        ArrayList<Student> students = new ArrayList<Student>();
        System.out.println("Enter the name:");
        String name = stdin.nextLine();

        try {
            students = register.findStudentsByName(name);
        }catch (Exception ex) {
            System.out.println("Errors happening when searching students by name: " + ex.getMessage());
            return;
        }

        for (Student student: students) {
            System.out.println("Student ID : " + student.getId());
        }
    }

    private static void cleanStudentRegister() {
        try {
            register.reset();
        } catch (Exception ex) {
            System.out.println("Error in removing data from the register: " + ex.getMessage());
            return;
        }
    }

    private static void getAllRegistrationNumbers() {

        ArrayList<Integer> allregNums = new ArrayList<Integer>();
        try {
            allregNums = register.getAllRegistrationNumbers();
            //System.out.println(" List of reg_nums: ");
            // let us print all the elements available in list
            for (Integer number : allregNums) {
                System.out.println(number);
            }
        }catch(Exception ex){
            System.out.println(ex.getMessage());
            return;
        }

    }
}
