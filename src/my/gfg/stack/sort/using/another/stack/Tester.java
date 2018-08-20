package my.gfg.stack.sort.using.another.stack;

import java.util.Stack;

public class Tester {

	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<>();
		stack.push(30);
		stack.push(-5);
		stack.push(18);
		stack.push(14);
		stack.push(-3);

		System.out.println(stack);

		sortStack(stack);

		while (!stack.isEmpty())
			System.out.print(stack.pop() + " ");

	}

	private static void sortStack(Stack<Integer> stack) {
		if (stack.isEmpty())
			return;

		Stack<Integer> temp = new Stack<>();
		while (!stack.isEmpty()) {
			int popped = stack.pop();
			if (temp.isEmpty() || temp.peek() <= popped)
				temp.push(popped);
			else {
				while (!temp.isEmpty() && temp.peek() > popped)
					stack.push(temp.pop());
				temp.push(popped);
			}
		}

		while (!temp.isEmpty())
			stack.push(temp.pop());

	}

}
