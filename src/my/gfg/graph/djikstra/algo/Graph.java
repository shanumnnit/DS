package my.gfg.graph.djikstra.algo;

public class Graph {

	int graph[][];
	int V;

	public Graph(int g[][], int v) {
		this.graph = g;
		this.V = v;
	}

	public void print() {
		for (int i = 0; i < V; i++) {
			for (int j = 0; j < V; j++) {
				System.out.println(graph[i][j] + " ");
			}
			System.out.println();
		}
	}

	public void dijkstra(int source) {
		boolean[] sptSet = new boolean[V];
		int[] dist = new int[V];

		for (int i = 0; i < V; i++) {
			sptSet[i] = false;
			dist[i] = Integer.MAX_VALUE;
		}

		dist[source] = 0;

		for (int i = 0; i < V; i++) {
			int u = findMin(sptSet, dist);
			sptSet[u] = true;

			for (int v = 0; v < V; v++) {
				if (!sptSet[v] && graph[u][v] != 0 && dist[u] != Integer.MAX_VALUE && dist[u] + graph[u][v] < dist[v])
					dist[v] = dist[u] + graph[u][v];
			}
		}

		printDist(dist);
	}

	void printDist(int dist[]) {
		System.out.println("Vertex   Distance from Source");
		for (int i = 0; i < V; i++)
			System.out.println(i + " \t\t " + dist[i]);
	}

	private int findMin(boolean[] sptSet, int[] dist) {
		int minIndex = -1, min = Integer.MAX_VALUE;

		for (int i = 0; i < V; i++) {
			if (!sptSet[i] && dist[i] < min) {
				min = dist[i];
				minIndex = i;
			}
		}

		return minIndex;
	}
}
