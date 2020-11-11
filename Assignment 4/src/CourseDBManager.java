import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * 
 * @author Rabindra Raj Suwal
 *
 */
public class CourseDBManager implements CourseDBManagerInterface {

	private CourseDBStructure dbs;
	
	
	public CourseDBManager() {
		dbs = new CourseDBStructure(100);
	}
	
	/** Adds an element to the structure
	 * 
	 *  @param id The course ID
	 *  @param crn The course CRN number
	 *  @param credits The number of credits of the course
	 *  @param roomNum The room number of the course
	 *  @param instructor The instructor of the course
	 */
	@Override
	public void add(String id, int crn, int credits, String roomNum, String instructor) {
		dbs.add(new CourseDBElement(id, crn, credits, roomNum, instructor));
	}

	/** Gets an element from the structure
	 * 
	 *  @param crn The crn of the element that you want to get
	 *  
	 *  @return The element with the crn that was passed through
	 */
	@Override
	public CourseDBElement get(int crn) {
		CourseDBElement dbe = new CourseDBElement("", 0, 0, "", "");
		try {
			dbe = dbs.get(crn);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return dbe;
		
		
	}

	/** Reads a file and adds everything in that file into the structure
	 * 
	 *  @param input The file to read
	 */
	@Override
	public void readFile(File input) throws FileNotFoundException {
		String id = "";
		String stringCrn = "";
		String strCredits = "";
		String instructor = "";
		String room = "";
		int crn = 0;
		int credits = 0;

		Scanner readInput = new Scanner(input);
		while (readInput.hasNext()) {
			if (readInput.hasNext()) {
				id = readInput.next();
			}

			if (readInput.hasNext()) {
				stringCrn = readInput.next();
			}
			crn = Integer.parseInt(stringCrn);

			if (readInput.hasNext()) {
				strCredits = readInput.next();
			}
			credits = Integer.parseInt(strCredits);

			if (readInput.hasNext()) {
				room = readInput.next();
			}
			if (readInput.hasNext()) {
				instructor = readInput.nextLine();
			}
			add(id, crn, credits, room, instructor);
		}
		readInput.close();
	}

	/** Gets an element's data
	 * 
	 *  @return An ArrayList with the data of the elements in the structure
	 */
	@Override
	public ArrayList<String> showAll() {
		ArrayList<String> data = new ArrayList<>();
		
		for (LinkedList<CourseDBElement> list : dbs.hashTable)
			if (list != null)
				for (CourseDBElement listElement : list)
					data.add("\n" + listElement.toString());
		
		return data;
	}

}
