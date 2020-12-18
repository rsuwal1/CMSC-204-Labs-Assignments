import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class TownGraphManager implements TownGraphManagerInterface {

	private Graph graph = new Graph();

	
	@Override
	public boolean addRoad(String t1, String t2, int weight, String roadName) {
		Town town1, town2;
		boolean result = false;
		town1 = new Town(t1);
		town2 = new Town(t2);
		if (graph.addEdge(town1, town2, weight, roadName) != null) {
			result = true;
		}
		return result;
	}

	@Override
	public String getRoad(String t1, String t2) {

		Town town1, town2;
		town1 = new Town(t1);
		town2 = new Town(t2);

		return graph.getEdge(town1, town2).getName();
	}

	
	@Override
	public boolean addTown(String n) {

		Town town;
		town = new Town(n);

		return graph.addVertex(town);
	}

	
	@Override
	public Town getTown(String n) {
		Town town;
		town = new Town(n);
		for (Town t: graph.vertexSet()) {
			if (t.equals(town)) {
				return t;
			}
		}
		return null;
	}

	
	@Override
	public boolean containsTown(String n) {
		Town town;
		town = new Town(n);

		return graph.containsVertex(town);
	}

	
	@Override
	public boolean containsRoadConnection(String t1, String t2) {

		Town town1, town2;
		town1 = new Town(t1);
		town2 = new Town(t2);

		return graph.containsEdge(town1,  town2);
	}

	
	@Override
	public ArrayList<String> allRoads() {

		ArrayList<String> list = new ArrayList<>();
		for(Road road: graph.edgeSet()) {
			list.add(road.getName());
		}
		Collections.sort(list);
		return list;
	}

	
	@Override
	public boolean deleteRoadConnection(String t1, String t2, String road) {
		Town town1, town2;
		town1 = new Town(t1);
		town2 = new Town(t2);
		int weight = 0;
		String rdname = "";
		boolean result = false;

		for (Road r: graph.edgeSet()) {
			if (r.contains(town1) && r.contains(town2)) {
				weight = r.getWeight();
			}
			rdname = r.getName();
		}
		if (graph.removeEdge(town1, town2, weight, rdname) != null) {
			result = true;
		}
		return result;
	}

	
	@Override
	public boolean deleteTown(String n) {
		Town town;
		town = new Town(n);
		return graph.removeVertex(town);
	}

	@Override
	public ArrayList<String> allTowns() {
		ArrayList<String> list = new ArrayList<>();
		for(Town t: graph.vertexSet()) {
			list.add(t.getName());
		}
		Collections.sort(list);
		return list;
	}

	
	@Override
	public ArrayList<String> getPath(String t1, String t2) {
		Town town1, tB;
		town1 = new Town(t1);
		tB = new Town(t2);

		return graph.shortestPath(town1,tB);
	}

	
	public void populateTownGraph(File f) throws FileNotFoundException, IOException {

		Scanner scan;
		if (f != null) {
			String[] line, text;
			String t1, t2;
			scan = new Scanner(f);
			while(scan.hasNext()) {
				line = scan.nextLine().split(";");
				t1 = line[1];
				Town t1Town = new Town(t1);
				t2 = line[2];
				Town t2Town = new Town(t2);
				text = line[0].split(",");
				graph.addVertex(t1Town);
				graph.addVertex(t2Town);
				graph.addEdge(t1Town,  t2Town,  Integer.parseInt(text[1]), text[0]);
			}

		}


	}




}