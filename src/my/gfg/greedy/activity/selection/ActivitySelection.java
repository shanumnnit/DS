package my.gfg.greedy.activity.selection;

import java.util.Arrays;
import java.util.Scanner;

public class ActivitySelection {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int t = Integer.parseInt(scn.nextLine());
		while (t-- > 0) {
			int n = Integer.parseInt(scn.nextLine());
			// int[] start = new int[n];
			// int[] finish = new int[n];
			Activity[] activities = new Activity[n];
			for (int i = 0; i < n; i++) {
				Activity act = new Activity();
				act.start = scn.nextInt();
				activities[i] = act;
			}
			scn.nextLine();
			for (int i = 0; i < n; i++) {
				activities[i].finish = scn.nextInt();
			}
			scn.nextLine();

			Arrays.sort(activities, (x, y) -> x.getFinish() - y.getFinish());
			System.out.println(maxActivitySelection(activities, n));
		}
	}

	private static int maxActivitySelection(Activity[] activities, int n) {
		int maxActivities = 1;
		for (int i = 1; i < n; i++) {
			while (i < n && activities[i].start < activities[i - 1].finish)
				i++;
			maxActivities++;
		}
		return maxActivities;
	}

}

class Activity {
	int start;
	int finish;

	public int getFinish() {
		return finish;
	}

}