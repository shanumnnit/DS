package my.gfg.graph.directed.detect.cycle.using.white.grey.black.sets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
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

	public void print() {
		for (int i = 0; i < V; i++) {
			System.out.print(i + " -> ");
			for (Integer to : adjList[i])
				System.out.print(" " + to);
			System.out.println();
		}
	}

	public void isCyclic() {
		HashSet<Integer> whiteSet = new HashSet<>();
		HashSet<Integer> greySet = new HashSet<>();
		HashSet<Integer> blackSet = new HashSet<>();

		for (int i = 0; i < V; i++)
			whiteSet.add(i);

		Iterator<Integer> itr = whiteSet.iterator();

		while (whiteSet.size() > 0) {
			Integer src = itr.next();
			if (isCyclicUtilDFS(src, whiteSet, greySet, blackSet)) {
				System.out.println("Cyclic");
				return;
			}
		}

		System.out.println("Not cyclic");
	}

	private boolean isCyclicUtilDFS(Integer src, HashSet<Integer> whiteSet, HashSet<Integer> greySet,
			HashSet<Integer> blackSet) {
		move(src, whiteSet, greySet);
		for (Integer neighbour : adjList[src]) {
			if (blackSet.contains(neighbour))
				continue;
			else if (greySet.contains(neighbour))
				return true;
			else if (isCyclicUtilDFS(neighbour, whiteSet, greySet, blackSet))
				return true;
		}
		move(src, greySet, blackSet);
		return false;
	}

	private void move(Integer element, HashSet<Integer> fromSet, HashSet<Integer> toSet) {
		if (!fromSet.remove(element))
			throw new IllegalStateException();
		toSet.add(element);
	}

}
