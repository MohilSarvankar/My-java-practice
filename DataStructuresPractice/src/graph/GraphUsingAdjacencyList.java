package graph;

import java.util.ArrayList;

public class GraphUsingAdjacencyList {
	int vertices;
	ArrayList<ArrayList<Integer>> list;
	
	public GraphUsingAdjacencyList(int v) {
		vertices = v;
		list = new ArrayList<>();
		
		for(int i=0; i<v; i++) {
			list.add(new ArrayList<>());
		}
	}
	
	public void addEdge(int src, int dest) {
		list.get(src).add(dest);
		list.get(dest).add(src);
	}
	
	public void printGraph() {
		for(int i=0; i<vertices; i++) {
			System.out.print("Nodes connected to " + i + " -> ");
			for(int j: list.get(i)) {
				System.out.print(j+ " ");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		
		GraphUsingAdjacencyList graph = new GraphUsingAdjacencyList(5);
		
		graph.addEdge(0, 1);
		graph.addEdge(0, 3);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        
        System.out.println("Adjacency List Representation of the Graph:");
        graph.printGraph();
	}
}
