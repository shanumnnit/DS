package my.gfg.heap.sort;

public class Tester {

	public static void main(String[] args) {
		// int[] arr = { 5, 2, 9, 10, 1, 4, 12 };
		int[] arr = { 12, 11, 13, 5, 6, 7 };

		heapsort(arr);

		for (int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + " ");
	}

	private static void heapsort(int[] arr) {
		int n = arr.length;
		if (n <= 1)
			return;
		for (int i = n - 1; i >= 0; i--)
			maxHeapify(arr, i, arr.length - 1);

		for (int i = arr.length - 1; i > 0; i--) {
			int temp = arr[0];
			arr[0] = arr[i];
			arr[i] = temp;

			maxHeapify(arr, 0, i - 1);
		}

	}

	private static void maxHeapify(int[] arr, int i, int length) {
		int l = 2 * i + 1;
		if (l > length)
			return;
		int r = 2 * i + 2;
		int biggerChild = i;
		if (arr[i] < arr[l])
			biggerChild = l;
		if (r <= length && arr[biggerChild] < arr[r])
			biggerChild = r;

		if (i != biggerChild) {
			// swap the i and bigger child
			int temp = arr[i];
			arr[i] = arr[biggerChild];
			arr[biggerChild] = temp;

			maxHeapify(arr, biggerChild, length);
		}
	}

}
