package my.gfg.linkedList.sorted.mergesort.grouped;

class Node {
	int data;
	Node next;

	public Node(int data) {
		super();
		this.data = data;
	}

}

public class LinkedList {
	Node head;

	public LinkedList() {
		super();
		head = null;
	}

	public void insertAtBeginning(int data) {
		Node newNode = new Node(data);
		newNode.next = head;
		head = newNode;
	}

	public void insertAtEnd(int data) {
		Node newNode = new Node(data);
		if (head == null) {
			head = newNode;
			return;
		}
		Node prevNode = head;
		while (prevNode.next != null) {
			prevNode = prevNode.next;
		}
		prevNode.next = newNode;
	}

	public void printList() {
		Node temp = head;
		System.out.println();
		System.out.print("The List is : ");
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
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

	public Node groupedReverse(Node head2, int groupSize) {
		if (head2 == null || head2.next == null) {
			return head2;
		}
		Node p = null, q = head2, r = head2.next;
		for (int i = 0; q != null && i < groupSize; i++) {
			q.next = p;
			p = q;
			q = r;
			if (r != null)
				r = r.next;
		}
		head2.next = groupedReverse(q, groupSize);
		return p;
	}
}
