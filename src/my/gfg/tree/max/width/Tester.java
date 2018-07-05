package my.gfg.tree.max.width;

public class Tester {

	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		tree.root.right.left = new Node(6);

		System.out.println("The diameter of given binary tree is : " + tree.getMaxWidth());
	}

}
