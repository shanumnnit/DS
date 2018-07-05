package my.gfg.linkedList.sum;

import javax.swing.text.AbstractDocument.LeafElement;

class Node {
	int data;
	Node next;

	public Node(int data) {
		this.data = data;
	}

}

public class LinkedList {
	Node head;

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

	public static LinkedList sum(LinkedList myList1, LinkedList myList2) {
		LinkedList mySumList = new LinkedList();
		int length1 = myList1.getLength();
		int length2 = myList2.getLength();
		if (length2 > length1) {
			LinkedList temp = myList1;
			myList1 = myList2;
			myList2 = temp;
			int temp2 = length1;
			length1 = length2;
			length2 = temp2;
		}

		Node temp1 = myList1.head;
		Node temp2 = myList2.head;

		int curSum = 0, actualSum = 0, carry = 0;
		for (int i = 0; i < length1; i++) {
			if (temp2 != null)
				curSum = temp1.data + temp2.data + carry;
			else
				curSum = temp1.data + carry;

			actualSum = curSum % 10;
			if (curSum > 9)
				carry = 1;
			else
				carry = 0;
			mySumList.insertAtEnd(actualSum);
			temp1 = temp1.next;
			if (temp2 != null)
				temp2 = temp2.next;
		}
		if(carry>0) {
			mySumList.insertAtEnd(1);
		}
		return mySumList;
	}
}
