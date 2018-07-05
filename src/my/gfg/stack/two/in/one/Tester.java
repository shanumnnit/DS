package my.gfg.stack.two.in.one;

public class Tester {

	public static void main(String[] args) {
		TwoInOneStack stack=new TwoInOneStack(4);
		stack.push1(1);
		stack.push2(2);
		stack.push2(3);
		stack.push1(4);
		stack.push1(5);

		System.out.println(stack.pop1());
		System.out.println(stack.pop1());
		System.out.println(stack.pop1());
		System.out.println(stack.pop2());
		System.out.println(stack.pop2());
		
	}

}
