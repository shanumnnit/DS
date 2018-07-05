package my.gfg.queue.print.k.max;

import java.util.Deque;
import java.util.LinkedList;

public class Tester {
	public static void main(String[] args) {
		int arr[] = { 12, 1, 78, 90, 57, 89, 56 };
		int k = 3;
		printMax(arr, k);
	}

	private static void printMax(int[] arr, int k) {
		Deque<Integer> deque = new LinkedList<>();
		for (int i = 0; i < k; i++) {
			while (!deque.isEmpty() && arr[deque.peekLast()] <= arr[i])
				deque.removeLast();
			deque.addLast(i);
		}

		for (int i = k; i < arr.length; i++) {
			System.out.print(arr[deque.peek()] + " ");
			while (!deque.isEmpty() && deque.peek() <= i - k)
				deque.removeFirst();
			while (!deque.isEmpty() && arr[deque.peekLast()] <= arr[i])
				deque.removeLast();
			deque.addLast(i);
		}
		System.out.print(arr[deque.peek()] + " ");
	}
}
