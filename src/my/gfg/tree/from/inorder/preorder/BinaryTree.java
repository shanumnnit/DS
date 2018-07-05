package my.gfg.tree.from.inorder.preorder;

class Node {
	char data;
	Node left, right;

	public Node(char data) {
		super();
		this.data = data;
		this.left = this.right = null;
	}

}

class BinaryTree {
	Node root;

	public void inorderRecursive(Node node) {
		if (node != null) {
			inorderRecursive(node.left);
			System.out.print(node.data + " ");
			inorderRecursive(node.right);
		}
	}

	public Node buildTree(char[] in, char[] pre, int preIndex, int inStart, int inEnd) {
		if (preIndex >= pre.length || inStart > inEnd)
			return null;
		char currentRoot = pre[preIndex];

		Node currentRootNode = new Node(currentRoot);
		if (inStart == inEnd)
			return currentRootNode;
		int inorderIndex = find(currentRoot, in, inStart, inEnd);

		currentRootNode.left = buildTree(in, pre, preIndex + 1, inStart, inorderIndex - 1);
		currentRootNode.right = buildTree(in, pre, preIndex + 1, inorderIndex + 1, inEnd);

		return currentRootNode;
	}

	private int find(char currentRoot, char[] in, int inStart, int inEnd) {
		for (int i = inStart; i <= inEnd; i++) {
			if (in[i] == currentRoot)
				return i;
		}
		return -1;
	}

}
