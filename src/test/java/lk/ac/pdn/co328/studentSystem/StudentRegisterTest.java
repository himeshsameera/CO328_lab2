package lk.ac.pdn.co328.studentSystem;
import org.junit.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import static java.util.Collections.sort;

public class StudentRegisterTest {
    StudentRegister register;

    @Before
    public void setupTest()
    {
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
       try
       {
           register.addStudent(new Student(3, "nimal", "kumara"));
           register.addStudent(new Student(3, "fawzan", "mohomad"));

           Assert.fail("Test AddStudent Twice failed");
       }
       catch (Exception ex)
       {

       }

   }

    @Test
    public void testRemoveStudent()
    {
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
    public  void testFindStudentsByName(){
        try
        {
            register.addStudent(new Student(6, "ruwan", "tharaka"));
            register.addStudent(new Student(7, "nimal", "kumara"));
            register.addStudent(new Student(8, "mayan", "chamara"));
            register.addStudent(new Student(9, "nimal", "kumara"));
            register.addStudent(new Student(10, "gayan", "chamara"));
            register.addStudent(new Student(11, "ruwan", "tharuka"));
        }
        catch (Exception ex)
        {
            Assert.fail("Find Students By Name failed");
        }
        try {
            //Testing for first name match
            ArrayList<Student> studentsT1 = register.findStudentsByName("ruwan");
            ArrayList<Student> expectedT1 = new ArrayList<Student>();
            expectedT1.add(new Student(6, "ruwan", "tharaka"));
            expectedT1.add(new Student(11, "ruwan", "tharuka"));


            Assert.assertTrue(studentsT1.equals(expectedT1));

            //Testing for last name match
            ArrayList<Student> studentsT2 = register.findStudentsByName("chamara");
            ArrayList<Student> expectedT2 = new ArrayList<Student>();
            expectedT2.add(new Student(8, "mayan", "chamara"));
            expectedT2.add(new Student(10, "gayan", "chamara"));

            Assert.assertTrue(studentsT2.equals(expectedT2));

            //Testing for first and last name match
            ArrayList<Student> studentsT3 = register.findStudentsByName("nimal");
            ArrayList<Student> expectedT3 = new ArrayList<Student>();
            expectedT3.add(new Student(7, "nimal", "kumara"));
            expectedT3.add(new Student(9, "nimal", "kumara"));

            Assert.assertTrue(studentsT3.equals(expectedT3));
        }catch(Exception e){
            System.out.println(e);
        }
    }
    @Test
    public void testReset(){
        try
        {
            register.addStudent(new Student(12, "pawan", "tharaka"));
            register.addStudent(new Student(23, "lawan", "kumara"));

        }
        catch (Exception ex)
        {
            Assert.fail("Reset registry failed");
        }

        register.reset();

        Assert.assertTrue(register.isEmpty());
    }

}
