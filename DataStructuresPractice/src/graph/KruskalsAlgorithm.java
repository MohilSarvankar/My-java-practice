package graph;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/*
 * It is used to find minimum spanning tree in a graph
 */
public class KruskalsAlgorithm{
	
	static class Edge implements Comparable<Edge>{
		int src, dest, wt;
		
		public Edge(int src, int dest, int wt) {
			this.src = src;
			this.dest = dest;
			this.wt = wt;
		}
		
		@Override
		public int compareTo(Edge that) {
			return this.wt - that.wt;
		}
	}
	
	static int miSpanningTree(int v, ArrayList<ArrayList<ArrayList<Integer>>> adj) {
		ArrayList<Edge> edges = new ArrayList<>();
		boolean[][] added = new boolean[v][v];
		
		for(int i=0; i<v; i++) {
			for(int j=0; j<adj.get(i).size(); j++) {
				ArrayList<Integer> cur = adj.get(i).get(j);
				if(!added[i][cur.get(0)]) {
					added[i][cur.get(0)] = true;
					added[cur.get(0)][i] = true;
					edges.add(new Edge(i, cur.get(0), cur.get(1)));
				}
			}
		}
		
		Collections.sort(edges);
		int count = 1;
		int ans = 0;
		
		MakeFriendAreFriend makeFriendAreFriend = new MakeFriendAreFriend(v);
		
		for(int i=0; count<v; i++) {
			Edge edge = edges.get(i);
			int rs = makeFriendAreFriend.find(edge.src);
			int rd = makeFriendAreFriend.find(edge.dest);
			if(rs != rd) {
				makeFriendAreFriend.union(rs, rd);
				count++;
				ans += edge.wt;
			}
		}
		
		return ans;
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
		
		int length = miSpanningTree(graph.vertices, graph.list);
		System.out.println("Length of minimum spanning tree: " + length);
	}
}
