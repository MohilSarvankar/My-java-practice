package graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

/*
 * Breadth First Search Algorithm (BFS)
 * Refer: https://youtu.be/dCvnjapI6ik?si=6atFniXC9L9_xZ-W
 */
public class BFSAlgorithm {
	
	/*
	 * Find minimum distance between source and destination
	 */
	public static boolean bfs(ArrayList<ArrayList<Integer>> adj, int src, int dest, int v, int[] pred, int[] dist) {
		Queue<Integer> q = new ArrayDeque<>();
		boolean[] visited = new boolean[v];
		
		for(int i=0; i<v; i++) {
			visited[i] = false;
			dist[i] = Integer.MAX_VALUE;
			pred[i] = -1;
		}
		
		q.offer(src);
		visited[src] = true;
		dist[src] = 0;
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			for(int neighbor: adj.get(cur)) {
				if(!visited[neighbor]){
					visited[neighbor] = true;
					dist[neighbor] = dist[cur] + 1;
					pred[neighbor] = cur;
					q.offer(neighbor);
					if(neighbor == dest)
						return true;
				}
			}
		}
		
		return false;
	}

	/*
	 * Find number of connected components
	 */
	public static void bfs2(ArrayList<ArrayList<Integer>> adj, boolean[] visited, int src) {
		Queue<Integer> q = new ArrayDeque<>();
		q.offer(src);
		visited[src] = true;
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			for(int neighbor: adj.get(cur)) {
				if(!visited[neighbor]) {
					visited[neighbor] = true;
					q.offer(neighbor);
				}
			}
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
		
		int[] pred = new int[graph.vertices];
		int[] dist = new int[graph.vertices];
		int src = 1;
		int dest = 4;
		
		boolean isReached = bfs(graph.list, src, dest, graph.vertices, pred, dist);
		
		System.out.println("Is destination reached: " + isReached);
		System.out.println("Minimum distance between source and destination is: "+ dist[dest]);
		
		System.out.println("Path from source to detination: ");
		int temp = dest;
		do {
			System.out.print(temp + " <- ");
			temp = pred[temp];
		}while(temp != -1);
		System.out.println();
		
		//Find out no of connected components
		boolean[] visited = new boolean[graph.vertices];
		int component = 0;
		
		for(int i=0; i<graph.vertices; i++) {
			if(!visited[i]) {
				component++;
				bfs2(graph.list, visited, i);
			}
		}
		System.out.println("No of connected components: "+ component);
	}
}
