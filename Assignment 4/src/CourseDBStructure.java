import java.io.IOException;
import java.util.LinkedList;

/**
 * 
 * @author Rabindra Raj Suwal
 *
 */
public class CourseDBStructure implements CourseDBStructureInterface {

	private int tableSize;
	LinkedList<CourseDBElement>[] hashTable;
	
	/** Constructor that sets up the hash table
	 * 
	 *  @param numOfCourses The size of the hash table
	 */
	@SuppressWarnings("unchecked")
	public CourseDBStructure(int numOfCourses) {
		tableSize = numOfCourses;
		hashTable = new LinkedList[tableSize];
	}

	/** Temporary Constructor used for testing, 
	 * 
	 *  @param test Unused Variable
	 *  @param numOfCourses The size of the hash table
	 */
	public CourseDBStructure(String test, int numOfCourses) {
		this(numOfCourses);
	}
	
	/** Gets the size of the table
	 * 
	 *  @return the table size
	 */
	@Override
	public int getTableSize() {
		return tableSize;
	}

	/** Adds an element to the structure
	 *  
	 *  @param dbe The CourseDBElement to add
	 */
	@Override
	public void add(CourseDBElement dbe) {
		 int hashCode = dbe.hashCode();
	        int index = hashCode%hashTable.length;

	        if (hashTable[index] == null)
	        {
	            hashTable[index] = new LinkedList<CourseDBElement>();
	            hashTable[index].add(dbe);
	        }

	        else if (hashTable[index] != null)
	        {
	            hashTable[index].add(dbe);
	        }
	}

	/** Gets an element with the crn number passed through
	 * 
	 *  @param crn The crn to look up
	 *  
	 *  @return The element with hashcode crn
	 */
	@Override
	public CourseDBElement get(int crn) throws IOException {
		CourseDBElement toReturn = null;
		
		for (LinkedList<CourseDBElement> list : hashTable)
			if (list != null)
				for (CourseDBElement listElement : list)
					if (listElement.compareTo(new CourseDBElement("", crn, 0, "", "")) == 0)
						toReturn = listElement;
		
		if (toReturn == null)
			throw new IOException("Couldn't find " + crn);
		
		return toReturn;
	}

	

}
