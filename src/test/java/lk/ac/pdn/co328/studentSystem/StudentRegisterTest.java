package lk.ac.pdn.co328.studentSystem;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;
import java.util.Arrays;

public class StudentRegisterTest {
	StudentRegister register;

	@Before
	public void setupTest() {
		System.out.println("A new test is starting.");
		register = new StudentRegister();
	}

	@After
	public void finishTest() { // clearing resources
		register = null;
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

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Test
	public void testAddStudentTwice() throws Exception {
		thrown.expect(Exception.class);
		thrown.expectMessage("StudentID already exists in the register");
		
		register.addStudent(new Student(2, "nimal", "kumara"));
		register.addStudent(new Student(2, "fawzan", "mohomad"));

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
	public void testfindStudentsByName(){
		Student student1 = new Student(150, "is so fun", "testing");
		Student student3 = new Student(151, "testing1", "is so fun");
		Student student2 = new Student(152, "testing2", "is so fun");
		try {
			register.addStudent(student1);
			register.addStudent(student2);
			register.addStudent(student3);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
			Assert.assertArrayEquals(new Student[]{student1,student2,student3}, register.findStudentsByName("testing").toArray());	
			
			Assert.assertEquals(0, register.findStudentsByName("Zero result").size());
	}
	
	@Test
	public void testClear(){
		Student student1 = new Student(150, "is so fun", "testing");
		Student student3 = new Student(151, "testing1", "is so fun");
		Student student2 = new Student(152, "testing2", "is so fun");
		try {
			register.addStudent(student1);
			register.addStudent(student2);
			register.addStudent(student3);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Assert.assertTrue(register.getAllRegistrationNumbers().size()>0);
		register.reset();
		Assert.assertTrue(register.getAllRegistrationNumbers().size()==0);
	}
}
