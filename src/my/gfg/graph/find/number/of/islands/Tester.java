package my.gfg.graph.find.number.of.islands;

public class Tester {

	public static void main(String[] args) {
		int array[][] = new int[][] { 
			{ 1, 1, 1, 1, 0, 0, 1 }, 
			{ 1, 0, 1, 0, 1, 1, 0 }, 
			{ 0, 0, 0, 0, 1, 0, 1 },
			{ 1, 0, 0, 0, 1, 1, 1 } };
		Islands I = new Islands();
		System.out.println("Number of islands is: " + I.countIslands(array, 4, 7));
	}

}
