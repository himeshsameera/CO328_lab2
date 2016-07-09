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
            register.addStudent(new Student(2, "nimal", "kumara"));
            register.addStudent(new Student(5, "gayan", "chamara"));
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
       try
       {
           register.addStudent(new Student(4, "paul", "walker"));
       }
       catch (Exception ex)
       {
           Assert.fail("Adding student failed");
       }

       Student student = register.findStudent(4);
       Assert.assertEquals("Student Id is wrong",4,student.getId());
   }

   @Test
    public void testAddStudentTwice()
   {
       // Implement your test code here. Adding a student with same registration number twice should generate an exception.
      // Assert.fail("Test case is not yet implemented for adding student twice. So it is set to fail always");
       System.out.println("Testing adding 2 students with same id");
       try
       {
           register.addStudent(new Student(3, "walker", "paul"));
           register.addStudent(new Student(3, "mars", "bruno"));
       }
       catch (Exception ex)
       {
           System.out.println("Test successfull. Exception thrown! ");
           return ;
       }
       Assert.fail("Adding two students with same reg no didn't throw an exception!");
   }

    @Test
    public void testRemoveStudent()
    {
        System.out.println("Testing RemoveStudent method");
        register.removeStudent(1);
        Student student = register.findStudent(1);
        Assert.assertNull("student was not removed",student);
    }

    @Test
    public void testGetRegNumbers()
    {
        System.out.println("Testing GetRegNumbers method");
        ArrayList<Integer> numbers = register.getAllRegistrationNumbers();
        ArrayList<Integer> expected = new ArrayList<Integer>();
        expected.add(1);
        expected.add(2);
        expected.add(5);
        Assert.assertTrue(numbers.equals(expected));
    }

    @Test
    public void testFindStudentsByName()
    {
        System.out.println("Testing FindStudentsByName method");
        try
        {
            register.addStudent(new Student(6, "paul", "gayan"));
            register.addStudent(new Student(7, "paul", "fawzan"));
            register.addStudent(new Student(8, "paul", "walker"));
        }
        catch (Exception ex)
        {
            Assert.fail("Adding student failed");
        }
        ArrayList<Student> students = register.findStudentsByName("paul");
        ArrayList<Student> expected = new ArrayList<Student>();
        expected.add(register.findStudent(6));
        expected.add(register.findStudent(7));
        expected.add(register.findStudent(8));
        Assert.assertTrue(students.equals(expected));
    }

    @Test
    public void testreset(){
        System.out.println("Testing reset method");
        register.reset();
        Student s1 = register.findStudent(1);
        Assert.assertNull("reset failed", s1);
        s1 = register.findStudent(2);
        Assert.assertNull("reset failed", s1);
        s1 = register.findStudent(5);
        Assert.assertNull("reset failed", s1);

    }
}
