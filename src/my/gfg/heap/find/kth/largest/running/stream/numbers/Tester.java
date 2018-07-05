package my.gfg.heap.find.kth.largest.running.stream.numbers;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Tester {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);

		PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();

		int n = scn.nextInt();
		while (n-- > 0) {
			int a = scn.nextInt();
			addNumber(a, maxHeap, minHeap);
			reBalanceHeaps(maxHeap, minHeap);
			System.out.println((int) getMedian(maxHeap, minHeap));
		}
	}

	private static void addNumber(int a, PriorityQueue<Integer> maxHeap, PriorityQueue<Integer> minHeap) {
		if (maxHeap.isEmpty() || a < maxHeap.peek())
			maxHeap.add(a);
		else
			minHeap.add(a);
	}

	private static void reBalanceHeaps(PriorityQueue<Integer> maxHeap, PriorityQueue<Integer> minHeap) {
		PriorityQueue<Integer> biggerHeap = maxHeap.size() > minHeap.size() ? maxHeap : minHeap;
		PriorityQueue<Integer> smallerHeap = maxHeap.size() < minHeap.size() ? maxHeap : minHeap;
		if ((biggerHeap.size() - smallerHeap.size()) >= 2) {
			smallerHeap.add(biggerHeap.poll());
		}

	}

	private static double getMedian(PriorityQueue<Integer> maxHeap, PriorityQueue<Integer> minHeap) {
		PriorityQueue<Integer> biggerHeap = maxHeap.size() > minHeap.size() ? maxHeap : minHeap;
		PriorityQueue<Integer> smallerHeap = maxHeap.size() > minHeap.size() ? minHeap : maxHeap;
		if (biggerHeap.size() == smallerHeap.size())
			return ((double) (biggerHeap.peek() + smallerHeap.peek())) / 2;
		else
			return biggerHeap.peek();
	}

}
