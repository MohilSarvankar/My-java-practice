package graph;

import java.util.ArrayList;

/*
 * Detect cycle in directed graph
 * Refer: https://youtu.be/GLxfoaZlRqs?si=TujyNmZEzxP_WATL
 */
public class CycleInDirectedGraph {
	
	public static boolean dfs(int src, ArrayList<ArrayList<Integer>> adj, boolean[] visited, boolean[] recStack) {
		visited[src] = true;
		recStack[src] = true;
		
		for(int neighbor: adj.get(src)) {
			if(!visited[neighbor]) {
				if(dfs(neighbor, adj, visited, recStack))
					return true;
			}
			else if(recStack[neighbor])
				return true;
		}
		
		recStack[src] = false;
		return false;
	}

	public static boolean detectCycle(int v, ArrayList<ArrayList<Integer>> adj) {
		boolean[] visited = new boolean[v];
		boolean[] recStack = new boolean[v];
		
		for(int i=0; i<v; i++) {
			if(!visited[i]) {
				if(dfs(i, adj, visited, recStack))
					return true;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		
		DirectedGraphUsingAdjacencyList graph = new DirectedGraphUsingAdjacencyList(5);
		
		graph.addEdge(0, 1);
		graph.addEdge(2, 1);
		graph.addEdge(2, 3);
		graph.addEdge(3, 4);
		graph.addEdge(4, 2);
		
		graph.printGraph();
		
		boolean isCyclePresent = detectCycle(graph.vertices, graph.list);
		System.out.println("Is cycle present: " + isCyclePresent);
	}

}
