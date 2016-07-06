package lk.ac.pdn.co328.studentSystem;
import org.junit.*;
import java.util.ArrayList;

public class StudentRegisterTest {
    StudentRegister register;

    @Before
    public void setupTest()
    {
        System.out.println("A new test is starting.");

        register = new StudentRegister();


        try
        {
            register.addStudent(new Student(2, "nimal", "kumara"));
            register.addStudent(new Student(5, "fawzan", "mohomad"));
            register.addStudent(new Student(1, "ruwan", "tharaka"));
        }
        catch (Exception ex)
        {
            Assert.fail("Adding student failed");
        }

    }

    @After
    public void finishTest()
    {
        System.out.println("Test finished");
    }

    @BeforeClass
    public  static void beforeClass()
    {
        System.out.println("Evaluating test cases in StudentRegisterTest.java");
    }

    @AfterClass
    public static void afterClass()
    {
        System.out.println("All tests are done");
    }

   @Test
    public void testAddStudent()
   {

       System.out.println("Testing add student method");

       Student student = register.findStudent(2);
       Assert.assertEquals("Student Id is wrong",2,student.getId());
   }

   @Test
    public void testAddStudentTwice()
   {
       // Implement your test code here. Adding a student with same registration number twice should generate an exception.

       try
       {
           register.addStudent(new Student(2, "kamal", "perera"));
           Assert.fail("Two students with the same registration number added.Test fails.");


       }catch (Exception ex)
       {
           System.out.println("Two students with the same registration number added handled.");
       }
       //Assert.fail("Test case is not yet implemented for adding student twice. So it is set to fail always");
   }

    @Test
    public void testRemoveStudent()
    {


        register.removeStudent(1);
        Student student = register.findStudent(1);
        Assert.assertNull("student was not removed",student);
    }

    @Test
    public void testGetRegNumbers()
    {

        ArrayList<Integer> numbers = register.getAllRegistrationNumbers();
        ArrayList<Integer> expected = new ArrayList<Integer>();
        expected.add(2);
        expected.add(5);
        expected.add(1);
        Assert.assertTrue(numbers.equals(expected));
    }

    @Test
    public void testFindStudentsByName()
    {

        ArrayList<Student> students = register.findStudentsByName("nimal");
        Assert.assertEquals("Student not Found.",2,students.get(0).getId());
    }

    @Test
    public void testReset()
    {
        ArrayList<Student> studentList=register.reset();

        Assert.assertNull("Register was not reset.",studentList);
    }



}
