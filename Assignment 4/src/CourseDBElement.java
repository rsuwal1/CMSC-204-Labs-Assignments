/**
 * 
 * @author Rabindra Raj Suwal
 *
 */
public class CourseDBElement implements Comparable {

	private String courseID;
	private int crnNum;
	private int numofCredits;
	private String roomNum;
	private String instructor;
	
	
	public CourseDBElement() {
		this("", 0, 0, "", "");
	}
	
	
	/** Constructor that sets values to what was passed through
	 *  
	 *  @param courseID The ID of the course
	 *  @param crn the CRN Number of the course
	 *  @param numOfCredits The number of credits for the course
	 *  @param roomNum the number of the room
	 *  @param instructor the instructor
	 */
	public CourseDBElement(String courseID, int crn, int numOfCredits, String roomNum, String instructor) {
		this.courseID = courseID;
		this.crnNum = crn;
		this.numofCredits = numOfCredits;
		this.roomNum = roomNum;
		this.instructor = instructor;
	}

	/** Gets the course ID
	 * 
	 * @return courseID
	 */
	public String getCourseID() {
		return courseID;
	}

	/** Sets the course ID
	 * 
	 * @param courseID
	 */
	public void setCourseID(String courseID) {
		this.courseID = courseID;
	}

	/** Gets the Course CRN Number
	 * 
	 * @return crnNum
	 */
	public int getCRN() {
		return crnNum;
	}

	/** Sets the CRN Number
	 * 
	 * @param crnNumber
	 */
	public void setCRN(int crnNumber) {
		this.crnNum = crnNumber;
	}

	/** Gets the number of credits
	 * 
	 * @return numofCredits
	 */
	public int getNumberOfCredits() {
		return numofCredits;
	}

	/** Sets the number of credits
	 * 
	 * @param numberOfCredits
	 */
	public void setNumberOfCredits(int numberOfCredits) {
		this.numofCredits = numberOfCredits;
	}

	/** Gets the room number
	 * 
	 * @return roomNum
	 */
	public String getRoomNumber() {
		return roomNum;
	}

	/** Sets the room number
	 * 
	 * @param roomNumber
	 */
	public void setRoomNumber(String roomNumber) {
		this.roomNum = roomNumber;
	}

	/** Gets the instructor
	 * 
	 * @return instructor
	 */
	public String getInstructor() {
		return instructor;
	}

	/** Sets the instructor
	 * 
	 * @param instructor
	 */
	public void setInstructor(String instructor) {
		this.instructor = instructor;
	}
	
	/** Gets the hash code of crn number converted
	 *  into a String
	 * 
	 *  @return The hash code of the crn number
	 */
	public int hashCode() {
		String crn = Integer.toString(crnNum);
        int hashCode = crn.hashCode();
        return hashCode;
	}

	/** Compares this class with another class
	 *  
	 *  @param element Another instance of this class
	 *  
	 *  @return positive number if the hashcode of this class
	 *  is greater than the hashcode of element, a negative number if
	 *  the hashcode of this class is less than the hashcode of element,
	 *  and 0 if they're the same
	 */
	@Override
	public int compareTo(CourseDBElement element) {
		return hashCode() - element.hashCode();
	}

	/** Gets the attributes of CourseDBElement
	 * 
	 * @return info of CourseDBElement
	 */
	@Override
	public String toString() {
		return "Course:" + courseID + " CRN:" + crnNum + " Credits:" + numofCredits + " Instructor:" + instructor + " Room:" + roomNum;
	}
}
