package my.gfg.tree.bst.crud;

public class Tester {

	public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree();
		bst.insert(5);
		bst.insert(2);
		bst.insert(7);
		bst.insert(4);
		bst.insert(3);
		bst.insert(1);
		bst.insert(6);

		bst.inorder(bst.root);
		bst.delete(bst.root, 5);
		System.out.println();
		bst.inorder(bst.root);
	}

}
