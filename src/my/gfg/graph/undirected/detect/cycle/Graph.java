package my.gfg.graph.undirected.detect.cycle;

import java.util.Iterator;
import java.util.LinkedList;

public class Graph {
	int V;
	LinkedList<Integer> adjList[];

	public Graph(int noOfVertices) {
		this.V = noOfVertices;
		adjList = new LinkedList[V];
		for (int i = 0; i < V; i++)
			adjList[i] = new LinkedList<>();
	}

	public void addEdge(int src, int dest) {
		adjList[src].addLast(dest);
		adjList[dest].addLast(src);
	}

	public void removeEdge(int src, int dest) {
		LinkedList<Integer> list = adjList[src];
		if (list.isEmpty())
			return;
		Iterator<Integer> itr = list.iterator();
		while (itr.hasNext()) {
			Integer destn = itr.next();
			if (destn == dest) {
				itr.remove();
				break;
			}
		}
	}

	public void print() {
		for (int i = 0; i < V; i++) {
			System.out.print(i + " -> ");
			for (Integer to : adjList[i])
				System.out.print(" " + to);
			System.out.println();
		}
	}

	public void isCyclicUsingDFS() {
		boolean visited[] = new boolean[V];
		boolean isCyclic = false;
		for (int i = 0; i < V; i++) {
			if (!visited[i])
				isCyclic = isCyclicUsingDFSUtil(i, visited, -1);
		}
		if (isCyclic)
			System.out.println("Cyclic");
		else
			System.out.println("Acyclic");
	}

	private boolean isCyclicUsingDFSUtil(int i, boolean[] visited, int parent) {
		visited[i] = true;
		for (Integer adj : adjList[i]) {
			if (adj == parent)
				continue;
			if (visited[adj])
				return true;
			if (!visited[adj] && isCyclicUsingDFSUtil(adj, visited, i))
				return true;
		}
		return false;
	}
}
