package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

import graph.PrimsAlgorithm.Pair;

/*
 * Dijkstra's Algorithm
 * Finding minimum distance of all the nodes in graph from given source
 * Refer: https://youtu.be/wjxCG6dOwcY?si=EYbxkWCA7rKgPfVZ
 */
public class DijkstrasAlgorithm {
	
	public static int[] minDistance(ArrayList<ArrayList<ArrayList<Integer>>> adj, int v, int source) {
		boolean[] vis = new boolean[v];
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		
		int[] ans = new int[v];
		Arrays.fill(ans, Integer.MAX_VALUE);
		
		pq.add(new Pair(source, 0));
		ans[0] = 0;
		
		while(!pq.isEmpty()) {
			Pair cur = pq.poll();
			int curVertex = cur.vertex;
			
			if(vis[curVertex])
				continue;
			
			vis[curVertex] = true;
			
			ArrayList<ArrayList<Integer>> neighbors = adj.get(curVertex);
			for(ArrayList<Integer> neighbor: neighbors) {
				int nVertex = neighbor.get(0);
				int nWeight = neighbor.get(1);
				
				if(ans[curVertex] + nWeight < ans[nVertex]) {
					ans[nVertex] = ans[curVertex] + nWeight;
					pq.offer(new Pair(nVertex, ans[nVertex]));
				}
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
		WeightedGraph graph = new WeightedGraph(6);
		
		graph.addEdge(0, 2, 4);
		graph.addEdge(0, 3, 2);
		graph.addEdge(2, 1, 9);
		graph.addEdge(2, 5, 1);
		graph.addEdge(3, 2, 3);
		graph.addEdge(3, 5, 1);
		graph.addEdge(5, 4, 2);
		graph.addEdge(1, 4, 1);
		
		System.out.println("Adjacency List Representation of the Graph:");
		graph.printGraph();
		
		int source = 0;
		int[] ans = minDistance(graph.list, graph.vertices, source);
		System.out.println("Minimum distance from source: " + Arrays.toString(ans));
	}
}
