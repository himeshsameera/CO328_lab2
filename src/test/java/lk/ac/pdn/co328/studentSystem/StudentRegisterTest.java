package lk.ac.pdn.co328.studentSystem;

import org.junit.*;
import java.util.ArrayList;

public class StudentRegisterTest {

    StudentRegister register;

    @Before
    public void setupTest() {
        register = new StudentRegister();
        System.out.println("A new test is starting.");
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
            register = new StudentRegister();
            register.addStudent(new Student(2, "nimal", "kumara"));
            register.addStudent(new Student(5, "fawzan", "mohomad"));
        } catch (Exception ex) {
            Assert.fail("Adding student failed");
        }
        System.out.println("Testing add student method");

        Student student = register.findStudent(2);
        Assert.assertEquals("Student Id is wrong", 2, student.getId());
    }

    // Test to check whether the expected exception and thrown exception are same
    @Test(expected = Exception.class)
    public void testAddStudentTwice() throws Exception {
        register.addStudent(new Student(1, "amal", "nishan"));
        register.addStudent(new Student(1, "sameera", "perera"));
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

    @Test
    public void testFindStudentsByName() {
        try {
            register.addStudent(new Student(1, "ruwan", "tharaka"));
            register.addStudent(new Student(2, "nimal", "kumara"));
            register.addStudent(new Student(5, "kumara", "gayan"));
            register.addStudent(new Student(12, "kamal", ""));
            register.addStudent(new Student(4, "123", ""));
            register.addStudent(new Student(20, "123", "ransilu"));
        } catch (Exception ex) {
            Assert.fail("Find Students By Name failed");
        }

        // Test for both first name and last name
        ArrayList<Student> students1 = register.findStudentsByName("kumara");
        ArrayList<Student> expected1 = new ArrayList<Student>();
        expected1.add(new Student(2, "nimal", "kumara"));
        expected1.add(new Student(5, "kumara", "gayan"));

        Assert.assertTrue(students1.equals(expected1));

        // Test for last name only and empty string
        ArrayList<Student> students2 = register.findStudentsByName("");
        ArrayList<Student> expected2 = new ArrayList<Student>();
        expected2.add(new Student(12, "kamal", ""));
        expected2.add(new Student(4, "123", ""));

        Assert.assertTrue(students2.equals(expected2));

        // Test for first name only and strings with numbers
        ArrayList<Student> students3 = register.findStudentsByName("123");
        ArrayList<Student> expected3 = new ArrayList<Student>();
        expected3.add(new Student(4, "123", ""));
        expected3.add(new Student(20, "123", "ransilu"));

        //Assert.assertTrue(students3.equals(expected3));
    }
}
