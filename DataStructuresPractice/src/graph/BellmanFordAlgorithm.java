package graph;

import java.util.ArrayList;
import java.util.Arrays;

/*
 * Also used to find min distance from source
 * refer: https://youtu.be/RiWE52X5wdQ?si=KEBiozuBH4PXnygy
 */
public class BellmanFordAlgorithm {

	public static int[] minDistance(int v, int s, ArrayList<ArrayList<ArrayList<Integer>>> adj) {
		int dist[] = new int[v];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[s] = 0;
		
		for(int i=0; i<v-1; i++) {
			for(int j=0; j<v; j++) {
				ArrayList<ArrayList<Integer>> vertex = adj.get(j);
				for(ArrayList<Integer> edge: vertex) {
					int src = j;
					int dest = edge.get(0);
					int wt = edge.get(1);
					if(dist[src] != Integer.MAX_VALUE && dist[src] + wt < dist[dest]) {
						dist[dest] = dist[src] + wt;
					}
				}
			}
		}
		
		for(int j=0; j<v; j++) {
			ArrayList<ArrayList<Integer>> vertex = adj.get(j);
			for(ArrayList<Integer> edge: vertex) {
				int src = j;
				int dest = edge.get(0);
				int wt = edge.get(1);
				if(dist[src] + wt < dist[dest]) {
					System.out.println("Negative weight cycle present");
				}
			}
		}
		
		return dist;
	}
	
	public static void main(String[] args) {
		WeightedGraph graph = new WeightedGraph(4);
		
		graph.addDirectedEdge(0, 1, 3);
		graph.addDirectedEdge(0, 2, 1);
		graph.addDirectedEdge(1, 2, -4);
		graph.addDirectedEdge(2, 3, 2);
		graph.addDirectedEdge(3, 1, 4);
		
		System.out.println("Adjacency List Representation of the Graph:");
		graph.printGraph();
		
		int source = 0;
		int[] ans = minDistance(graph.vertices, source, graph.list);
		System.out.println("Minimum distance from source: " + Arrays.toString(ans));
	}
}
