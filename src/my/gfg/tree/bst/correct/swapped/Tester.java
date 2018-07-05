package my.gfg.tree.bst.correct.swapped;

public class Tester {

	public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree();
		Node root = new Node(6);
		root.left = new Node(10);
		root.right = new Node(2);
		root.left.left = new Node(1);
		root.left.right = new Node(3);
		root.right.right = new Node(12);
		root.right.left = new Node(7);
		bst.root = root;

		bst.inorder(bst.root);

		bst.correctBST();
		
		System.out.println();

		bst.inorder(bst.root);

	}

}
