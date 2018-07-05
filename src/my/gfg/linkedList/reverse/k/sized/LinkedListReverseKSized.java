package my.gfg.linkedList.reverse.k.sized;

public class LinkedListReverseKSized {

	public static void main(String[] args) {
		LinkedList myList = new LinkedList();
		myList.insertAtBeginning(5);
		myList.insertAtBeginning(4);
		myList.insertAtBeginning(3);
		myList.insertAtBeginning(2);
		myList.insertAtBeginning(1);

		myList.print();

		myList.head = myList.reverseKSized(myList.head, 3);

		myList.print();
	}

}

class Node {
	int val;
	Node next;

	public Node(int data2) {
		this.val = data2;
		this.next = null;
	}

}

class LinkedList {
	Node head;

	public void insertAtBeginning(int data) {
		Node newNode = new Node(data);
		if (head == null) {
			head = newNode;
			return;
		}
		newNode.next = head;
		head = newNode;
	}

	public void print() {
		if (head == null) {
			System.out.println("List is empty");
			return;
		}
		Node temp = head;
		while (temp != null) {
			System.out.printf("%d ", temp.val);
			temp = temp.next;
		}
		System.out.println();
	}

	public Node reverseKSized(Node head, int k, int remNodes) {
		if (head == null || head.next == null)
			return head;
		Node p = null, q = head, r = head.next;
		for (int i = 0; i < k; i++) {
			q.next = p;
			p = q;
			q = r;
			if (r == null)
				break;
			r = r.next;
		}
		head.next = reverseKSized(q, k);
		return p;
	}

}
