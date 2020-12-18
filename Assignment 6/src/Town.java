public class Town implements Comparable<Town>{
	
	protected String name = "";
	protected java.util.Set<Town> towns = new java.util.HashSet<Town>();
	protected int weight = Integer.MAX_VALUE;
	protected Town previous = null;

	public Town(String name) {

		this.name = name;
	}

	/**
	 * Copy constructor.
	 * @param templateTown
	 */
	public Town(Town templateTown) {

		this.name = templateTown.name;
		this.weight = templateTown.weight;
		this.towns = templateTown.towns;
		this.previous = templateTown.previous;
	}

	
	public void reset() {
		this.weight = Integer.MAX_VALUE;
		this.previous = null;
	}
	

	public String getName() {
		return this.name;
	}
	

	public int hashCode() {
		return this.name.hashCode();
	}
	

	public String toString() {
		return this.getName();
	}


	/**
	 * @return true if the town names are equal, false if not
	 */
	public boolean equals(Object t) {
		return t == this || this.name.toLowerCase().equals(((Town) t).name.toLowerCase());
	}
	

	/**
	 * @return 0 if names are equal, a positive or negative number if the names are not equal
	 */
	public int compareTo(Town t) {
		return this.name.compareTo(t.name);
	}
}