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
    public void testAddStudentTwice() {

        try {
            register.addStudent(new Student(2, "nimal", "kumara"));
            register.addStudent(new Student(2, "nimal", "kumara"));
        } catch (Exception ex) {
            Assert.assertEquals("StudentID already exists in the register", ex.getMessage());
        }
        System.out.println("Testing add student method");


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
    public void testSearchStrudentByName() {
        try {
            register.addStudent(new Student(1, "ruwan", "tharaka"));
            register.addStudent(new Student(2, "nimal", "kumara"));
            register.addStudent(new Student(5, "gayan", "chamara"));
            register.addStudent(new Student(6, "gayan", "Bandara"));
        } catch (Exception ex) {
            Assert.fail("Adding student failed");
        }
        ArrayList<Student> students = register.searchStudentsByName("gayan");

        for (Student i : students
                ) {
            Assert.assertTrue(i.getId() == 5 || i.getId() == 6);
        }
    }

    @Test
    public void testCleanStudentRegister() {
        try {
            register.addStudent(new Student(1, "ruwan", "tharaka"));
            register.addStudent(new Student(2, "nimal", "kumara"));
            register.addStudent(new Student(5, "gayan", "chamara"));
            register.addStudent(new Student(6, "gayan", "Bandara"));
        } catch (Exception ex) {
            Assert.fail("Adding student failed");
        }

        Assert.assertFalse(register.getAllRegistrationNumbers().isEmpty());

        register.cleanStudentRegister();
        try{
            Assert.assertNull(register.getAllRegistrationNumbers());
        }catch(Exception e){
            Assert.assertEquals(e.toString(),"java.lang.NullPointerException");
        }


    }
}