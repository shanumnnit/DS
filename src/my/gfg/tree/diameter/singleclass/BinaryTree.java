package my.gfg.tree.diameter.singleclass;

class Height {
	int h;
}

class Node {
	int data;
	Node left, right;

	public Node(int data) {
		super();
		this.data = data;
		this.left = this.right = null;
	}

}

public class BinaryTree {
	Node root;

	public int height(Node node) {
		if (node == null)
			return 0;
		return Math.max(height(node.left), height(node.right)) + 1;
	}

	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.right = new Node(4);

		System.out.println("The height of given binary tree is : " + tree.height(tree.root));
	}

}