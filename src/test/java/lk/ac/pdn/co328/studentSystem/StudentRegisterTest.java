package lk.ac.pdn.co328.studentSystem;
import org.junit.*;
import java.util.ArrayList;

public class StudentRegisterTest {
    StudentRegister register;

    @Before
    public void setupTest()
    {
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
       register = new StudentRegister();
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
       Assert.fail("Test case is not yet implemented for adding student twice. So it is set to fail always");
   }

    @Test
    public void testRemoveStudent()
    {
        register = new StudentRegister();
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
        ArrayList<Integer> numbers = register.getAllRegistrationNumbers();
        ArrayList<Integer> expected = new ArrayList<Integer>();
        expected.add(1);
        expected.add(2);
        expected.add(5);
        Assert.assertTrue(numbers.equals(expected));
    }

    @Test
    public void testfindStudentByName()
    {
        Student student1 = new Student(1, "ruwan", "tharaka");
        Student student2 = new Student(2, "nimal", "kumara");
        Student student3 = new Student(5, "gayan", "chamara");

        try
        {
            register.addStudent(student1);
            register.addStudent(student2);
            register.addStudent(student3);

        } catch (Exception e)
        {
            e.printStackTrace();
        }

        Assert.assertArrayEquals(new Student[]{student1,student2,student3}, register.findStudentsByName("testing").toArray());
        Assert.assertEquals(0, register.findStudentsByName("No result").size());
    }

    @Test
    public void testClear(){
        Student student1 = new Student(1, "ruwan", "tharaka");
        Student student2 = new Student(2, "nimal", "kumara");
        Student student3 = new Student(5, "gayan", "chamara");
        try
        {
            register.addStudent(student1);
            register.addStudent(student2);
            register.addStudent(student3);

        } catch (Exception e)
        {
            e.printStackTrace();
        }

        Assert.assertTrue(register.getAllRegistrationNumbers().size()>0);
        register.reset();
        Assert.assertTrue(register.getAllRegistrationNumbers().size()==0);
    }
}
