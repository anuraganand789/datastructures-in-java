public class FindPredecessorSuccessor{
    private static int height(final BinaryTreeNode root){
        return root == null ? 0 : 1 + Math.max(height(root.left), height(root.right));
    }

    private static void printBinaryTreeNode(final BinaryTreeNode node){
        if(node == null) System.out.println("NULL Node");

	System.out.format("[%d] ", node.data);
    }
    private static class BinaryTreeNode{
        private int data;
        private BinaryTreeNode left;
        private BinaryTreeNode right;
    
        private BinaryTreeNode(final int data, final BinaryTreeNode left, final BinaryTreeNode right){
            this.data  = data;
    	this.left  = left;
    	this.right = right;
        }
        private BinaryTreeNode(final int data){
            this(data, null, null);
        }
    }
    
    public static void main(final String[] args){
        final BinaryTreeNode one   = new BinaryTreeNode(1);
        final BinaryTreeNode two   = new BinaryTreeNode(2);
        final BinaryTreeNode three = new BinaryTreeNode(3);
        final BinaryTreeNode four  = new BinaryTreeNode(4);
        final BinaryTreeNode five  = new BinaryTreeNode(5);
        final BinaryTreeNode six   = new BinaryTreeNode(6);
    
        four.left = one;
        four.right = five;
    
        five.right = six;
    
        one.left = two;
        one.right = three;

	predecessorAndSuccessor(four, 1);
	System.out.format("Predecessor %d, Successor %d.%n", predecessor, successor);
	predecessorAndSuccessor(four, 4);
	System.out.format("Predecessor %d, Successor %d.%n", predecessor, successor);
    }

    private static int predecessor = -1;
    private static int successor   = -1;

    private static void predecessorAndSuccessor(final BinaryTreeNode root, final int searchData){
        if(root == null) return;

	if(root.data == searchData){
	    BinaryTreeNode predecessorNode = root.left;
	    while(predecessorNode.right != null) predecessorNode = predecessorNode.right;
	    predecessor = predecessorNode.data;

	    BinaryTreeNode successorNode   = root.right;
	    while(successorNode.left != null) successorNode = successorNode.left;
	    successor = successorNode.data;
	} else if(searchData > root.data){
	    predecessor = root.data;
	    predecessorAndSuccessor(root.right, searchData);
	} else {
	   successor = root.data; 
	   predecessorAndSuccessor(root.left, searchData);
	}
    }
}
