/*
E/12/302
 */

package lk.ac.pdn.co328.studentSystem;
import org.junit.*;
import java.util.ArrayList;

public class StudentRegisterTest {
    private StudentRegister register;

    @Before
    public void setupTest()
    {
        System.out.println("A new test is starting.");
        register = new StudentRegister();
        try
        {
            register.addStudent(new Student(1, "ruwan", "tharaka"));
            register.addStudent(new Student(2, "nirmal", "madushanka"));
            register.addStudent(new Student(3, "gayan", "chamara"));
            register.addStudent(new Student(4, "srimal", "farnando"));
            register.addStudent(new Student(5, "sanath", "jayasooriya"));
            register.addStudent(new Student(6, "lahiru", "lakshitha"));
            register.addStudent(new Student(7, "naruto", "uzumaki"));
            register.addStudent(new Student(8, "light", "yagami"));
            register.addStudent(new Student(9, "lahiru", "kasun"));
            register.addStudent(new Student(10, "sahan", "lahiru"));

        }
        catch (Exception ex)
        {
            Assert.fail("Adding student failed");
        }

    }

    @After
    public void finishTest()
    {
        System.out.println("Test finished\n");
    }

    @BeforeClass
    public  static void beforeClass()
    {
        System.out.println(" by Evaluating test cases in StudentRegisterTest.java");
    }

    @AfterClass
    public static void afterClass()
    {
        System.out.println("All tests are done");
    }

    @Test
    public void testAddStudent()
    {
       System.out.println("Testing addStudent method");
       try
       {
           register.addStudent(new Student(11, "nimal", "kumara"));
           register.addStudent(new Student(12, "fawzan", "mohomad"));

       }
       catch (Exception ex)
       {
           Assert.fail("Adding student failed");
       }

       Student student = register.findStudent(5);
       Assert.assertEquals("Student Id is wrong",5,student.getId());
       student = register.findStudent(2);
       Assert.assertEquals("Student Id is wrong",2,student.getId());
   }

    @Test
    public void testAddStudentTwice() {
       /* Implement your test code here. Adding a student with same registration number twice should generate an exception.
       Test case is not yet implemented for adding student twice. So it is set to fail always*/

       System.out.println("Testing testAddStudentTwice method");
       try {
           register.addStudent(new Student(6, "fawzan", "mohomad"));
       } catch (Exception ex) {

           if(ex.getMessage().equals("StudentID already exists in the register")) {
           //if(ex.equals(ex)) {
               System.out.println(ex.getMessage());
           }else{
               Assert.fail("Adding students failed : students with same id already exists");
           }
       }

   }

    @Test
    public void testRemoveStudent()
    {

        System.out.println("Testing removeStudent method");
        register.removeStudent(1);
        Student student = register.findStudent(1);
        Assert.assertNull("student was not removed",student);
        //also we can do this by below line same thin sugar
        //Assert.assertEquals("student was not removed",null,student);
    }

    @Test
    public void testGetRegNumbers()
    {
        System.out.println("Testing getAllRegistrationNumbers method");
        ArrayList<Integer> numbers = register.getAllRegistrationNumbers();
        ArrayList<Integer> expected = new ArrayList<Integer>();
        for(int i = 1; i<=10; i++)
             expected.add(i);
        Assert.assertTrue(numbers.equals(expected));
    }

    @Test
    public void testFindStudentsByName()
    {
        System.out.println("Testing findStudentsByName method");
        ArrayList<Student> students = null;
        try {
            students = register.findStudentsByName("lahiru");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        int count = 0;
        if(!students.isEmpty()) for (Student student : students) {
            if (student.getFirstName().equals("lahiru") || student.getLastName().equals("lahiru"))
                count++;
        }
        Assert.assertEquals("Find of the student by name does no happen accordinly",3,count);
        //we added 3 students who has their last name or first name with "lahiru" to the student register
    }

    @Test
    public void testReset()
    {
        System.out.println("Testing reset method");
        register.reset();
        if(register.isempty()) {
            System.out.println("Student register is empty");
        }else{
            Assert.fail("The Student register is not empty");
        }

    }

}


