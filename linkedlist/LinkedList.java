public class LinkedList{
    public static void main(final String[] commandlineArguments){
	Node head = new Node(12);
	printLinkedList(head);
	insertAtTheTail(head, 11);
	printLinkedList(head);
	head = insertAtTheHead(head, 22);
	printLinkedList(head);
	insertAfterSearchValue(head, 11, 99);
	printLinkedList(head);
	insertAfterSearchValue(head, 1, 9);
	printLinkedList(head);
	head = delete(head, 12);
	printLinkedList(head);
    }

    private static class Node{
        private Node(final int data){
	    this(data, null);
	}

	private Node(final int data, final Node nextNode){
	    this.data = data;
	    this.nextNode = nextNode;
	}

	private int data;
	private Node nextNode;
    }

    private static void printLinkedList(final Node head){
        Node currentNode = head;

	while(currentNode != null) {
	    System.out.format("%d -> ", currentNode.data);
	    currentNode = currentNode.nextNode;
	}

	System.out.println(currentNode);
    }

    private static Node searchNodeWithTheValue(final int data, final Node head){
        if(head == null) return null;

	Node currentNode = head;

	while(currentNode != null && currentNode.data != data ) currentNode = currentNode.nextNode;

        return currentNode;
    }

    private static void insertAtTheTail(final Node head, final int data){
        if(head == null) return;

	final Node newNode = new Node(data);

	Node currentNode = head;

	while(currentNode.nextNode != null) currentNode = currentNode.nextNode;

	currentNode.nextNode = newNode;
    }

    private static Node insertAtTheHead(final Node head, final int data){
        if(head == null) return null;

	final Node newNode = new Node(data, head);

	return newNode;
    }

    private static void insertAfterSearchValue(final Node head, final int dataToSearchFor, final int dataToCreateNewNodeWith){
        if(head == null) return;

	final Node nodeWithSearchData = searchNodeWithTheValue(dataToSearchFor, head);
	if(nodeWithSearchData == null) return;

	final Node newNode = new Node(dataToCreateNewNodeWith, nodeWithSearchData.nextNode);
	nodeWithSearchData.nextNode = newNode;
    }

    private static Node delete(final Node head, final int data){
        if(head == null) return null;

	Node previousNode = null;
	Node currentNode = head;

	while(currentNode != null && currentNode.data != data){
	    previousNode = currentNode;
	    currentNode = currentNode.nextNode;
	}

	if(previousNode == null && currentNode.data == data) {

	    previousNode = currentNode;
	    currentNode = currentNode.nextNode;
	    previousNode.nextNode = null;

	    return currentNode;
	}

	previousNode.nextNode = currentNode.nextNode;
	currentNode.nextNode = null;
        
	return head;
    }
}
