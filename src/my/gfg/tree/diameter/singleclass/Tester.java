package my.gfg.tree.diameter.singleclass;

public class Tester {

	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);

		System.out.println("The diameter of given binary tree is : " + tree.getDiameter(tree.root));
		System.out.println("The diameter of given binary tree is : " + tree.getDiameteroptimized(tree.root, new Height()));
	}

}