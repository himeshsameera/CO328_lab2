package lk.ac.pdn.co328.studentSystem;
import org.junit.*;
import java.util.ArrayList;

public class StudentRegisterTest {
    @Test
    public void reset() throws Exception {
        register.reset();
        ArrayList<Integer> numbers = register.getAllRegistrationNumbers();

        Assert.assertTrue("Reset done succesfully", numbers.size()== 0);
    }

    @Test
    public void findStudentsByName() throws Exception {
        ArrayList<Student> actual = null;
        ArrayList<Student> expected = new ArrayList<Student>();

        Student s1 = new Student(2, "nimal", "kumara");
        Student s2 = new Student(5, "nimal", "mohomad");
        Student s3 = new Student(6, "ruchira", "senarath");


        try
        {
            register.addStudent(s1);
            register.addStudent(s2);
            register.addStudent(s3);

        }
        catch (Exception ex)
        {
            Assert.fail("Adding student failed");

        }

        actual = register.findStudentsByName("nimal");
        expected.add(s1 );
        expected.add(s2);

        Assert.assertTrue(actual.equals(expected));


    }

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
       //register = new StudentRegister();
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
       //Assert.fail("Test case is not yet implemented for adding student twice. So it is set to fail always");
    String expected = "StudentID already exists in the register";
    String actual = null;
       try{
           register.addStudent(new Student(2,"nimal","kumara"));
           register.addStudent(new Student(2,"fawzan","mohomad"));

       }catch(Exception ex){
           //Assert.fail("Adding student failed");
           System.out.println(ex.getMessage());
        }
       System.out.println("Testing add student twice method");


   }

    @Test
    public void testRemoveStudent()
    {
        //register = new StudentRegister();
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
        //register = new StudentRegister();
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
}
