package graph;

import java.util.ArrayList;

/*
 * DFS (Depth first search) Algorithm
 * Refer: https://youtu.be/0ql7lZS2qt0?si=5tOwR2eJ6N3DcrSZ
 */
public class DFSAlgorithm {
	
	public static void dfs(int src, ArrayList<ArrayList<Integer>> adj, boolean[] visited, ArrayList<Integer> res) {
		visited[src] = true;
		res.add(src);
		
		for(int neighbor: adj.get(src)) {
			if(!visited[neighbor])
				dfs(neighbor, adj, visited, res);
		}
	}
	
	public static void main(String[] args) {
		
		GraphUsingAdjacencyList graph = new GraphUsingAdjacencyList(8);
		
		//1st connected component
		graph.addEdge(0, 2);
		graph.addEdge(0, 3);
		graph.addEdge(0, 4);
		graph.addEdge(1, 2);
		graph.addEdge(2, 3);
		graph.addEdge(3, 4);
		
		//2nd connected component
		graph.addEdge(5, 6);
		graph.addEdge(6, 7);
		
		graph.printGraph();
		
		boolean[] visited = new boolean[graph.vertices];
		ArrayList<Integer> res = new ArrayList<>();
		int connected = 0;
		
		for(int i=0; i<graph.vertices; i++) {
			if(!visited[i]) {
				connected++;
				dfs(i, graph.list, visited, res);
			}
		}
		
		System.out.println("DFS Traversal: "+ res);
		System.out.println("No of connected components: "+ connected);
	}
}
