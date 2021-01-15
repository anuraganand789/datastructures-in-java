public class MergeTwoSortedLinkedList{
    private static class Node{
        private int data;
	private Node nextNode;

	private Node(final int data){
	    this(data, null);
	}

	private Node(final int data, final Node nextNode){
	    this.data = data;
	    this.nextNode = nextNode;
	}
    }

    private static void printALinkedList(Node head){
        while(head != null) {
	    System.out.format("%d -> ", head.data);
	    head = head.nextNode;
	}

	System.out.println(head);
    }

    public static void main(final String[] commandlineArguments){
        final Node node3 = new Node(14);
	final Node node2 = new Node(7, node3);
	final Node headOne  = new Node(1, node2);

	System.out.print("First Linked List : ");
	printALinkedList(headOne);

	final Node node7 = new Node(77);
        final Node node6 = new Node(16, node7);
	final Node node5 = new Node(5, node6);
	final Node headTwo  = new Node(4, node5);

	System.out.print("Second Linked List : ");
	printALinkedList(headTwo);
        
	printALinkedList(mergeTwoSortedLinkedList(headOne, headTwo));
    }

    private static Node mergeTwoSortedLinkedList( Node headOfTheFirstLinkedList,  Node headOfTheSecondLinkedList){
        Node headOfTheMergedLinkedList = null;

	if(headOfTheFirstLinkedList.data < headOfTheSecondLinkedList.data) {
	    headOfTheMergedLinkedList = headOfTheFirstLinkedList;
	    headOfTheFirstLinkedList  = headOfTheFirstLinkedList.nextNode;
	}else{
	    headOfTheMergedLinkedList = headOfTheSecondLinkedList;
	    headOfTheSecondLinkedList  = headOfTheSecondLinkedList.nextNode;
	}
	Node lastNodeInTheMergedLinkedList = headOfTheMergedLinkedList;
	headOfTheMergedLinkedList.nextNode = null;

	while(headOfTheFirstLinkedList != null && headOfTheSecondLinkedList != null){
	    if(headOfTheFirstLinkedList.data < headOfTheSecondLinkedList.data) {
	        lastNodeInTheMergedLinkedList.nextNode = headOfTheFirstLinkedList;
	        headOfTheFirstLinkedList  = headOfTheFirstLinkedList.nextNode;
	    }else{
	        lastNodeInTheMergedLinkedList.nextNode = headOfTheSecondLinkedList;
	        headOfTheSecondLinkedList  = headOfTheSecondLinkedList.nextNode;
	    }
	    if(lastNodeInTheMergedLinkedList.nextNode == null) break;
	    lastNodeInTheMergedLinkedList = lastNodeInTheMergedLinkedList.nextNode;
	    lastNodeInTheMergedLinkedList.nextNode = null;
	}

	lastNodeInTheMergedLinkedList.nextNode = headOfTheFirstLinkedList != null ? headOfTheFirstLinkedList : headOfTheSecondLinkedList;

        return headOfTheMergedLinkedList;
    }
}
