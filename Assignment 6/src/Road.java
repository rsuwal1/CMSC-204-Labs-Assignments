

public class Road implements Comparable<Road> {

	protected Town start = null;
	protected Town dest = null;
	protected String name = "";
	protected int weight = 0;
	
/**
 * 
 * @param source
 * @param destination
 * @param weight
 * @param roadName
 */
	public Road(Town source, Town destination, int weight, String roadName) {

		this.start = source;
		this.dest = destination;
		this.weight = weight;
		this.name = roadName;
	}


	/**
	 * Constructor with weight preset at 1
	 * @param source
	 * @param destination
	 * @param name
	 */
	public Road(Town source, Town destination, String name) {

		this.start = source;
		this.dest = destination;
		this.weight = 1;
		this.name = name;
	}
	

	public String getName() {
		return this.name;
	}
	

	public Town getSource() {
		return this.start;
	}
	
	
	public void setSource(Town source) {
		this.start = source;
	}

	
	public Town getDestination() {
		return this.dest;
	}
	
	
	public void setDestination(Town destination) {
		this.dest = destination;
	}
	

	public int getWeight() {
		return this.weight;
	}
	
	
	public void setDegrees(int degrees) {
		this.weight = degrees;
	}
	

	public int hashCode() {
		return this.name.hashCode();
	}
	

	public String toString() {
		return this.name;
	}
	
	
	public void setName(String name) {
		this.name = name;
	}
	

	/**
	 * Returns true only if the edge contains the given town
	 * @param t
	 * @return
	 */
	public boolean contains(Town t) {
		return this.start.equals(t) || this.dest.equals(t);
	}

	
	/**
	 * @param r
	 * @return true if each of the ends of the road r is the same as the ends of this road
	 */
	public boolean equals(Object r) {	
		boolean smatch = this.start.equals(((Road) r).start) || this.start.equals(((Road) r).dest);
		boolean dmatch = this.dest.equals(((Road) r).start) || this.dest.equals(((Road) r).dest);
		boolean result = r == this || (smatch && dmatch);

		return result;
	}
	
	/**
	 * @return 0 if the road names are the same, a positive or negative number if the road names are not the same
	 */
	public int compareTo(Road r) {
		return this.getWeight() - r.getWeight();
	}
}