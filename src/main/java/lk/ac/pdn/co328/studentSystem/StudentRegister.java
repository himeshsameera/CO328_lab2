/*
E/12/302
 */
package lk.ac.pdn.co328.studentSystem;
import java.util.ArrayList;

public class StudentRegister
{
    private ArrayList<Student> studentList = new ArrayList<Student>();


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
        for (Student aStudentList : studentList) {
            if (aStudentList.getId() == regNo) {
                return aStudentList;
            }
        }

        System.out.println("No Student found to that ID");
        return  null;
    }

    // Cleans all the data from the student register
    public void reset()
    {
        studentList.clear();
        //studentList = null;
    }

    // Finds all the students that has the given name as a part of their name.
    public ArrayList<Student> findStudentsByName(String name) throws Exception
    {
        ArrayList<Student> students = new ArrayList<Student>();
        for (Student aStudentList : studentList) {
            if (aStudentList.getFirstName().contains(name)) {
                students.add(aStudentList);
            }


            if (aStudentList.getLastName().contains(name)) {
                students.add(aStudentList);
            }
        }
        if(students.isEmpty()) throw new Exception("No Students found with the given name");
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

    public boolean isempty(){
        return studentList.isEmpty();
    }
}
