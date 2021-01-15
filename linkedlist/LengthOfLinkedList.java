public class LengthOfLinkedList{
    private static class Node{
        final int data;
	Node nextNode;

	private Node(final int data){ this(data, null); }

	private Node(final int data, final Node nextNode){ 
	    this.data = data;
	    this.nextNode = nextNode;
	}
    }

    public static void main(final String[] commandlineArguments){
        final Node head = new Node(19);
	final Node node1 = new Node(20);
	final Node node2 = new Node(21);
	final Node node3 = new Node(22);
	final Node node4 = new Node(22);

	head.nextNode  = node1;
	node1.nextNode = node2;
	node2.nextNode = node3;
	node3.nextNode = node4;
        
	System.out.format("Length of the linked list is %d.%n", lengthOfTheLinkedList(head));
	System.out.format("Length of a NULL linked list is %d.%n", lengthOfTheLinkedList(null));
	
    }

    private static int lengthOfTheLinkedList(final Node head){
        int length = 0;

	Node currentNode = head;

	while(currentNode != null) { 
	    currentNode = currentNode.nextNode; 
	    ++length; 
	}

	return length;
    }
}
