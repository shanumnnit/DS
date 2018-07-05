package my.gfg.circular.linkedList.split.half;

class Node {
	int data;
	Node next;

	public Node(int data) {
		super();
		this.data = data;
	}

}

class CircularLinkedList {
	Node last, last1, last2;

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

	public void sortedInsert(int data) {
		Node newNode = new Node(data);
		if (last == null) {
			newNode.next = newNode;
			last = newNode;
			return;
		}
		Node temp = last.next;
		if (temp == last) {
			last.next = newNode;
			newNode.next = last;
			if (last.data < newNode.data) {
				last = newNode;
			}
			return;
		}
		while (temp != last && temp.next.data < data) {
			temp = temp.next;
		}
		if (temp == last || temp == last.next) {
			Node head = last.next;
			last.next = newNode;
			newNode.next = head;
			if (temp == last)
				last = last.next;
			return;
		}
		Node saveNext = temp.next.next;
		if (saveNext == temp)
			saveNext = last;
		temp.next = newNode;
		newNode.next = saveNext;

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
