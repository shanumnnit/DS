package my.gfg.string.check.rotated;

import java.util.Scanner;

public class CheckIfStringRotated {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int t = Integer.parseInt(scn.nextLine());

		while (t-- > 0) {
			String str1 = scn.nextLine();
			String str2 = scn.nextLine();
			StringBuilder sb = new StringBuilder(str1);
			sb.append(str1);
			if (sb.indexOf(str2) != -1)
				System.out.println(1);
			else
				System.out.println(0);

		}
	}

}
