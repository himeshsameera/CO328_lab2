package lk.ac.pdn.co328.studentSystem;
import org.junit.*;
import java.util.ArrayList;

public class StudentRegisterTest {
    StudentRegister register;

    @Before
    public void setupTest() {
        System.out.println("A new test is starting.");
        register = new StudentRegister();
    }

    @After
    public void finishTest() {
        System.out.println("Test finished");
    }

    @BeforeClass
    public static void beforeClass() {
        System.out.println("Evaluating test cases in StudentRegisterTest.java");
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("All tests are done");
    }

   @Test
    public void testAddStudent() {
       //register = new StudentRegister();
       try {
           register.addStudent(new Student(2, "nimal", "kumara"));
           register.addStudent(new Student(5, "fawzan", "mohomad"));
       }catch (Exception ex) {
           Assert.fail("Adding student failed");
       }
       System.out.println("Testing add student method");

       Student student = register.findStudent(2);
       Assert.assertEquals("Student Id is wrong",2,student.getId());
   }

   @Test
    public void testAddStudentTwice()
   {

       try{

           register.addStudent(new Student(5, "fawzan", "mohomad"));
           //register.addStudent(new Student(5, "fawzan", "mohomad"));

       }
       catch (Exception e){
           Assert.fail("Cannot add duplicates to the system");
       }
       System.out.println("Check whether studentID exists or not");

       ArrayList<Integer> actual = register.getAllRegistrationNumbers();
       ArrayList<Integer> expected = new ArrayList<Integer>();
       expected.add(5);
       Assert.assertEquals(expected,actual);

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

    @Test
    //Test the reset method
    public void testReset()  {

        register.reset();
        Assert.assertTrue(register.getAllRegistrationNumbers().isEmpty());

    }

    @Test
    public void testFindStudentsByName() {

        Student s1 = new Student(1, "ruwan", "tharaka");
        Student s2 = new Student(2, "nimal", "kumara");
        Student s3 = new Student(3, "ruwan", "sampath");


        try {
            register.addStudent(s1);
            register.addStudent(s2);
            register.addStudent(s3);

        } catch (Exception ex) {
            Assert.fail("Adding student failed");
        }

        ArrayList<Student> expected = new ArrayList<Student>();
        ArrayList<Student> actual = register.findStudentsByName("ruwan");

        expected.add(s1);
        expected.add(s3);
        Assert.assertTrue(actual.equals(expected));

    }
}
