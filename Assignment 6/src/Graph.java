
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;


public class Graph implements GraphInterface<Town, Road> {

	final int noEdge = Integer.MAX_VALUE;
	final int noPath = Integer.MAX_VALUE;

	private Set<Town> twn = new HashSet<>();
	private Set<Road> rd = new HashSet<>();
	private ArrayList <String> s_list = new ArrayList<>();
	private Town dist;
	private int endTown;

	
    
	@Override
	public Road getEdge(Town sourceVertex, Town destinationVertex) {
		Road road = null;

		for (Road r : rd) {
			if (r.contains(sourceVertex) && r.contains(destinationVertex)) {
				road = r;
			}
		}
		return road;
	}

    
	@Override
	public Road addEdge(Town sourceVertex, Town destinationVertex, int weight, String description) {
		if (sourceVertex == null || destinationVertex == null) {
			throw new NullPointerException ();
		}

		Road road = new Road(sourceVertex, destinationVertex, weight, description);
		rd.add(road);
		return road;
	}

   
	@Override
	public boolean addVertex(Town town) {

		if (town == null) {
			throw new NullPointerException();
		}

		if (!twn.contains(town)) {
			twn.add(town);
			return true;
		}
		else return false;
	}


    
	@Override
	public boolean containsEdge(Town sourceVertex, Town destinationVertex) {

		for (Road r: rd) {
			if (r.contains(sourceVertex) && r.contains(destinationVertex)) {
				return true;
			}
		}
		return false;
	}

    
	@Override
	public boolean containsVertex(Town town) {

		for (Town t : twn) {
			if(t.getName().equals(town.getName())) {
				return true;
			}
		}
		return false;
	}

    
	@Override
	public Set<Road> edgeSet() {

		return rd;
	}

   
	@Override
	public Set<Road> edgesOf(Town vertex) {
		Set<Road> edges = new HashSet<>();
		for (Road r: rd) {
			if (r.contains(vertex)) {
				edges.add(r);
			}
		}
		return edges;
	}

   
	@Override
	public Road removeEdge(Town sourceVertex, Town destinationVertex, int weight, String description) {
		Road road = null;
		for (Road r: rd) {
			if (r.contains(destinationVertex) && r.contains(sourceVertex)
					&& (weight > -1) && description != null)
				road = r;
		}
		if (rd.remove(road)) {
			return road;
		}
		else {
			return null;
		}
	}

    
	@Override
	public boolean removeVertex(Town town) {
		return twn.remove(town);
	}

    
	@Override
	public Set<Town> vertexSet() {

		return twn;
	}

    
	@Override
	public ArrayList<String> shortestPath(Town sourceVertex, Town destinationVertex) {
		
		dist = destinationVertex;
		dijkstraShortestPath(sourceVertex);
		String shortest = "";

		for (int i = 0; i < s_list.size()-1; i++) {
			
			Town start = new Town(s_list.get(i));
			Town dstn = new Town(s_list.get(i+1));
			Road road = getEdge(start,dstn);
			if (road == null) {
				break;
			}

			shortest += start+" via "+road.getName()+" to "+dstn+" "+road.getWeight()+" mi;";
		}
		s_list.clear();
		if(!shortest.contains(destinationVertex.getName())) {
			return s_list;
		}
		for(String leg : shortest.split(";")) {
			s_list.add(leg);
		}

		return s_list;
	}

	   
	@Override
	public void dijkstraShortestPath(Town sourceVertex) {
		
		s_list.clear();
		Town[] allTowns = new Town[twn.size()];
		int index = 0;
		
		for (Town t: twn) {
			
			allTowns[index] = new Town(t);
			index++;
		}
		
		int[][] adjacencyMatrix = new int[twn.size()][twn.size()];
		
		for (int i = 0; i < adjacencyMatrix.length; i++) {
			for (int j = 0; j < adjacencyMatrix[i].length; j++) {
				if (i == j || !containsEdge(allTowns[i], allTowns[j])) {
					adjacencyMatrix[i][j] = 0;
					
				} else {
					int weight = getEdge(allTowns[i], allTowns[j]).getWeight();
					adjacencyMatrix[i][j] = adjacencyMatrix[j][i] = weight;
				}
			}
		}
		int startTown = 0; 
		for (Town t: allTowns) {

			if (!t.equals(sourceVertex)) {
				startTown++;
			} else {
				break;
			}
		}

		endTown = 0;
		for (Town t: allTowns) {
			if (!t.equals(dist)) {
				endTown++;
			} else {
				break;
			}
		}

		int numTowns = adjacencyMatrix[0].length;
		int[] smallestWeights = new int[numTowns];

		boolean[] added = new boolean[numTowns];

		for (int townIndex = 0; townIndex < numTowns; townIndex++) {

			smallestWeights[townIndex] = noEdge;
			added[townIndex] = false;
		}
		smallestWeights[startTown] = 0;
		int[] minLengthsPath = new int[numTowns];
		minLengthsPath[startTown] = -1;

		for (int i = 1; i < numTowns; i++) {

			int nearestTown = -1;
			int smallestWeight = noEdge;
			for (int townIndex = 0; townIndex < numTowns; townIndex++) {

				if (!added[townIndex] && smallestWeights[townIndex] < smallestWeight) {
					nearestTown = townIndex;
					smallestWeight = smallestWeights[townIndex];
				}
			}

			added[nearestTown] = true;

			for (int townIndex = 0; townIndex < numTowns; townIndex++) {

				int roadDistance = adjacencyMatrix[nearestTown][townIndex];

				if (roadDistance > 0 && ((smallestWeight + roadDistance)< smallestWeights[townIndex])) {

					minLengthsPath[townIndex] = nearestTown;
					smallestWeights[townIndex] = smallestWeight + roadDistance;
				}
			}
		}
		addToPathArrayList(endTown, minLengthsPath);
	}

	
	private void addToPathArrayList(int sourceVertex, int[] minLengthsPath) {

		if (sourceVertex == -1) {
			return;
		}

		addToPathArrayList(minLengthsPath[sourceVertex], minLengthsPath);

		int townIndex = 0;

		for (Town t: twn) {

			if (townIndex == sourceVertex) {

				s_list.add(t.getName());
			}

			townIndex++;
		}
	}


}