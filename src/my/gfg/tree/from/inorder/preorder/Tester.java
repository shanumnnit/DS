package my.gfg.tree.from.inorder.preorder;

public class Tester {

	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		char in[] = new char[] { 'D', 'B', 'E', 'A', 'F', 'C' };
		char pre[] = new char[] { 'A', 'B', 'D', 'E', 'C', 'F' };
		int len = in.length;

		Node root = tree.buildTree(in, pre, 0, 0, len - 1);

		// building the tree by printing inorder traversal
		System.out.print("Inorder traversal of constructed tree is : ");
		tree.inorderRecursive(root);
	}

}
