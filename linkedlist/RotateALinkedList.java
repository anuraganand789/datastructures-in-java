public class RotateLinkedList{
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
    
    private static void printALinkedList(Node node){
        while(node != null) {
	    System.out.format("%d -> ", node.data);
	    node = node.nextNode;
	}

	System.out.println(node);
    }

    public static void main(final String[] commandLineArguments){
	Node node3 = new Node(3);
        Node node2 = new Node(2, node3);
        Node node1 = new Node(1, node2);
        Node head  = new Node(0, node1);

	printALinkedList(head);
	head = rotate(head, 5);
	printALinkedList(head);
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
        
	int noOfTimeToBeRotated = lengthOfTheLinkedList - (times % lengthOfTheLinkedList) - 1;
	System.out.format("No of times to be rotated %d.%n", noOfTimeToBeRotated);

	Node currentNode = headOfTheLinkedList;

	while(noOfTimeToBeRotated > 0){
	    currentNode = currentNode.nextNode;
	    --noOfTimeToBeRotated;
	}

	Node newHead = currentNode.nextNode;
	System.out.format("new head %d.%n", newHead.data);
        currentNode.nextNode = null;
	
	Node iterator = newHead;
	while(iterator != null && iterator.nextNode != null) iterator = iterator.nextNode;
        
	iterator.nextNode = headOfTheLinkedList;
        
	return newHead;
    }
}

