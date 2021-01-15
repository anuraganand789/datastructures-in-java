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

    private static void printALinkedList(Node node){
        while(node != null) {
	    System.out.format("%d -> ", node.data);
	    node = node.nextNode;
	}

	System.out.println(node);
    }

    private static int lengthOfLinkedList(Node headOfTheLinkedList){
        int numberOfNodes  = 0;
	while(headOfTheLinkedList != null) { 
	    headOfTheLinkedList = headOfTheLinkedList.nextNode;
	    ++numberOfNodes; 
	}

	return numberOfNodes;
    }

    private static Node rotate(final Node headOfTheLinkedList, final int times){
	if(headOfTheLinkedList == null) return null;
        final int lengthOfTheLinkedList = lengthOfLinkedList(headOfTheLinkedList);
        
	int noOfTimeToBeRotated = lengthOfTheLinkedList - (times % lengthOfTheLinkedList);

	Node currentNode = headOfTheLinkedList;

	while(noOfTimeToBeRotated > 0){
	    currentNode = currentNode.nextNode;
	    --noOfTimeToBeRotated;
	}

	Node newHead = currentNode.nextNode;
        currentNode.nextNode = null;
	
	Node iterator = newHead;
	while(iterator.nextNode != null) iterator = iterator.nextNode;
        
	iterator.nextNode = headOfTheLinkedList;
    }

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

    public static void main(final String[] commandLineArguments){
	Node node3 = new Node(3);
        Node node2 = new Node(2, node3);
        Node node1 = new Node(1, node2);
        Node head  = new Node(0, node1);
    }
