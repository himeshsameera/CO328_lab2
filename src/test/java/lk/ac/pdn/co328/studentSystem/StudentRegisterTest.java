package lk.ac.pdn.co328.studentSystem;
import org.junit.*;
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
            register.addStudent(new Student(1, "A", "B"));
             register.addStudent(new Student(2, "C", "D"));
         }
         catch (Exception ex)
         {
             Assert.fail("set up test failed");
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
       // Implement your test code here. Adding a student with same registration number twice should generate an exception.
		try
       {
            register.addStudent(new Student(3, "E", "F"));
            register.addStudent(new Student(3, "E", "F"));
        }
        catch (Exception ex)
        {
            System.out.println("AddStudentTwice test succeeded");
            return;
        }
        Assert.fail("AddStudentTwice test failed.");
  }

    @Test
    public void testRemoveStudent()
    {
        
        try
        {
            register.addStudent(new Student(4, "I", "J"));
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
            register.addStudent(new Student(5, "K", "L"));
        }
        catch (Exception ex)
        {
            Assert.fail("Adding student failed");
        }
		ArrayList<Integer> numbers = register.getAllRegistrationNumbers();
        ArrayList<Integer> expected = new ArrayList<Integer>();
        expected.add(5);
        Assert.assertTrue(numbers.equals(expected));
    }
	
	@Test
	public void test_FindStudentsByName()
     {
         try
         {
             register.addStudent(new Student(6, "M", "N"));
             register.addStudent(new Student(7, "O", "P"));
			 register.addStudent(new Student(8, "Q", "O"));
         }
         catch (Exception ex)
         {
             Assert.fail("Adding student failed");
         }
         ArrayList<Student> std = register.findStudentsByName("O");
         ArrayList<Student> expected = new ArrayList<Student>();
         expected.add(register.findStudent(7));
         expected.add(register.findStudent(8));
         Assert.assertTrue(std.equals(expected));
     }
	 
	@Test
     public void test_Reset()
    {
        try
         {
             register.addStudent(new Student(9, "J", "A"));
         }
         catch (Exception ex)
         {
             Assert.fail("Adding student failed");
         }
         register.reset();
         Student student = register.findStudent(1);
         Assert.assertNull("test reset failed",student);
    }
}
