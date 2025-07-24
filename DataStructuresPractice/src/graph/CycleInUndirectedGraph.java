package graph;

import java.util.ArrayList;

/*
 * Detect cycle in undirected graph
 * Refer: https://youtu.be/UPfUFoWjk5w?si=1IX5TAu0otvDTel1
 */
public class CycleInUndirectedGraph {
	
	public static boolean dfs(int src, ArrayList<ArrayList<Integer>> adj, boolean[] visited, int parent) {
		visited[src] = true;
		
		for(int neighbor: adj.get(src)) {
			if(!visited[neighbor]) {
				if(dfs(neighbor, adj, visited, src))
					return true;
			}
			else if(neighbor != parent)
				return true;
		}
		
		return false;
	}

	public static boolean detectCycle(int v, ArrayList<ArrayList<Integer>> adj) {
		boolean[] visited = new boolean[v];
		
		for(int i=0; i<v; i++) {
			if(!visited[i]) {
				if(dfs(i, adj, visited, -1))
					return true;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		
		GraphUsingAdjacencyList graph = new GraphUsingAdjacencyList(8);
		
		//1st connected component
		graph.addEdge(0, 3);
		graph.addEdge(0, 4);
		graph.addEdge(1, 2);
		graph.addEdge(2, 3);
		graph.addEdge(3, 4);
		
		//2nd connected component
		graph.addEdge(5, 6);
		graph.addEdge(6, 7);
		
		graph.printGraph();
		
		boolean isCyclePresent = detectCycle(graph.vertices, graph.list);
		System.out.println("Is cycle present: " + isCyclePresent);
	}

}
