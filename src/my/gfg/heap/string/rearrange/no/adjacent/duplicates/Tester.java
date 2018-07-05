package my.gfg.heap.string.rearrange.no.adjacent.duplicates;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Tester {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);

		int t = Integer.parseInt(scn.nextLine());
		while (t-- > 0) {
			String str = scn.nextLine();
			System.out.println(rearrangeStringWithNoAdjacent(str));
		}

		scn.close();
	}

	private static int rearrangeStringWithNoAdjacent(String inputStr) {
		StringBuffer resultStr = new StringBuffer();

		int[] chrArr = new int[26];
		Arrays.fill(chrArr, 0);
		for (char c : inputStr.toCharArray())
			chrArr[c - 'a']++;

		PriorityQueue<MyPair> pq = new PriorityQueue<>();

		for (int i = 0; i < 26; i++)
			pq.add(new MyPair((char) ('a' + i), chrArr[i]));

		MyPair prev = null;
		while (!pq.isEmpty()) {
			MyPair polled = pq.poll();
			if (polled.count > 0) {
				resultStr.append(polled.c);
				polled.count--;
			} else
				break;
			if (prev != null)
				pq.add(prev);
			prev = polled;
		}
		if (resultStr.length() == inputStr.length())
			return 1;
		else
			return 0;
	}

}

class MyPair implements Comparable<MyPair> {

	char c;
	int count;

	public MyPair(char c, int count) {
		super();
		this.c = c;
		this.count = count;
	}

	@Override
	public int compareTo(MyPair o) {
		return o.count - this.count;
	}

}
