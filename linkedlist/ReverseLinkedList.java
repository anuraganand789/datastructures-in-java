public class ReverseLinkedList{
    public static Node reverseTheLinkedList(final Node head){
        if(head == null || head.nextNode == null) return head;

	Node currentNode = head;
	Node nextNodeOfCurrentNode = null;
	Node previousNode = null;

	while(currentNode != null){
	    nextNodeOfCurrentNode = currentNode.nextNode;

	    currentNode.nextNode = previousNode;
	    previousNode = currentNode;

	    currentNode = nextNodeOfCurrentNode;
	}

	return previousNode;
    }

    private static class Node {
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

    private static void
    printTheLinkedList(Node head){
        while(head != null) {
	    System.out.format("%d -> ", head.data);
	    head = head.nextNode;
	}

	System.out.println(head);
    }

    public static void main(final String[] commandlineArguments){
        final Node node_5  = new Node(5);
        final Node node_4  = new Node(4, node_5);
        final Node node_3  = new Node(3, node_4);
        final Node node_2  = new Node(2, node_3);
        final Node node_1  = new Node(1, node_2);
        Node head = new Node(0, node_1);

	printTheLinkedList(head);

	head = reverseTheLinkedList(head);
	printTheLinkedList(head);
    }

}
