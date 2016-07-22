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
     //  register = new StudentRegister();
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
     //  register = new StudentRegister();
       String expected = "StudentID already exists in the register";
       String actual=null;
       try
       {
           register.addStudent(new Student(5, "nimal", "kumara"));
           register.addStudent(new Student(5, "fawzan", "mohomad"));
       }
       catch (Exception ex)
       {
           System.out.println("Testing add two student method");
           actual = ex.getMessage();
           Assert.assertTrue(actual.equals(expected));
       }


   }

    @Test
    public void testRemoveStudent()
    {
       // register = new StudentRegister();
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
       // register = new StudentRegister();
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
    public void reset() throws Exception {
       // register = new StudentRegister();

        try
        {
            register.addStudent(new Student(2, "nimal", "kumara"));
            register.addStudent(new Student(5, "fawzan", "mohomad"));
        }
        catch (Exception ex)
        {
            //  System.out.println("Testing add two student method");
            //   actual = ex.getMessage();
            Assert.fail();
        }
        register.reset();
        ArrayList <Integer> actual = register.getAllRegistrationNumbers();
        System.out.println(actual.isEmpty());
        Assert.assertTrue(actual.isEmpty());
    }

    @Test
    public void findStudentsByName() throws Exception {
       // register = new StudentRegister();

        ArrayList<Student> expected = new ArrayList<Student>();
        Student st1 = new Student(2, "nimal", "kumara");
        Student st2 = new Student(5, "nimal", "mohomad");
        Student st3 = new Student(6, "supun", "ops");

        expected.add(st1);
        expected.add(st2);
        System.out.println(expected.size());

        try
        {
            register.addStudent(st1);
            register.addStudent(st2);
            register.addStudent(st3);
        }
        catch (Exception ex)
        {
            Assert.fail("Adding student failed");
        }
        ArrayList<Student> actual = register.findStudentsByName("nimal");
        System.out.println(actual.size());
        Assert.assertTrue(actual.equals(expected));

    }
}
