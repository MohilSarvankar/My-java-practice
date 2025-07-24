package graph;

import java.util.ArrayList;
import java.util.Arrays;

public class WeightedGraph {
	
	int vertices;
	ArrayList<ArrayList<ArrayList<Integer>>> list;
	
	public WeightedGraph(int n) {
		vertices = n;
		list = new ArrayList<>();
		for(int i=0; i<n; i++) {
			list.add(new ArrayList<>());
		}
	}
	
	public void addEdge(int src, int dest, int weight) {
		list.get(src).add(new ArrayList<>(Arrays.asList(dest, weight)));
		list.get(dest).add(new ArrayList<>(Arrays.asList(src, weight)));
	}
	
	public void addDirectedEdge(int src, int dest, int weight) {
		list.get(src).add(new ArrayList<>(Arrays.asList(dest, weight)));
	}
	
	public void printGraph() {
		for(int i=0; i<vertices; i++) {
			System.out.print("Nodes connected to " + i + " -> ");
			for(ArrayList<Integer> j: list.get(i)) {
				System.out.print(j + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		
		WeightedGraph graph = new WeightedGraph(5);
		
		graph.addEdge(0, 1, 2);
		graph.addEdge(0, 3, 7);
		graph.addEdge(0, 4, 6);
		graph.addEdge(1, 4, 4);
		graph.addEdge(1, 2, 1);
		graph.addEdge(2, 3, 3);
		graph.addEdge(2, 4, 2);
		graph.addEdge(3, 4, 5);
		
		System.out.println("Adjacency List Representation of the Graph:");
        graph.printGraph();
	}

}
