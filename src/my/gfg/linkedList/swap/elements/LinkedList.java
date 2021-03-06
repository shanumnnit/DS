package my.gfg.linkedList.swap.elements;

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

	public void insertAt(int offset, int data) {
		Node newNode = new Node(data);
		if (head == null) {
			head = newNode;
			return;
		}
		int length = getLength();
		if (offset > length) {
			offset = length + 1;
		} else if (offset < 0) {
			newNode.next = head;
			head = newNode;
			return;
		}
		Node prev = head;
		Node next = head.next;
		for (int i = 0; i < offset - 2; i++) {
			if (next == null)
				break;
			prev = next;
			next = next.next;
		}
		prev.next = newNode;
		newNode.next = next;

	}

	public void deleteAt(int indexToBeRemoved) {
		if (head == null) {
			return;
		}

		int length = getLength();
		if (indexToBeRemoved <= 0) {
			Node temp = head.next;
			head = null;
			head = temp;
			return;
		} else if (indexToBeRemoved > length) {
			indexToBeRemoved = length;
		}
		Node prev = head;
		Node tobedel = head.next;
		for (int i = 0; i < indexToBeRemoved - 2; i++) {
			if (tobedel == null)
				break;
			prev = tobedel;
			tobedel = tobedel.next;
		}
		if (tobedel == null) {
			prev.next = null;
			return;
		}
		prev.next = tobedel.next;
		tobedel = null;
	}

	public void swap(int firstIndex, int secondIndex) {
		int length = getLength();
		if (firstIndex == secondIndex)
			return;
		else if (firstIndex > secondIndex) {
			int temp = firstIndex;
			firstIndex = secondIndex;
			secondIndex = temp;
		}
		if (secondIndex > length)
			secondIndex = length;
		if (firstIndex < 0)
			firstIndex = 0;

		if (head == null || head.next == null)
			return;
		Node p1 = null, p3 = head;
		Node p2 = head, p4 = head;
		for (int i = 0; i < firstIndex - 2 && p1 != null; i++) {
			p1 = p1.next;
		}
		for (int i = 0; i < secondIndex - 2 && p3 != null; i++) {
			p3 = p3.next;
		}
		if (p1 != null)
			p2 = p1.next;
		if (p3 != null)
			p4 = p3.next;

		if (p1 != null && p1 != p4)
			p1.next = p4;
		if (p3 != null && p3 != p2)
			p3.next = p2;

		Node temp = p2.next;
		p2.next = p4.next;
		p4.next = temp;

		if (p1 == null) {
			head = p4;
		}

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
}
