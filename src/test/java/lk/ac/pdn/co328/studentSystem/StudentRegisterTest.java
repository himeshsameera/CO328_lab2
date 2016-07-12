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

    @Test
    public void reset() throws Exception {

        try {
            register.addStudent(new Student(2, "nimal", "kumara"));
            register.addStudent(new Student(5, "fawzan", "mohomad"));
        } catch (Exception ex) {
            Assert.fail("Adding student failed");
        }
        System.out.println("Testing reset() method");
        register.reset();
        try{
            Assert.assertEquals("Student nimal is still there", null, register.findStudent(2));
            Assert.assertEquals("Student fawzan is still there", null, register.findStudent(3));

        } catch (NullPointerException e){

        }
    }

    @Test
    public void findStudentsByName() throws Exception {

        String name = "nimal";

        try
        {
            register.addStudent(new Student(2, "nimal", "kumara"));
            register.addStudent(new Student(5, "fawzan", "mohomad"));
        }
        catch (Exception ex)
        {
            Assert.fail("Adding student failed");
        }
        System.out.println("Testing findStudentsByName method");
        ArrayList<Student> students = register.findStudentsByName(name);

        Assert.assertEquals("Student Id is wrong",2,students.get(0).getId());
        Assert.assertEquals("Student Last Name is wrong","kumara",students.get(0).getLastName());
        Assert.assertEquals("Student First Name is wrong","nimal",students.get(0).getFirstName());
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
           register.addStudent(new Student(2, "nimal", "kumara"));
           register.addStudent(new Student(2, "nimal", "kumara"));
           Assert.fail("An exception must be triggered");
       }
       catch (Exception ex)
       {

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
}
