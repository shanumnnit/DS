package my.gfg.doubly.linkedList.merge.sort;

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

	public Node mergeSort(Node head1) {
		if (head1 == null || head1.next == null)
			return head1;
		Node head2 = splitList(head1);
		Node sortedHead1 = mergeSort(head1);
		Node sortedHead2 = mergeSort(head2);

		Node mergedHead = sortedMerge(sortedHead1, sortedHead2);
		return mergedHead;
	}

	private Node sortedMerge(Node head1, Node head2) {
		if (head1 == null) {
			return head2;
		}
		if (head2 == null) {
			return head1;
		}
		Node mergedHead = null;
		if (head1.data < head2.data) {
			mergedHead = head1;
			mergedHead.next = sortedMerge(head1.next, head2);
			mergedHead.next.prev = mergedHead;
			mergedHead.prev = null;
		} else {
			mergedHead = head2;
			mergedHead.next = sortedMerge(head1, head2.next);
			mergedHead.next.prev = mergedHead;
			mergedHead.prev = null;
		}
		return mergedHead;
	}

	private Node splitList(Node head1) {
		Node slow = head1, fast = head1;
		while (fast != null && fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		Node head2 = slow.next;
		slow.next = null;
		if (head2 != null)
			head2.prev = null;
		return head2;
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
