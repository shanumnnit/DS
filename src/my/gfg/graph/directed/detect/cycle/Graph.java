package my.gfg.graph.directed.detect.cycle;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

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

	public void isCyclic() {
		boolean[] visited = new boolean[V];
		boolean[] recStack = new boolean[V];
		for (int i = 0; i < V; i++)
			if (isCyclicUtil(i, visited, recStack)) {
				System.out.println("Cyclic");
				return;
			}
		System.out.println("ACyclic");
	}

	private boolean isCyclicUtil(int i, boolean[] visited, boolean[] recStack) {
		if (!visited[i]) {
			visited[i] = true;
			recStack[i] = true;
			for (Integer adj : adjList[i]) {
				if (!visited[adj] && isCyclicUtil(adj, visited, recStack))
					return true;
				else if (recStack[adj])
					return true;
			}
		}
		recStack[i] = false;
		return false;
	}

}
