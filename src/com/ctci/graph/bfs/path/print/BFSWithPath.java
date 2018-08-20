package com.ctci.graph.bfs.path.print;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class Graph {
	int V;
	LinkedList<Integer> adjList[];

	public Graph(int v) {
		super();
		V = v;
		adjList = new LinkedList[V];
		for (int i = 0; i < v; i++)
			adjList[i] = new LinkedList<>();
	}

	void addEdge(Integer src, Integer dest) {
		if (src < 0 || src >= V || dest < 0 || dest >= V)
			return;
		adjList[src].add(dest);
	}

	void print() {
		for (int i = 0; i < V; i++) {
			System.out.print(i + " ->");
			for (Integer neighbour : adjList[i])
				System.out.print(" " + neighbour);
			System.out.println();
		}
	}

	public void bfsWithShortestPath(int src, int dest) {
		if (src < 0 || src >= V || dest < 0 || dest >= V || src == dest) {
			System.out.println("Path not possible");
			return;
		}
		Queue<Integer> queue = new LinkedList<>();
		int[] path = new int[V];
		Arrays.fill(path, -1);

		boolean[] visited = new boolean[V];
		Arrays.fill(visited, false);

		queue.add(src);
		visited[src] = true;

		while (!queue.isEmpty()) {
			Integer parent = queue.remove();
			for (Integer neighbour : adjList[parent]) {
				if (neighbour.equals(dest)) {
					path[neighbour] = parent;
					System.out.println("Found path : " + printPath(path, dest));
					return;
				}
				if (!visited[neighbour]) {
					path[neighbour] = parent;
					visited[neighbour] = true;
					queue.add(neighbour);
				}
			}
		}

		System.out.println("Path not possible");
	}

	public void biDirectionalBfsWithShortestPath(int src, int dest) {
		if (src < 0 || src >= V || dest < 0 || dest >= V || src == dest) {
			System.out.println("Path not possible");
			return;
		}
		Queue<Integer> queue1 = new LinkedList<>();
		int[] path1 = new int[V];
		Arrays.fill(path1, -1);
		Queue<Integer> queue2 = new LinkedList<>();
		int[] path2 = new int[V];
		Arrays.fill(path2, -1);

		boolean[] visited1 = new boolean[V];
		Arrays.fill(visited1, false);
		boolean[] visited2 = new boolean[V];
		Arrays.fill(visited2, false);

		queue1.add(src);
		queue2.add(dest);
		visited1[src] = true;
		visited2[dest] = true;

		while (!queue1.isEmpty() || !queue2.isEmpty()) {
			// BFS from source
			Integer parent1 = queue1.remove();
			for (Integer neighbour1 : adjList[parent1]) {
				if (neighbour1.equals(dest)) {
					path1[neighbour1] = parent1;
					System.out.println("Found path : " + printPath(path1, dest));
					return;
				}
				if (visited2[neighbour1]) {
					System.out.println("Found intersection at " + neighbour1 + ". Path is ");
					bfsWithShortestPath(src, neighbour1);
					bfsWithShortestPath(neighbour1, dest);
					return;
				}
				if (!visited1[neighbour1]) {
					path1[neighbour1] = parent1;
					visited1[neighbour1] = true;
					queue1.add(neighbour1);
				}
			}

			// BFS from destination
			Integer parent2 = queue2.remove();
			for (Integer neighbour2 : adjList[parent2]) {
				if (neighbour2.equals(src)) {
					path2[neighbour2] = parent2;
					System.out.println("Found path : " + printPath(path2, src));
					return;
				}
				if (visited1[neighbour2]) {
					System.out.println("Found intersection at " + neighbour2 + ". Path is ");
					bfsWithShortestPath(src, neighbour2);
					bfsWithShortestPath(neighbour2, dest);
					return;
				}
				if (!visited2[neighbour2]) {
					path2[neighbour2] = parent2;
					visited2[neighbour2] = true;
					queue2.add(neighbour2);
				}
			}
		}

		System.out.println("Path not possible");
	}

	private String printPath(int[] path, int dest) {
		Stack<Integer> stack = new Stack<>();
		while (dest != -1) {
			stack.push(dest);
			dest = path[dest];
		}
		StringBuilder sb = new StringBuilder();
		while (!stack.isEmpty()) {
			sb.append(stack.pop() + " -> ");
		}
		return sb.substring(0, sb.length() - 4);
	}

}

public class BFSWithPath {

	public static void main(String[] args) {
		Graph g = new Graph(6);
		g.addEdge(0, 2);
		g.addEdge(0, 3);
		g.addEdge(1, 0);
		g.addEdge(1, 4);
		g.addEdge(2, 1);
		g.addEdge(3, 4);
		g.addEdge(4, 2);
		g.addEdge(4, 4);
		g.addEdge(5, 4);

		g.print();

		g.biDirectionalBfsWithShortestPath(5, 0);
	}

}
