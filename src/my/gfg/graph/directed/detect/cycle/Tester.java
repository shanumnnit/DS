package my.gfg.graph.directed.detect.cycle;

public class Tester {

	public static void main(String[] args) {
		Graph g = new Graph(4);
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 2);
		g.addEdge(2, 0);
		g.addEdge(2, 3);
		g.addEdge(3, 3);

		g.removeEdge(2, 0);
		g.removeEdge(3, 3);
		g.print();
		g.isCyclic();

	}

}
