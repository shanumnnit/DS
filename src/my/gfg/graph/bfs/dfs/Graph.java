package my.gfg.graph.bfs.dfs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Graph {
	int V;
	LinkedList<Integer> adj[];

	public Graph(int nodes) {
		this.V = nodes;
		adj = new LinkedList[V];
		for (int i = 0; i < V; i++)
			adj[i] = new LinkedList<>();
	}

	public void addEdge(int u, int v) {
		adj[u].add(v);
	}

	public void print() {
		for (int i = 0; i < V; i++)
			System.out.println(i + " -> " + adj[i]);
	}

	public void bfsTraversal(int src) {
		Queue<Integer> queue = new LinkedList<>();
		boolean[] visisted = new boolean[V];
		Arrays.fill(visisted, false);

		queue.add(src);
		visisted[src] = true;

		while (!queue.isEmpty()) {
			Integer node = queue.poll();
			System.out.print(node + " ");

			for (Integer neighbour : adj[node]) {
				if (!visisted[neighbour]) {
					visisted[neighbour] = true;
					queue.add(neighbour);
				}
			}

		}
	}

	public void dfsTraversal(int src) {
		Stack<Integer> stack = new Stack<>();
		boolean[] visisted = new boolean[V];
		Arrays.fill(visisted, false);

		stack.push(src);
		visisted[src] = true;

		while (!stack.isEmpty()) {
			Integer popped = stack.pop();
			System.out.print(popped + " ");
			for (Integer neighbour : adj[popped]) {
				if (!visisted[neighbour]) {
					visisted[neighbour] = true;
					stack.push(neighbour);
				}
			}
		}

	}

	public void dfsTraversalRecursive(int src) {
		boolean[] visisted = new boolean[V];
		Arrays.fill(visisted, false);

		for (int i = 0; i < adj.length; i++)
			if (!visisted[i])
				dfsTraversalRecursiveUtil(src, visisted);
	}

	public void dfsTraversalRecursiveUtil(int src, boolean[] visisted) {
		visisted[src] = true;
		System.out.print(src + " ");
		for (Integer neighbour : adj[src]) {
			if (!visisted[neighbour]) {
				dfsTraversalRecursiveUtil(neighbour, visisted);
			}
		}
	}

}
