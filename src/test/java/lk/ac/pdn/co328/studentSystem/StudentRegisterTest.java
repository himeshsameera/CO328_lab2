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

       try
       {
           register.addStudent(new Student(1, "nimal", "kumara"));
           register.addStudent(new Student(1, "nimal", "kumara"));

       }
       catch (Exception ex)
       {
           Assert.assertEquals("StudentID already exists in the register",ex.getMessage());
       }
   }

    @Test
    public void testRemoveStudent()
    {

        try
        {
            register.addStudent(new Student(2, "nimal", "kumara"));
            register.addStudent(new Student(1, "ruwan", "tharaka"));
            register.addStudent(new Student(5, "gayan", "chamara"));
        }
        catch (Exception ex)
        {
            Assert.fail("Add student failed");
        }
        register.removeStudent(1);
        Student student = register.findStudent(1);
        Assert.assertNull("student was not removed",student);
    }

    @Test
    public void testGetRegNumbers()
    {

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
        try
        {
            Student student=new Student(1, "ruwan", "tharaka");
            register.addStudent(student);
            ArrayList<Student> students=register.findStudentsByName("ruwan");
            Assert.assertEquals(students.get(0),student);
        }
        catch (Exception ex)
        {
            Assert.fail("Adding student failed");
        }

    }

    @Test
    public void testReset()
    {
        try
        {
            register.addStudent(new Student(1,"ruwan","tharaka"));
            register.reset();
        }
        catch (Exception ex)
        {
            Assert.fail("Adding student failed");
        }
        Assert.assertNull(register.findStudent(1));
    }


}
