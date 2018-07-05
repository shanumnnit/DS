package my.gfg.linkedList.sorted.mergesort;

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

	public void sort() {
		if (head == null || head.next == null)
			return;
		Node tail = head;
		while (tail.next != null)
			tail = tail.next;
		head = mergeSort(head);

	}

	private Node mergeSort(Node start) {
		if (start == null || start.next == null) {
			return start;
		}

		Node mid = start, fast = start;
		while (fast.next != null && fast.next.next != null) {
			mid = mid.next;
			fast = fast.next.next;
		}

		Node start2 = mid.next;
		mid.next = null;

		start = mergeSort(start);
		start2 = mergeSort(start2);

		Node mergedHead = mergeSortHelper(start, start2);
		return mergedHead;

	}

	private Node mergeSortHelper(Node start1, Node start2) {
		if (start1 == null)
			return start2;
		if (start2 == null)
			return start1;
		Node mergedHead = null;
		if (start1.data < start2.data) {
			mergedHead = start1;
			mergedHead.next = mergeSortHelper(start1.next, start2);
		} else {
			mergedHead = start2;
			mergedHead.next = mergeSortHelper(start1, start2.next);
		}
		return mergedHead;
	}
}
