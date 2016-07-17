package lk.ac.pdn.co328.studentSystem;
import java.util.ArrayList;

public class StudentRegister
{
    private ArrayList<Student> studentList = new ArrayList<Student>();

    public ArrayList<Student> getStudentList() { return studentList; }

    // Adds a new student to the system
    public void addStudent(Student st) throws Exception {
        for (Student student:studentList)
        {
            if(student.getId() == st.getId())
            {
                throw new Exception("StudentID already exists in the register");
            }
        }
        studentList.add(st);
    }

    // Remove a student from the system
    public void removeStudent(int regNo)
    {
        for (int i = 0; i<studentList.size(); i++)
        {
            if(studentList.get(i).getId() == regNo)
            {
                studentList.remove(i);
            }
        }
    }

    //Finds the student with the given registration number
    public Student findStudent(int regNo)
    {
        for (int i = 0; i<studentList.size(); i++)
        {
            if(studentList.get(i).getId() == regNo)
            {
                return studentList.get(i);
            }
        }
        return  null;
    }

    // Cleans all the data from the student register
    public void reset()
    {
        studentList = null;
    }

    // Finds all the students that has the given name as a part of their name.
    public ArrayList<Student> findStudentsByName(String name)
    {
        ArrayList<Student> students = new ArrayList<Student>();
        if(studentList != null) {
            for (int i = 0; i<studentList.size(); i++)
            {
                if(studentList.get(i).getFirstName().contains(name))
                {
                    students.add(studentList.get(i));

                }


                if(studentList.get(i).getLastName().contains(name))
                {
                    students.add(studentList.get(i));
                }
            }
        }
        return students;
    }

    //Gives all the registration numbers of the students.
    public ArrayList<Integer> getAllRegistrationNumbers()
    {
        ArrayList<Integer> regNumbers = new ArrayList<Integer>();
        for (Student student: studentList)
        {
            regNumbers.add(student.getId());
        }
        return  regNumbers;
    }

    // Prints details of all students
    public void printAll() {
        if(studentList.isEmpty() || studentList == null) {
            System.out.println("No records found.");
        } else {
            int size = studentList.size();
            System.out.println(size + " record(s) found.");
            for (int i = 0; i < size; i++) {
                Student student = studentList.get(i);
                System.out.println("id: " + student.getId() + " firstname: " + student.getFirstName() + " lastname: " + student.getLastName());
            }
        }
    }
}
