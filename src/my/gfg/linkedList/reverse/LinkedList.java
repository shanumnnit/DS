package my.gfg.linkedList.reverse;

class Node {
	int data;
	Node next;

	public Node(int data) {
		this.data = data;
	}

}

public class LinkedList {
	Node head;

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

	public void reverse() {
		if (head == null || head.next == null)
			return;

		Node p1 = null;
		Node p2 = head;
		Node p3;

		while (p2 != null) {
			p3 = p2.next;

			p2.next = p1;

			p1 = p2;
			p2 = p3;
			if (p3 != null)
				p3 = p3.next;
		}

		head = p1;
	}
}
