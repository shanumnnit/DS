package my.gfg.string.remove.adjacent.duplicate;

import java.util.Arrays;
import java.util.Scanner;

public class AdjacentDuplicateRemover {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		int t = Integer.parseInt(scn.nextLine());

		while (t-- > 0) {
			String str = scn.nextLine();
			StringBuilder output = new StringBuilder("");

			boolean toSkip[] = new boolean[str.length()];
			Arrays.fill(toSkip, false);

			if (str.charAt(0) == str.charAt(1))
				toSkip[0] = true;
			if (str.length() > 1 && str.charAt(str.length() - 1) == str.charAt(str.length() - 2))
				toSkip[str.length() - 1] = true;

			for (int i = 1; i < str.length() - 1; i++) {
				if (str.charAt(i) == str.charAt(i - 1) || str.charAt(i) == str.charAt(i + 1))
					toSkip[i] = true;
			}

			for (int i = 0; i < toSkip.length; i++) {
				if (!toSkip[i])
					output.append(str.charAt(i));
			}
			System.out.println(output);
		}
	}

}
