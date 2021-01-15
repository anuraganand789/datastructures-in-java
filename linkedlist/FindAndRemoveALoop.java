public class FindAndRemoveALoop{
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
        while(head != null){
	    System.out.format("%d -> ", head.data);
	    head = head.nextNode;
	}

	System.out.println(head);
    }

    public static void main(final String[] commandlineArguments){
	final Node node4 = new Node(4);
        final Node node7 = new Node(7, node4);
        final Node node6 = new Node(6, node7);
        final Node node5 = new Node(5, node6);
        node4.nextNode = node5;
        final Node node3 = new Node(3, node4);
        final Node node2 = new Node(2, node3);
        final Node node1 = new Node(1, node2);

	//This linked list does not have any loop
        final Node node13 = new Node(13);
        final Node node12 = new Node(12, node13);
        final Node node11 = new Node(11, node12);

	System.out.println(linkedListHasLoop(node1) ? "Linked List has a loop " : "Linked List does not have a loop"); 
	printALinkedList(node1);
	System.out.println(linkedListHasLoop(null) ? "Linked List has a loop " : "Linked List does not have a loop"); 
	System.out.println(linkedListHasLoop(node11) ? "Linked List has a loop " : "Linked List does not have a loop"); 
    }

    private static boolean linkedListHasLoop(final Node head){
        if(head == null) return false;

	Node slow = head;
	Node fast = head;

	while(slow != null && fast != null && fast.nextNode != null) {
	    slow = slow.nextNode;
	    fast = fast.nextNode.nextNode;

	    if(slow == fast) {
		removeLoop(head, slow);
	        return true;
            }
	}

	return false;
    }

    private static void removeLoop(final Node headOfTheLinkedList, final Node loopNode){
        Node loopPivotPoint = loopNode;
	Node iteratorInLoop = loopNode;
	int numberOfNodesInLoop = 1;

	while(iteratorInLoop.nextNode != loopPivotPoint) {
	    ++numberOfNodesInLoop;
	    iteratorInLoop = iteratorInLoop.nextNode;
	    System.out.format("number of nodes %d.%n", numberOfNodesInLoop);

	}

	Node startsFromHead = headOfTheLinkedList;
	Node startsAwayFromHead = headOfTheLinkedList;

	while(numberOfNodesInLoop > 0) {
	    startsAwayFromHead = startsAwayFromHead.nextNode;
	    System.out.format("number of nodes %d.%n", numberOfNodesInLoop);
	    --numberOfNodesInLoop;
	}

	System.out.format("starts from head %d.%n", startsFromHead.data);
	System.out.format("starts from Away From head %d.%n", startsAwayFromHead.data);

	while(startsFromHead != startsAwayFromHead) {
	    startsFromHead = startsFromHead.nextNode;
	    startsAwayFromHead = startsAwayFromHead.nextNode;
	}

	while(startsFromHead.nextNode != startsAwayFromHead){
	   startsFromHead = startsFromHead.nextNode;
	}

	startsFromHead.nextNode = null;
    }

}
