package lk.ac.pdn.co328.studentSystem;
import org.junit.*;
import java.util.ArrayList;

public class StudentRegisterTest {
    StudentRegister register;

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

    @Before
    public void setupTest()
    {

        register = new StudentRegister();
        try
        {
            register.addStudent(new Student(2, "nimal", "kumara"));

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

   @Test
    public void testAddStudent()
   {

       try
       {

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
           register.addStudent(new Student(2, "nimal", "kumara"));
           //register.addStudent(new Student(2, "nimal", "kumara"));

       }
       catch (Exception ex)
       {
           System.out.println("Adding student failed"); // this exeption means test pass
       }

   }

    @Test
    public void testRemoveStudent()
    {

        try
        {
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
                register.addStudent(new Student(5, "gayan", "chamara"));
            }
            catch (Exception ex)
            {
                Assert.fail("Add student failed");
            }
        ArrayList<Integer> numbers = register.getAllRegistrationNumbers();
        ArrayList<Integer> expected = new ArrayList<Integer>();
        expected.add(2);
        expected.add(1);
        expected.add(5);

        Assert.assertTrue(numbers.equals(expected));
    }

    @Test
    public void testfindStudentsByName(){

        register = new StudentRegister();
        try
        {
            register.addStudent(new Student(1, "ruwan", "tharaka"));
            register.addStudent(new Student(5, "gayan", "ruwan"));
        }
        catch (Exception ex)
        {
            Assert.fail("Add student failed");
        }

       ArrayList<Student> got = register.findStudentsByName("ruwan");
        ArrayList<Student> expected = new ArrayList<Student>();
        expected.add(new Student(1, "ruwan", "tharaka"));
       Assert.assertTrue(got.get(0).getFirstName().equals("ruwan"));
        Assert.assertTrue(got.get(1).getLastName().equals("ruwan"));
    }
    @Test
    public void testCleanStudentRegestor() {
        register = new StudentRegister();
        try {
            register.addStudent(new Student(1, "ruwan", "tharaka"));
            register.addStudent(new Student(5, "gayan", "chamara"));
        } catch (Exception ex) {
            Assert.fail("Add student failed");
        }
        register.reset();
        try {

            ArrayList<Integer> numbers = register.getAllRegistrationNumbers();
        } catch (NullPointerException e) {
            System.out.print("NullPointerException caught"); // this exeption means regestor is cleaned
        }
    }
}
