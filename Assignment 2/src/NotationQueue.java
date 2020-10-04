import java.util.ArrayList;

public class NotationQueue<T> implements QueueInterface{

	private int defaultsize;
	private ArrayList<T> queue;

	public NotationQueue(){
		defaultsize = 100;
		queue= new ArrayList<T>();
	}

	public NotationQueue(int size){
		defaultsize = size;
		queue= new ArrayList<T>();
	}

	public NotationQueue(ArrayList<T> create){
		defaultsize = 100;
		queue= new ArrayList<T>();

		for(T a:create) {
			queue.add(a);
		}
	}



	/**
	 * Determines if Queue is empty
	 * @return true if Queue is empty
	 */
	public boolean isEmpty() {
		if(queue.size()==0)
			return true;
		return false;
	}

	/**
	 * Determines if the Queue is full
	 * @return true if Queue is full
	 */
	public boolean isFull() {
		if(queue.size()==defaultsize)
			return true;
		return false;
	}

	/**
	 * Deletes and returns the element at the front of the Queue
	 * @return the element at the front of the Queue
	 */
	public T dequeue() throws QueueUnderflowException {
		if(queue.size()==0)
			throw new QueueUnderflowException();
		T toReturn = queue.remove(0);
		return toReturn;
	}

	/**
	 * Number of elements in the Queue
	 * @return the number of elements in the Queue
	 */
	public int size() {
		return queue.size();
	}

	/**
	 * Adds an element to the end of the Queue
	 * @param e the element to add to the end of the Queue
	 * @return true if the add was successful, false if not
	 */
	public boolean enqueue(Object e) throws QueueOverflowException {
		if(queue.size()==defaultsize)
			throw new QueueOverflowException();
		queue.add(queue.size(), (T) e);
		return true;
	}



	/**
	 * Returns the string representation of the elements in the Queue, 
	 * the beginning of the string is the front of the queue
	 * @return string representation of the Queue with elements
	 */
	public String toString() {
		String string = "";
		for(T s: queue)
			string+=s+"";

		return string;
	}

	/**
	 * Returns the string representation of the elements in the Queue, the beginning of the string is the front of the queue
	 * Place the delimiter between all elements of the Queue
	 * @return string representation of the Queue with elements separated with the delimiter
	 */
	public String toString(String delimiter) {
		String string = "";
		for(T s: queue)
		string+=s+""+delimiter;
		string = string.substring(0,string.length()-1);
		return string;
	}

	@Override
	public void fill(ArrayList list) {
		// TODO Auto-generated method stub
		
	}

}