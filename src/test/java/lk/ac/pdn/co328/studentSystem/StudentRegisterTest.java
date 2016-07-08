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

        try
        {
            register.addStudent(new Student(1, "ruwan", "tharaka"));
            register.addStudent(new Student(2, "nimal", "kumara"));
        }
        catch (Exception ex)
        {
            Assert.fail("Adding initial student details  failed");
        }
    }

    @After
    public void finishTest()
    {
        System.out.println("Test finished\n");
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
            register.addStudent(new Student(3, "fawzan", "mohomad"));
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
            register.addStudent(new Student(4, "saman", "saman"));
            register.addStudent(new Student(4, "saman", "saman"));
            register.addStudent(new Student(4, "saman", "saman"));
        }
        catch (Exception ex)
        {
            System.out.println("SUCCESS");
            return;
        }
        Assert.fail("Two students with the same ID added. Test failed.");
    }

    @Test
    public void testRemoveStudent()
    {
        try
        {
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
            register.addStudent(new Student(6, "gayan", "chamara"));
            register.addStudent(new Student(7, "kamal", "kamal"));

        }
        catch (Exception ex)
        {
            Assert.fail("Adding student failed");
        }
        ArrayList<Student> std = register.findStudentsByName("kamal");
        ArrayList<Student> expected = new ArrayList<Student>();
        expected.add(register.findStudent(6));
        expected.add(register.findStudent(7));
        Assert.assertTrue(std.equals(expected));
    }

    @Test(expected=NullPointerException.class)
    public void testReset()
    {
        try
        {
            register.addStudent(new Student(5, "gayan", "chamara"));
            register.addStudent(new Student(4, "saman", "saman"));
        }
        catch (Exception ex)
        {
            Assert.fail("Adding student failed");
        }
        register.reset();
        Student student = register.findStudent(1);
        Assert.assertNull("student register was not removed",student);
        student = register.findStudent(5);
        Assert.assertNull("student register was not removed",student);
        student = register.findStudent(4);
        Assert.assertNull("student register was not removed",student);
        student = register.findStudent(6);
        Assert.assertNull("student register was not removed",student);

    }

}
