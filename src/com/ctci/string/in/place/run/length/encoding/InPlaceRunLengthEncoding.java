package com.ctci.string.in.place.run.length.encoding;

public class InPlaceRunLengthEncoding {

	public static void main(String[] args) {
		String str = "aaaaaaaaaaaabbeccccd";
		System.out.println(inplaceRLE(str));
	}

	private static String inplaceRLE(String str) {
		StringBuilder sb = new StringBuilder(str);
		int i = 0, j = 0, count = 0;
		Character prev = sb.charAt(0), cur = sb.charAt(0);

		while (j < sb.length()) {
			cur = sb.charAt(j);
			if (cur.equals(prev)) {
				j++;
				count++;
				continue;
			}
			sb.setCharAt(i++, prev);
			for (char c : String.valueOf(count).toCharArray())
				sb.setCharAt(i++, c);
			count = 0;
			prev = cur;
		}

		sb.setCharAt(i++, prev);
		for (char c : String.valueOf(count).toCharArray())
			sb.setCharAt(i++, c);

		return sb.substring(0, i);
	}

}
