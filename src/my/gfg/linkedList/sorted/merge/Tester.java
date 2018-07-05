package my.gfg.linkedList.sorted.merge;

public class Tester {

	public static void main(String[] args) {
		LinkedList myList1 = new LinkedList();
		myList1.insertAtEnd(1);
		myList1.insertAtEnd(3);

		LinkedList myList2 = new LinkedList();
		myList2.insertAtEnd(2);
		myList2.insertAtEnd(4);
		myList2.insertAtEnd(9);

		myList1.printList();
		myList2.printList();

		LinkedList myList3 = new LinkedList();
		myList3.sortedMerge(myList1, myList2);

		myList3.printList();

	}

}
