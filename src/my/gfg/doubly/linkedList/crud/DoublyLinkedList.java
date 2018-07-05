package my.gfg.doubly.linkedList.crud;

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

	public void insertAtBeggining(int data) {
		Node newNode = new Node(data);
		if (head == null) {
			head = newNode;
			return;
		}
		newNode.next = head;
		head.prev = newNode;
		head = newNode;
	}

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

	public void insertAt(int data, int offset) {
		if (offset <= 0) {
			insertAtBeggining(data);
			return;
		} else if (offset >= getLength()) {
			insertAtEnd(data);
			return;
		}
		Node newNode = new Node(data);
		if (head == null) {
			head = newNode;
			return;
		}
		Node temp = head;
		for (int i = 0; i < offset - 1 && temp != null; i++) {
			temp = temp.next;
		}
		Node prev = temp.prev;
		prev.next = newNode;
		newNode.prev = prev;
		newNode.next = temp;
		temp.prev = newNode;

	}

	public void deleteAt(int offset) {
		if (head == null)
			return;
		if (offset <= 0) {
			Node temp = head;
			head = head.next;
			temp = null;
			return;
		}
		Node temp = head;
		for (int i = 0; i < offset - 1 && temp != null; i++) {
			temp = temp.next;
		}
		temp.prev.next = temp.next;
		temp.next.prev = temp.prev;
		temp = null;
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
