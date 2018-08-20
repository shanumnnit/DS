package com.ctci.recursion.string.permutations;

public class StringPermutations {

	public static void main(String[] args) {
		String str = "abca";
		StringBuilder sb = new StringBuilder(str);

		printPermutations(sb, 0, sb.length() - 1);
	}

	static void printPermutations(StringBuilder sb, int start, int end) {
		if (start == end) {
			System.out.println(sb);
			return;
		}
		for (int i = start; i <= end; i++) {
			if (i != start && sb.charAt(i) == sb.charAt(start))
				continue;
			swap(sb, start, i);
			printPermutations(sb, start + 1, end);
			swap(sb, start, i);
		}
	}

	private static void swap(StringBuilder sb, int start, int i) {
		if (start == i)
			return;
		char temp = sb.charAt(start);
		sb.setCharAt(start, sb.charAt(i));
		sb.setCharAt(i, temp);
	}

}
