package my.gfg.circular.linkedList.sorted.insert;

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

	public void splitIntoHalf() {
		Node slow = last.next, fast = last.next;
		while (fast.next != last && fast.next.next != last) {
			slow = slow.next;
			fast = fast.next.next;
		}

		Node head2 = slow.next;
		slow.next = last.next;
		last.next = head2;
		last1 = slow;
		last2 = last;
	}

	public void printList1() {
		if (last1 == null)
			return;
		Node temp = last1.next;
		do {
			System.out.print(temp.data + " ");
			temp = temp.next;
		} while (temp != last1.next);
		System.out.println();
	}

	public void printList2() {
		if (last2 == null)
			return;
		Node temp = last2.next;
		do {
			System.out.print(temp.data + " ");
			temp = temp.next;
		} while (temp != last2.next);
		System.out.println();
	}

}
