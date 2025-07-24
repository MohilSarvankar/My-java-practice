package graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Stack;

/*
 * Topological sorting in a directed acyclic graph
 */
public class TopologicalSorting {
	
	/*
	 * Using dfs
	 * Refer: https://youtu.be/Zbbe9FYVnM4?si=G47d7aOg1LkUq_Yq
	 */
	static void dfs(int src, ArrayList<ArrayList<Integer>> adj, boolean[] visited, Stack<Integer> stack) {
		visited[src] = true;
		
		for(int neighbor: adj.get(src)) {
			if(!visited[neighbor])
				dfs(neighbor, adj, visited, stack);
		}
		
		stack.push(src);
	}
	
	/*
	 * Using bfs
	 * Refer: https://youtu.be/XMiIk1B0v-w?si=ilrfU7F4xwkLLTC1
	 */
	static void bfs(int v, ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> ans) {
		int[] indeg = new int[v];
		for(ArrayList<Integer> list: adj) {
			for(int i: list)
				indeg[i]++;
		}
		
		Queue<Integer> q = new ArrayDeque<>();
		for(int i=0; i<v; i++) {
			if(indeg[i] == 0)
				q.offer(i);
		}
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			ans.add(cur);
			
			for(int neighbor: adj.get(cur)) {
				indeg[neighbor]--;
				if(indeg[neighbor] == 0)
					q.offer(neighbor);
			}
		}
	}

	public static void main(String[] args) {
		
		DirectedGraphUsingAdjacencyList graph = new DirectedGraphUsingAdjacencyList(9);
		
		//1st component
		graph.addEdge(0, 3);
		graph.addEdge(0, 2);
		graph.addEdge(2, 3);
		graph.addEdge(2, 1);
		graph.addEdge(3, 1);
		graph.addEdge(5, 1);
		graph.addEdge(5, 4);
		graph.addEdge(1, 4);
		
		//2nd component
		graph.addEdge(6, 7);
		graph.addEdge(7, 8);
		graph.addEdge(6, 8);
		
		graph.printGraph();
		
		Stack<Integer> stack = new Stack<>();
		boolean[] visited = new boolean[graph.vertices];
		
		for(int i=0; i<graph.vertices; i++) {
			if(!visited[i])
				dfs(i, graph.list, visited, stack);
		}
		
		System.out.println("Topological sorting using dfs: ");
		while(!stack.isEmpty())
			System.out.print(stack.pop() + " ");
		System.out.println();
		
		/*===============================================*/
		
		ArrayList<Integer> ans = new ArrayList<>();
		
		bfs(graph.vertices, graph.list, ans);
		
		System.out.println("Topological sorting using bfs: " + ans);
	}

}
