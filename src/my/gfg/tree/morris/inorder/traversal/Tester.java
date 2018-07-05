package my.gfg.tree.morris.inorder.traversal;

public class Tester {

	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);

		tree.inorderMorrisTraversal();
		
		System.out.println();
		System.out.print("Inorder recursive: ");
		tree.inorderRecursive(tree.root);
	}

}
