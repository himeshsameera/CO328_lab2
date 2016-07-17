package lk.ac.pdn.co328.studentSystem;
import org.junit.*;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;

public class StudentRegisterTest {
    StudentRegister register;

    @Before
    public void setupTest()
    {
        System.out.println("A new test is starting.");

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
       System.out.println("Testing add student method");

       Student student = register.findStudent(2);
       Assert.assertEquals("Student Id is wrong",2,student.getId());
   }

   @Test
    public void testAddStudentTwice()
   {
       System.out.println("Testing addStudent method by adding the same student twice");

       try {
           register.addStudent(new Student(5, "fawzan", "mohomad"));
           Assert.fail("Adding a student twice did't throw an exception");
       } catch (Exception e) {

       }
   }

    @Test
    public void testRemoveStudent()
    {
        System.out.println("Testing removeStudent method");

        register.removeStudent(2);
        Student student = register.findStudent(2);
        Assert.assertNull("student was not removed",student);
    }

    @Test
    public void testGetRegNumbers()
    {
        try {
            register.addStudent(new Student(7, "gayan", "chamara"));
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("Testing getRegNumbers method");

        ArrayList<Integer> numbers = register.getAllRegistrationNumbers();
        ArrayList<Integer> expected = new ArrayList<Integer>();
        expected.add(2);
        expected.add(5);
        expected.add(7);
        Assert.assertTrue(numbers.equals(expected));
    }

    // Test findStudentByName method with a part of the firstname as input
    @Test
    public void testFindStudentsByNameFirstName() throws Exception {
        System.out.println("Testing findStudentByName method with a part of the firstname");

        ArrayList<Student> students = register.findStudentsByName("ima");
        ArrayList<Student> expected = new ArrayList<Student>();
        expected.add(new Student(2, "nimal", "kumara"));
        Assert.assertTrue(students.size() == expected.size() && students.get(0).getFirstName().equals(expected.get(0).getFirstName()));
    }

    // Test findStudentByName method with a part of the lastname as input
    @Test
    public void testFindStudentsByNameLastName() throws Exception {
        System.out.println("Testing findStudentByName method with a part of the lastname");

        ArrayList<Student> students = register.findStudentsByName("umar");
        ArrayList<Student> expected = new ArrayList<Student>();
        expected.add(new Student(2, "nimal", "kumara"));
        Assert.assertTrue(students.size() == expected.size() && students.get(0).getFirstName().equals(expected.get(0).getFirstName()));
    }

    // Test findStudentByName method with a non-matching input
    @Test
    public void testFindStudentsByNameNoEntry() throws Exception {
        System.out.println("Testing findStudentByName method with a non matching string");

        ArrayList<Student> students = register.findStudentsByName("zzz");
        Assert.assertTrue(students.isEmpty());
    }

    @Test
    public void testReset() throws Exception {
        System.out.println("Testing reset method");

        register.reset();
        Assert.assertNull(register.getStudentList());
    }
}
