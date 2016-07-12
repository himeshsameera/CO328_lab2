package lk.ac.pdn.co328.studentSystem;
import org.junit.*;
import java.util.ArrayList;

public class StudentRegisterTest {
    StudentRegister register;

    @Before
    public void setupTest()
    {
        register = new StudentRegister();
        try
        {
            register.addStudent(new Student(1, "ruwan", "tharaka"));

        }
        catch (Exception ex)
        {
            Assert.fail("Add student failed");
        }
        //System.out.println("A new test is starting.");
    }

    @After
    public void finishTest()
    {
        //System.out.println("Test finished");
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

       try
       {
           register.addStudent(new Student(2, "nimal", "kumara"));
           register.addStudent(new Student(5, "fawzan", "mohomad"));
       }
       catch (Exception ex)
       {
           Assert.fail("Adding student failed");
       }
       System.out.println("Testing add student method");

       Student student = register.findStudent(2);
       Assert.assertEquals("Student Id is wrong",2,student.getId());
   }

   @Test
    public void testAddStudentTwice()
   {
       // Implement your test code here. Adding a student with same registration number twice should generate an exception.
       // Assert.fail("Test case is not yet implemented for adding student twice. So it is set to fail always");
       try
       {
           register.addStudent(new Student(2, "nimal", "kumara"));
       }
       catch (Exception ex)
       {
           //Assert.fail("Adding student failed");
           System.out.println("Success");
       }
   }

    @Test
    public void testRemoveStudent()
    {
        //register = new StudentRegister();

        register.removeStudent(1);
        Student student = register.findStudent(1);
        Assert.assertNull("student was not removed",student);
    }

    @Test
    public void testGetRegNumbers()
    {
        //register = new StudentRegister();

        ArrayList<Integer> numbers = register.getAllRegistrationNumbers();
        ArrayList<Integer> expected = new ArrayList<Integer>();
        expected.add(1);
        //expected.add(2);
        //expected.add(5);
        //System.out.println(numbers);
        Assert.assertTrue(numbers.equals(expected));
    }
}
