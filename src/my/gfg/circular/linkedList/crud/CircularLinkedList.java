package my.gfg.circular.linkedList.crud;

class Node {
	int data;
	Node next;

	public Node(int data) {
		super();
		this.data = data;
	}

}

class CircularLinkedList {
	Node last;

	public void insertAtBeggining(int data) {
		Node temp = new Node(data);
		if (last == null) {
			temp.next = temp;
			last = temp;
			return;
		}
		Node head = last.next;
		last.next = temp;
		temp.next = head;
		head = temp;
	}

	public void insertAtEnd(int data) {
		Node temp = new Node(data);
		if (last == null) {
			temp.next = temp;
			last = temp;
			return;
		}
		Node head = last.next;
		last.next = temp;
		last = last.next;
		last.next = head;
	}

	public void printList() {
		if (last == null)
			return;
		Node temp = last.next;
		do {
			System.out.print(temp.data + " ");
			temp = temp.next;
		} while (temp != last.next);
		System.out.println();
	}
}
