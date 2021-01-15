public class AddTwoNumbers{
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
        Node headOne  = new Node(8, node1);


	Node node_3 = new Node(3);
        Node node_2 = new Node(2, node_3);
        Node node_1 = new Node(1, node_2);
        Node headTwo  = new Node(7, node_1);

	Node sumLinkedList = addLinkedList(headOne, headTwo);
	printALinkedList(sumLinkedList);
    }

    private static Node addLinkedList(final Node headOfTheFirstLinkedList, final Node headOfTheSecondLinkedList){
        if(headOfTheSecondLinkedList == null && headOfTheFirstLinkedList == null) return null;

	if(headOfTheFirstLinkedList == null) return headOfTheSecondLinkedList;
	if(headOfTheSecondLinkedList == null) return headOfTheFirstLinkedList;

        Node iterateFirstLinkedList = headOfTheFirstLinkedList;
	Node iterateSecondLinkedList = headOfTheSecondLinkedList;

	int first  = iterateFirstLinkedList.data;
	int second = iterateSecondLinkedList.data;

	iterateSecondLinkedList = iterateSecondLinkedList.nextNode;
	iterateFirstLinkedList  = iterateFirstLinkedList.nextNode;

	int sum = first + second;
	int remainder = sum % 10;
	int carryForward = sum / 10;

	Node sumLinkedList = new Node(remainder);
	Node iteratorOfSumLinkedList = sumLinkedList;

	while(iterateSecondLinkedList != null && iterateFirstLinkedList != null){
	    first  = iterateFirstLinkedList.data;
	    second = iterateSecondLinkedList.data;

	    sum = first + second + carryForward;
	    remainder = sum % 10;
	    carryForward = sum / 10;
	    
	    iteratorOfSumLinkedList.nextNode = new Node(remainder);
	    iteratorOfSumLinkedList = iteratorOfSumLinkedList.nextNode;

	    iterateSecondLinkedList = iterateSecondLinkedList.nextNode;
	    iterateFirstLinkedList  = iterateFirstLinkedList.nextNode;
	}

	if(iterateFirstLinkedList != null){
	    first = iterateFirstLinkedList.data;

	    sum = first + carryForward;
	    remainder = sum % 10;
	    carryForward = sum / 10;
	    
	    iteratorOfSumLinkedList.nextNode = new Node(remainder);
	    iteratorOfSumLinkedList = iteratorOfSumLinkedList.nextNode;

	    iterateFirstLinkedList  = iterateFirstLinkedList.nextNode;
	} else if(iterateSecondLinkedList != null){
	    second = iterateSecondLinkedList.data;

	    sum = second + carryForward;
	    remainder = sum % 10;
	    carryForward = sum / 10;
	    
	    iteratorOfSumLinkedList.nextNode = new Node(remainder);
	    iteratorOfSumLinkedList = iteratorOfSumLinkedList.nextNode;

	    iterateFirstLinkedList  = iterateFirstLinkedList.nextNode;
	}

	if(carryForward > 0 ){
	    iteratorOfSumLinkedList.nextNode = new Node(carryForward);
	}

	return sumLinkedList;
    }
}
