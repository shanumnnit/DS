package my.gfg.arrays.print.subsets;

public class ArraysPrintSubsets {

	public static void main(String[] args) {
		int arr[] = { 1, 2, 3 };

		for (int i = 0; i < (1 << arr.length); i++) {
			System.out.print(" [ ");
			for (int j = 0; j < arr.length; j++) {
				if ((i & (1 << j)) != 0)
					System.out.print(arr[j] + " ");
			}
			System.out.println(" ] ");
		}

	}

}
