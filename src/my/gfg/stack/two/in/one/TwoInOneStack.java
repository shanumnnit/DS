package my.gfg.stack.two.in.one;

public class TwoInOneStack {
	int a[];
	int top1;
	int top2;

	public TwoInOneStack(int size) {
		super();
		this.a = new int[size];
		this.top1 = -1;
		this.top2 = size;
	}

	public void push1(int data) {
		if (top1 >= top2 - 1) {
			System.out.println("Stack 1 overflow");
			return;
		}
		a[++top1] = data;
	}

	public void push2(int data) {
		if (top1 >= top2 - 1) {
			System.out.println("Stack 2 overflow");
			return;
		}
		a[--top2] = data;
	}

	public int pop1() {
		if (top1 <= -1) {
			System.out.println("Stack 1 underflow");
			return -999999;
		}
		return a[top1--];

	}

	public int pop2() {
		if (top2 >= a.length) {
			System.out.println("Stack 2 underflow");
			return -999999;
		}
		return a[top2++];

	}

	public int peek1() {
		return a[top1];
	}

	public int peek2() {
		return a[top2];
	}

}
