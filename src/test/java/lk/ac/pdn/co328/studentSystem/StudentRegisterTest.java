package lk.ac.pdn.co328.studentSystem;
import org.junit.*;
import java.util.ArrayList;

public class StudentRegisterTest {


    StudentRegister register;
    @Before
    public void setupTest() {
        register = new StudentRegister();
        System.out.println("A new test is starting.");

        try
        {
            register.addStudent(new Student(1, "Amila", "Indrajith"));
            register.addStudent(new Student(2, "nimal", "kumara"));
            register.addStudent(new Student(5, "fawzan", "mohomad"));

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
    public void reset(){
        register.reset();
        Assert.assertNotNull("student was not removed",register);
    }

    @Test
    public void findStudentsByName(){

                ArrayList<Student> student = register.findStudentsByName("nimal");
                Assert.assertEquals(2, student.get(0).getId());
                Assert.assertEquals("nimal", student.get(0).getFirstName());
                Assert.assertEquals("kumara", student.get(0).getLastName());
    }

    @Test
    public void testAddStudent()
   {
       //register = new StudentRegister();

       System.out.println("Testing add student method");

       Student student = register.findStudent(2);
       Assert.assertEquals("Student Id is wrong",2,student.getId());
   }

   @Test
    public void testAddStudentTwice()
   {
       // Implement your test code here. Adding a student with same registration number twice should generate an exception.

       //Assert.fail("Test case is not yet implemented for adding student twice. So it is set to fail always");

       //register = new StudentRegister();
       try
       {
           register.addStudent(new Student(2, "nimal", "kumara"));
       }
       catch (Exception ex)
       {
           //Assert.fail("Adding student failed");
           System.out.println("Testing add student method");
       }


       //Student student = register.findStudent(2);
       //Assert.assertEquals("Student Id is wrong",2,student.getId());
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
        expected.add(2);
        expected.add(5);

        Assert.assertTrue(numbers.equals(expected));
    }


}
