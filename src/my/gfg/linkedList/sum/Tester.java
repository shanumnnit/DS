package my.gfg.linkedList.sum;

public class Tester {

	public static void main(String[] args) {
		LinkedList myList1 = new LinkedList();
		myList1.insertAtBeginning(9);
		myList1.insertAtBeginning(9);
		myList1.insertAtBeginning(9);

		LinkedList myList2 = new LinkedList();
		myList2.insertAtBeginning(9);
		myList2.insertAtBeginning(9);

		LinkedList myList3 = LinkedList.sum(myList1, myList2);

		myList1.reverse();
		myList1.printList();
		myList2.reverse();
		myList2.printList();

		myList3.reverse();
		myList3.printList();

	}

}
