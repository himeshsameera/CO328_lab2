package lk.ac.pdn.co328.studentSystem;
import org.junit.*;
import java.util.ArrayList;
import static junit.framework.TestCase.assertEquals;

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

        try {
            register.addStudent(new Student(2, "nimal", "kumara"));
            register.addStudent(new Student(5, "fawzan", "mohomad"));
        } catch (Exception ex) {
            Assert.fail("Adding student failed");
        }
        System.out.println("Testing add student method");

        Student student = register.findStudent(2);
        Assert.assertEquals("Student Id is wrong", 2, student.getId());
    }

    @Test(expected=Exception.class)
    public void testAddStudentTwice() {
        try {
            register.addStudent(new Student(2, "nimal", "kumara"));
        } catch (Exception ex) {
            Assert.fail("Student ID already exists in the system");
        }

        System.out.println("Testing add student method - exception");

        Student student = register.findStudent(3);
        Assert.assertEquals("Error - added same student twice", 2, student.getId());
    }

    @Test
    public void testRemoveStudent() {
        try {
            register.addStudent(new Student(2, "nimal", "kumara"));
            register.addStudent(new Student(1, "ruwan", "tharaka"));
            register.addStudent(new Student(5, "gayan", "chamara"));
        } catch (Exception ex) {
            Assert.fail("Add student failed");
        }
        register.removeStudent(1);
        Student student = register.findStudent(1);
        Assert.assertNull("student was not removed", student);
    }

    @Test
    public void testGetRegNumbers() {

        try {
            register.addStudent(new Student(1, "ruwan", "tharaka"));
            register.addStudent(new Student(2, "nimal", "kumara"));
            register.addStudent(new Student(5, "gayan", "chamara"));
        } catch (Exception ex) {
            Assert.fail("Adding student failed");
        }
        ArrayList<Integer> numbers = register.getAllRegistrationNumbers();
        ArrayList<Integer> expected = new ArrayList<Integer>();
        expected.add(1);
        expected.add(2);
        expected.add(5);
        Assert.assertTrue(numbers.equals(expected));
    }

    public void testFindStudentsByName() {
        int i = 0;
        try {
            register.addStudent(new Student(1, "ruwan", "tharaka"));
            register.addStudent(new Student(2, "nimal", "ruwan"));
            register.addStudent(new Student(5, "nimmi", "chamini"));
        } catch (Exception ex) {
            Assert.fail("Adding student failed");
        }

        ArrayList<Student> students = register.findStudentsByName("ruwan");
        ArrayList<Integer> expected = new ArrayList<Integer>();
        ArrayList<Integer> regNo = new ArrayList<Integer>();

        for (Student student : students) {
            regNo.add(i, student.getId());
            i++;
        }

        expected.add(1);
        expected.add(2);
        Assert.assertTrue(regNo.equals(expected));
    }

    @Test
    public void testReset() {
        try {
            register.addStudent(new Student(1, "ruwan", "tharaka"));
            register.addStudent(new Student(2, "supun", "sampath"));
            register.addStudent(new Student(5, "hasini", "shehara"));
        } catch (Exception ex) {
            Assert.fail("Adding student failed");
        }

        register.reset();
        Student student1 = register.findStudent(1);
        Assert.assertNull("register has not cleaned", student1);
        Student student2 = register.findStudent(2);
        Assert.assertNull("register has not cleaned", student2);
        Student student3 = register.findStudent(5);
        Assert.assertNull("register has not cleaned", student3);
    }

}
