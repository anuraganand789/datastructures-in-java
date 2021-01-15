public class SwapNodesInLL{

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

    public static void main(final String[] commandlineArguments){
	Node head    = new Node(1);
        Node node_1  = new Node(2);
        Node node_2  = new Node(3);
        Node node_3  = new Node(4);

	head.nextNode   = node_1;
	node_1.nextNode = node_2;
	node_2.nextNode = node_3;

	printLinkedList(head);
        
	swapNodes(head, 2, 4);
	printLinkedList(head);

	swapNodes(head, 3, 2);
	printLinkedList(head);

	head = swapNodes(head, 1, 3);
	printLinkedList(head);
    }

    private static void
    printLinkedList(final Node head){
        Node currentNode = head;

	while(currentNode != null) {
	    System.out.format("%d -> ", currentNode.data);
	    
	    currentNode = currentNode.nextNode;
	}

	System.out.println(currentNode);
    }

    private static void 
    printNode(final Node node){
        if(node == null) System.out.println(node);
	else System.out.format("%d %n", node.data);
    }

    private static void 
    printNode(final String message, final Node node){
        if(node == null) System.out.format("%s %s.%n", message, "NULL");
	else System.out.format("%s %d %n", message, node.data);
    }
    private static Node swapNodes(final Node head, final int dataForTheFirstNode, final int dataForTheSecondNode){
        if(head == null) return head;

	Node previousNodeFirst = null;
	Node currentNode = head;

        while(currentNode != null && currentNode.data != dataForTheFirstNode){
	    previousNodeFirst = currentNode;
	    currentNode = currentNode.nextNode;
	}

	if(previousNodeFirst == null && currentNode.data != dataForTheFirstNode) return head;

	Node previousNodeSecond = null;

	currentNode = head;
        while(currentNode != null && currentNode.data != dataForTheSecondNode){
	    previousNodeSecond = currentNode;
	    currentNode = currentNode.nextNode;
	}

	if(previousNodeSecond == null) return head;

	final Node firstNode  = previousNodeFirst == null ? head : previousNodeFirst.nextNode;
        printNode("firstNode", firstNode);

	final Node secondNode = previousNodeSecond.nextNode;
        printNode("secondNode", secondNode);

	final Node nextNodeOfFirstNode  = firstNode.nextNode;
        printNode("nextNodeOfFirstNode", nextNodeOfFirstNode);

	final Node nextNodeOfSecondNode = secondNode.nextNode;
        printNode("nextNodeOfSecondNode", nextNodeOfSecondNode);

	//Special Case : where Head is the first Node
	if(previousNodeFirst == null && firstNode == head){
            secondNode.nextNode = nextNodeOfFirstNode;
	    previousNodeSecond.nextNode = firstNode;
	    firstNode.nextNode = nextNodeOfSecondNode;

	    return secondNode;
	}


        //Sepcial Case : where nodes are adjacent to each other
	if(firstNode.nextNode == secondNode){
	    previousNodeFirst.nextNode = secondNode;
	    firstNode.nextNode = nextNodeOfSecondNode;
	    secondNode.nextNode = firstNode;

	    return head;
	}

	previousNodeFirst.nextNode = secondNode;
	previousNodeSecond.nextNode = firstNode;

	secondNode.nextNode = nextNodeOfFirstNode;
	firstNode.nextNode  = nextNodeOfSecondNode;

	return head;
    }
}
