package my.gfg.graph.crud.bfs;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

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

	public void bfsTraversal(int s) {
		boolean[] visted = new boolean[V];
		Queue<Integer> queue = new LinkedList<>();
		visted[s] = true;
		queue.add(s);
		while (!queue.isEmpty()) {
			int node = queue.poll();
			System.out.print(" " + node);
			for (Integer i : adjList[node])
				if (!visted[i]) {
					visted[i] = true;
					queue.add(i);
				}
		}

	}
}
