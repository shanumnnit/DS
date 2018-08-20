package my.gfg.graph.directed.acyclic.topological.sort.again;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

import javax.xml.ws.soap.AddressingFeature;

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
		Arrays.fill(visited, false);

		for (int i = 0; i < V; i++)
			if (!visited[i])
				topologicalSortUtil(i, visited, stack);

		System.out.print("Topological sort is :");
		while (!stack.isEmpty())
			System.out.print(" " + stack.pop());
	}

	private void topologicalSortUtil(int src, boolean[] visited, Stack<Integer> stack) {
		visited[src] = true;
		for (Integer neighbour : adjList[src]) {
			if (!visited[neighbour])
				topologicalSortUtil(neighbour, visited, stack);
		}
		stack.push(src);
	}

}
