package lk.ac.pdn.co328.studentSystem;

import org.junit.*;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;

public class StudentRegisterTest {

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    StudentRegister register;

    @BeforeClass
    public static void beforeClass() {
        System.out.println("Evaluating test cases in StudentRegisterTest.java");
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("All tests are done");
    }

    @Before
    public void setupTest() {
        register = new StudentRegister();
        System.out.println("A new test is starting.");
    }

    @After
    public void finishTest() {
        System.out.println("Test finished");
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

    @Test
    public void testAddStudentTwice() throws Exception {
        register.addStudent(new Student(8, "kusal", "perera"));

        System.out.println("Testing: add student with same Id Twice (An exception is expected)");

        exception.expect(RuntimeException.class);
        exception.expectMessage(StudentRegister.getDuplicateStudentIdException().toString());
        register.addStudent(new Student(8, "kausal", "pereraa"));
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
            register.addStudent(new Student(9, "ruwan", "kusal"));
            register.addStudent(new Student(11, "kusal", "kumara"));
            register.addStudent(new Student(16, "kusal", "chamara"));
            register.addStudent(new Student(17, "kumar", "chamara"));
        } catch (Exception ex) {
            Assert.fail("Adding student failed");
        }

        ArrayList<Student> students = register.findStudentsByName("kusal");
        ArrayList<Student> expected = new ArrayList<Student>();
        expected.add(register.findStudent(9));
        expected.add(register.findStudent(11));
        expected.add(register.findStudent(16));

        Assert.assertTrue(students.equals(expected));
    }

    @Test
    public void testReset() {
        try {
            register.addStudent(new Student(9, "ruwan", "kusal"));
            register.addStudent(new Student(11, "kusal", "kumara"));
            register.addStudent(new Student(16, "kusal", "chamara"));
            register.addStudent(new Student(17, "kumar", "chamara"));
        } catch (Exception ex) {
            Assert.fail("Adding student failed");
        }

        register.reset();

        Assert.assertTrue("Error: Students not removed", register.getAllRegistrationNumbers().isEmpty());
    }
}
