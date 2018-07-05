package my.gfg.graph.directed.acyclic.topological.sort;

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

	public void print() {
		for (int i = 0; i < V; i++) {
			System.out.print(i + " -> ");
			for (Integer to : adjList[i])
				System.out.print(" " + to);
			System.out.println();
		}
	}

	public void topologicalSort() {
		boolean visited[] = new boolean[V];
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < V; i++) {
			if (!visited[i])
				topologicalSortUtil(i, visited, stack);
		}
		System.out.println("Topological sort : ");
		while (!stack.isEmpty())
			System.out.print(stack.pop() + " ");
	}

	private void topologicalSortUtil(int i, boolean[] visited, Stack<Integer> stack) {
		visited[i] = true;
		for (Integer adj : adjList[i]) {
			if (!visited[adj])
				topologicalSortUtil(adj, visited, stack);
		}
		stack.push(i);
	}
}
