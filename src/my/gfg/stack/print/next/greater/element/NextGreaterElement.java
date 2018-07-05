package my.gfg.stack.print.next.greater.element;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class NextGreaterElement {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int t = scn.nextInt();
		while (t-- > 0) {
			int n = scn.nextInt();
			int arr[] = new int[n];
			for (int i = 0; i < n; i++)
				arr[i] = scn.nextInt();

			int result[] = new int[n];
			Arrays.fill(result, -1);
			Stack<Integer> stack = new Stack<>();
			stack.push(arr[n - 1]);

			for (int i = n - 2; i >= 0; i--) {
				if (!stack.isEmpty() && arr[i] < stack.peek()) {
					result[i] = stack.peek();
					stack.push(arr[i]);
				} else {
					// result[i] = -1;
					while (!stack.isEmpty() && stack.peek() < arr[i])
						stack.pop();
					if (stack.isEmpty())
						result[i] = -1;
					else
						result[i] = stack.peek();
					stack.push(arr[i]);
				}
			}
			Arrays.stream(result).forEach((e) -> System.out.print(e + " "));
			System.out.println();
		}
	}

}
