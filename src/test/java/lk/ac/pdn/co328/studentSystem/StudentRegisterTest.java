package lk.ac.pdn.co328.studentSystem;
import org.junit.*;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class StudentRegisterTest {
    StudentRegister register;

    @Before
    public void setupTest() {
        System.out.println("A new test is starting.");
        register = new StudentRegister();
        try {
            register.addStudent(new Student(1, "nimal", "kumara"));
            register.addStudent(new Student(2, "ruwan", "tharaka"));
            register.addStudent(new Student(3, "gayan", "chamara"));
        }catch(Exception ex){
            ex.printStackTrace();
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
       try
       {
           register.addStudent(new Student(4, "nirmal", "mendis"));
           register.addStudent(new Student(5, "fawzan", "mohomad"));
       }
       catch (Exception ex)
       {
           Assert.fail("Adding student failed");
       }
       System.out.println("Testing add student method");

       Student student = register.findStudent(4);
       Assert.assertEquals("Student Id is wrong",4,student.getId());
   }

   @Test
    public void testAddStudentTwice()
   {
       // Implement your test code here. Adding a student with same registration number twice should generate an exception
       System.out.println("Testing add student twice method");
       try{
           register.addStudent(new Student(1, "kaveen", "nalaka"));
       }catch(Exception ex) {
           //System.out.println("Duplicate Entry found for same Registration Number");
       }
       ArrayList<Student> student = register.findStudentsByName("kaveen");
       Assert.assertNotNull("student was entered",student);
   }

    @Test
    public void testRemoveStudent()
    {
        System.out.println("Testing remove student method");
        register.removeStudent(1);
        Student student = register.findStudent(1);
        Assert.assertNull("student was not removed",student);
    }

    @Test
    public void testGetRegNumbers()
    {
        System.out.println("Testing get reg numbers method");
        ArrayList<Integer> numbers = register.getAllRegistrationNumbers();
        ArrayList<Integer> expected = new ArrayList<Integer>();
        //System.out.println(numbers);
        expected.add(1);
        expected.add(2);
        expected.add(3);
        Assert.assertTrue(numbers.equals(expected));
    }
}
