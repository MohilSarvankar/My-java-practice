package graph;

public class GraphUsingAdjacencyMatrix {
	
	int[][] a;
	int vertices;
	
	public GraphUsingAdjacencyMatrix(int v){
		vertices = v;
		a = new int[v][v];
	}
	
	public void addEdge(int src, int dest) {
		a[src][dest] = 1;
		a[dest][src] = 1;
	}
	
	public void printGraph() {
		for(int i=0; i<vertices; i++) {
			for(int j=0; j<vertices; j++) {
				System.out.print(a[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		
		GraphUsingAdjacencyMatrix graph = new GraphUsingAdjacencyMatrix(5);
		
		graph.addEdge(0, 1);
		graph.addEdge(0, 3);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        
        System.out.println("Adjacency Matrix Representation of the Graph:");
        graph.printGraph();
	}
}
