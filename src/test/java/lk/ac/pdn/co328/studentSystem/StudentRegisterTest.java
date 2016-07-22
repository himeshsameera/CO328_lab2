package lk.ac.pdn.co328.studentSystem;
import org.junit.*;
import java.util.ArrayList;

import static junit.framework.TestCase.assertEquals;

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
    {    // Implement your test code here. Adding a student with same registration number twice should generate an exception.


        try
        {
            register.addStudent(new Student(7, "Saman", "Kumara"));
            register.addStudent(new Student(8, "Thilini", "Mohotti"));
            register.addStudent(new Student(7, "Saman", "Kumara"));
        }

        catch (Exception ex)
        {
            System.out.println("student register does not allow to insert doublicate");
            // Assert.fail("Test case is not yet implemented for adding student twice. So it is set to fail always");
            //catch {} part running means exeption throws in the add student twice
        }

        // if the stuRegister allow to insert doublicates numbers shoud have 7,8,7  But where it includes only 7,8  .
        ArrayList<Integer> numbers = register.getAllRegistrationNumbers();
        ArrayList<Integer> expected = new ArrayList<Integer>();
        expected.add(7);
        expected.add(8);
        Assert.assertTrue(numbers.equals(expected));

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
    public void testReset()
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
        boolean actual = register.isEmpty();
        boolean expected = true;
        assertEquals(actual, expected);
    }

    @Test
    public void FindByName()
    {
        try
        {   register.addStudent(new Student(1, "ruwan", "tharaka"));
            register.addStudent(new Student(2, "nimal", "kumara"));
            register.addStudent(new Student(5, "gayan", "chamara"));
        }
        catch (Exception ex)
        {
            Assert.fail("Adding student failed");
        }
        ArrayList<Student> studentnames  = register.findStudentsByName("nimal");
        String expected = "nimal";
        String AcFname = studentnames.get(0).getFirstName();
        String AcLname = studentnames.get(0).getLastName();

        if(AcFname == "nimal")
            Assert.assertTrue(AcFname.equals(expected));

        else if(AcLname == "nimal")
            Assert.assertTrue(AcLname.equals(expected));
    }
}
