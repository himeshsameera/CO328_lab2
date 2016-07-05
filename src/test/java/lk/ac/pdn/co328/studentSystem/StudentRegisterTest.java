package lk.ac.pdn.co328.studentSystem;
import org.junit.*;
import java.util.ArrayList;

public class StudentRegisterTest {

    StudentRegister register;

    @Before
    public void setupTest()
    {
        register = new StudentRegister();
        System.out.println("A new test is starting.");
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
       //add first student
       try
       {
           register.addStudent(new Student(1, "ruwan", "tharaka"));

       }
       catch (Exception ex)
       {
           Assert.fail("Add student failed");
       }

       //add same student
       try
       {
           register.addStudent(new Student(1, "ruwan", "tharaka"));

       }
       catch (Exception ex)
       {
           Assert.assertTrue(true);
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
    public void TestReset() throws Exception
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

        register.reset();
        boolean result = register.findStudent(1) == null && register.findStudent(2) == null && register.findStudent(5) == null;

        Assert.assertTrue(result);
    }

    @Test
    public void testFindStudentsByName() throws Exception
    {
        Student st1 = new Student(1, "ruwan", "tharaka");
        Student st2 = new Student(2, "nimal", "kumara");
        Student st3 = new Student(5, "tharaka", "chamara");
        Student st4 = new Student(8, "tharaka", "sadun");

        try
        {
            register.addStudent(st1);
            register.addStudent(st2);
            register.addStudent(st3);
            register.addStudent(st4);
        }
        catch (Exception ex)
        {
            Assert.fail("Adding student failed");
        }

        ArrayList<Student> expected = new ArrayList<Student>();
        expected.add(st1);
        expected.add(st3);
        expected.add(st4);

        ArrayList<Student> result = register.findStudentsByName("tharaka");
        Assert.assertEquals(result, expected);

    }
}
