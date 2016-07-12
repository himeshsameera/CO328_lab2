package lk.ac.pdn.co328.studentSystem;
import org.junit.*;
import java.util.ArrayList;

public class StudentRegisterTest {
    StudentRegister register;

    @Before
    public void setupTest()
    {
      System.out.println("A new test is starting.");

      /*Step 03 - to create a new student register before each test we can add that part of code here.
                  Because @Before runs before each test.
      */

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
       // Adding a student with same registration number twice should generate an exception.

     //Step 02 - We have to register 2 students with the same reg no.
     register = new StudentRegister();
     try
     { //adding only two students are sufficient.
       register.addStudent(new Student(5, "nimal", "kumara"));
       register.addStudent(new Student(5, "ruwan", "tharaka"));
       Assert.fail("Add student failed");
     }
     catch (Exception ex) { }

   }

    @Test
    public void testRemoveStudent()
    {

        register.removeStudent(1);
        Student student = register.findStudent(1);
        Assert.assertNull("student was not removed",student);
    }

    @Test
    public void testGetRegNumbers()
    {

        ArrayList<Integer> numbers = register.getAllRegistrationNumbers();
        ArrayList<Integer> expected = new ArrayList<Integer>();
        expected.add(1);
        expected.add(2);
        expected.add(5);
        Assert.assertTrue(numbers.equals(expected));
    }
  @Test
  public void testSearchByName(){
    // Step 04 - part1
    ArrayList<Student> students = register.findStudentsByName("gayan");
    /* If the person who is searched by the name includes in the "students" ArrayList ,
            the size of the ArrayList should be one.
    */
    Assert.assertTrue("Search by name is successful. gayan is found",students.size() == 1);

  }


  @Test
  public void testReset(){
    register.reset();

    // Step 04 - part2
    ArrayList<Integer> regNumbers = register.getAllRegistrationNumbers();
    /* If the reset is successful , it removes all the data from the student register
              and then the size of the "regNumbers" ArrayList should be zero.
    */
    Assert.assertTrue("Reset is successful.",regNumbers.size() == 0);

  }

}

