package graph;

import java.util.ArrayList;
import java.util.PriorityQueue;

/*
 * Find minimum spanning tree in weighted graph
 * Refer: https://youtu.be/kXiqvMykeJA?si=J7EG0AS8icpKp9k4
 */
public class PrimsAlgorithm {
	
	//Returns length of minimum spanning tree
	public static int minSpanningTree(int v, ArrayList<ArrayList<ArrayList<Integer>>> adj) {
		boolean[] vis = new boolean[v];
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		
		pq.offer(new Pair(0,0));
		int ans = 0;
		
		while(!pq.isEmpty()) {
			Pair cur = pq.poll();
			int curVertex = cur.vertex;
			
			if(vis[curVertex])
				continue;
			
			ans += cur.weight;
			vis[curVertex] = true;
			
			ArrayList<ArrayList<Integer>> neighbors = adj.get(curVertex);
			
			for(ArrayList<Integer> i: neighbors) {
				int nVertex = i.get(0);
				int nWeight = i.get(1);
				if(!vis[nVertex])
					pq.offer(new Pair(nVertex, nWeight));
			}
		}
		
		return ans;
	}
	
	static class Pair implements Comparable<Pair>{
		int vertex;
		int weight;
		
		public Pair(int vertex, int weight) {
			this.vertex = vertex;
			this.weight = weight;
		}

		@Override
		public int compareTo(Pair that) {
			return this.weight - that.weight;
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
		
		int length = minSpanningTree(graph.vertices, graph.list);
		System.out.println("Length of minimum spanning tree: " + length);
	}
}
