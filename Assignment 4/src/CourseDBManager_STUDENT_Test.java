

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * This is the test file for the CourseDBManager
 * which is implemented from the CourseDBManagerInterface
 * 
 * @author Rabindra Raj Suwal
 *
 */
public class CourseDBManager_STUDENT_Test {
	private CourseDBManagerInterface dataMgr = new CourseDBManager();

	/**
	 * Create an instance of CourseDBManager
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		dataMgr = new CourseDBManager();
	}

	/**
	 * Set dataMgr reference to null
	 * @throws Exception
	 */
	@After
	public void tearDown() throws Exception {
		dataMgr = null;
	}

	/**
	 * Test for the add method
	 */
	@Test
	public void testAddToDB() {
		try {
			dataMgr.add("Test_1",1111,3,"ROOM100","Ramacharan");
		}
		catch(Exception e) {
			fail("This should not have caused an Exception");
		}
	}
	
	/**
	 * Test for the showAll method
	 */
	@Test
	public void testShowAll() {
		dataMgr.add("Test_1",1111,3,"ROOM100","Ramacharan");
		dataMgr.add("Test_2",2222,4,"ROOM101","Ghanshyam");
		dataMgr.add("Test_3",3333,2,"ROOM102","Laure");
		ArrayList<String> list = dataMgr.showAll();
		
		assertEquals(list.get(0),"\nCourse:Test_2 CRN:2222 Credits:4 Instructor:Ghanshyam Room:ROOM101");
		assertEquals(list.get(1),"\nCourse:Test_1 CRN:1111 Credits:3 Instructor:Ramacharan Room:ROOM100");
		assertEquals(list.get(2),"\nCourse:Test_3 CRN:3333 Credits:2 Instructor:Laure Room:ROOM102");
			}
	/**
	 * Test for the read method
	 */
	@Test
	public void testRead() {
		try {
			File inputFile = new File("tester.txt");
			PrintWriter inFile = new PrintWriter(inputFile);
			inFile.println("TestRead 55555 2 Room205 Balaram");
			inFile.print("TestRead 55555 2 Room205 Balaram");
			
			inFile.close();
			dataMgr.readFile(inputFile);
			//System.out.println(dataMgr.showAll());
		} catch (Exception e) {
			fail("Should not have thrown an exception");
		}
	}
}