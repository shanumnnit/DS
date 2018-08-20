package my.gfg.graph.find.number.of.islands;

import java.util.Arrays;

public class Islands {

	public static int countIslands(int[][] array, int n, int m) {
		int numOfIslands = 0;
		boolean[][] visited = new boolean[n][m];
		for (int i = 0; i < n; i++)
			Arrays.fill(visited[i], false);

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (array[i][j] == 1 && !visited[i][j]) {
					numOfIslands++;
					visited[i][j] = true;
					DFS(array, n, m, visited, i, j);
				}
			}
		}

		return numOfIslands;
	}

	private static void DFS(int[][] array, int n, int m, boolean[][] visited, int i, int j) {
		int[] rowArr = { -1, -1, -1, 0, 0, 1, 1, 1 };
		int[] colArr = { -1, 0, 1, -1, 1, -1, 0, 1 };

		visited[i][j] = true;
		for (int k = 0; k < rowArr.length; k++) {
			if (isSafe(n, m, i + rowArr[k], j + colArr[k]) && array[i + rowArr[k]][j + colArr[k]] == 1
					&& !visited[i + rowArr[k]][j + colArr[k]]) {
				// visited[i + rowArr[k]][j + colArr[k]] = true;
				DFS(array, n, m, visited, i + rowArr[k], j + colArr[k]);
			}

		}
	}

	private static boolean isSafe(int n, int m, int i, int j) {
		if (i < n && j < m && i > -1 && j > -1)
			return true;
		return false;
	}

}
