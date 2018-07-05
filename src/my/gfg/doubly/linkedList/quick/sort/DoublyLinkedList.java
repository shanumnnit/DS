package my.gfg.doubly.linkedList.quick.sort;

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
		System.out.print("Backward : ");
		while (cur != null) {
			System.out.print(cur.data + " ");
			cur = cur.prev;
		}
		System.out.println();

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

}
