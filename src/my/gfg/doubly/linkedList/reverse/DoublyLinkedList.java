package my.gfg.doubly.linkedList.reverse;

class Node {
	int data;
	Node prev;
	Node next;

	public Node(int data) {
		super();
		this.data = data;
	}

}

class DoublyLinkedList {
	Node head;

	public void insertAtEnd(int data) {
		Node newNode = new Node(data);
		if (head == null) {
			head = newNode;
			return;
		}
		Node temp = head;
		while (temp.next != null) {
			temp = temp.next;
		}
		newNode.prev = temp;
		temp.next = newNode;
	}

	public void reverse() {
		if (head == null || head.next == null)
			return;
		Node temp = head;
		Node saveTemp = temp;
		while (temp != null) {
			Node temp2 = temp.prev;
			temp.prev = temp.next;
			temp.next = temp2;
			saveTemp = temp;
			temp = temp.prev;
		}
		head = saveTemp;
	}

	public void printList() {
		if (head == null)
			return;
		Node temp = head;
		System.out.print("Forward : ");
		Node cur = temp;
		while (temp != null) {
			System.out.print(temp.data + " ");
			cur = temp;
			temp = temp.next;
		}
		System.out.println();
		// System.out.print("Backward : ");
		// while (cur != null) {
		// System.out.print(cur.data + " ");
		// cur = cur.prev;
		// }
		// System.out.println();

	}

	public int getLength() {
		int length = 0;
		Node temp = head;
		while (temp != null) {
			length++;
			temp = temp.next;
		}
		return length;
	}

	public void quickSort() {
		if (head == null || head.next == null)
			return;
		Node tail = head;
		while (tail.next != null)
			tail = tail.next;
		quickSortHelper(head, tail);
	}

	private void quickSortHelper(Node l, Node h) {
		if (h != null && l != null && l != h && l != h.next) {
			Node partitionNode = quickSortPartition(l, h);
			printList();
			quickSortHelper(l, partitionNode.prev);
			quickSortHelper(partitionNode.next, h);
		}
	}

	private Node quickSortPartition(Node l, Node h) {
		Node pivot = h;
		Node i = l, j = h.prev;
		while (j != null && i.prev != j && i != j) {
			while (i != null && i.data <= pivot.data && i.prev != j && i != j)
				i = i.next;
			while (j != null && j.data >= pivot.data && i.prev != j && i != j)
				j = j.prev;
			swap(i, j);

		}
		swap(i, pivot);
		return i;
	}

	private void swap(Node i, Node j) {
		if (i == j || i == null || j == null)
			return;
		int temp = i.data;
		i.data = j.data;
		j.data = temp;
	}

}
