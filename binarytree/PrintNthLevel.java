import java.util.Deque;
import java.util.ArrayDeque;

public class PrintNthLevel{
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

	printNthLevel(four, 1);
	System.out.println();

	printNthLevel(four, 2);
	System.out.println();

	printNthLevel(four, 3);
	System.out.println();

	printNthLevel(four, 4);
	System.out.println();
    }

    private static void printNthLevel(final BinaryTreeNode root, final int level){
        if(root == null) return;

	final BinaryTreeNode markForLevelEnd = new BinaryTreeNode(-1);

	final Deque<BinaryTreeNode> queue = new ArrayDeque<>();
	queue.addLast(root);
	queue.addLast(markForLevelEnd);

	int currentLevel = 1;
	while(!queue.isEmpty()){
	     if(currentLevel > level) break;

	     final BinaryTreeNode currentTreeNode = queue.removeFirst();

	     if(currentTreeNode == markForLevelEnd){
	         ++currentLevel;
		 if(!queue.isEmpty()) { queue.addLast(markForLevelEnd); }
		 continue;
	     }

	     if(currentLevel == level) {
		 System.out.format("Level Number %d ", currentLevel);
	         printBinaryTreeNode(currentTreeNode);
	      }

	     if(currentTreeNode.left  != null) queue.addLast(currentTreeNode.left);
	     if(currentTreeNode.right != null) queue.addLast(currentTreeNode.right);

	}
    }

}
