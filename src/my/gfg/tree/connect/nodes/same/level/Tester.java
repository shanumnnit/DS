package my.gfg.tree.connect.nodes.same.level;

public class Tester {

	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		tree.root.right.left = new Node(6);

		tree.connect(tree.root);

		tree.printNextRight(tree.root.left.left);
	}

}
