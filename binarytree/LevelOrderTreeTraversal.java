import java.util.Deque;
import java.util.ArrayDeque;

public class LevalOrderTreeTraversal{
    
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

    private static void printBinaryTreeNode(final BinaryTreeNode node){
        if(node == null) System.out.println("NULL Node");

	System.out.format("[%d] ", node.data);
    }

    private static void levelOrderTraversal(final BinaryTreeNode root){
        final Deque<BinaryTreeNode> queue = new ArrayDeque<>();
	final BinaryTreeNode dummy = new BinaryTreeNode(-1);
	queue.addLast(root);
	queue.addLast(dummy);

	while(!queue.isEmpty()){
	    final BinaryTreeNode currentNode = queue.removeFirst();
	    if(currentNode == dummy) {
	        System.out.println("--");
		if(queue.isEmpty()) break;
		queue.addLast(dummy);
		continue;
	    }
	    printBinaryTreeNode(currentNode);

	    if(currentNode.left != null) queue.addLast(currentNode.left);
	    if(currentNode.right != null) queue.addLast(currentNode.right);
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
	levelOrderTraversal(four);
    }
}
