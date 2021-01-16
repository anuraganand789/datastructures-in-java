public class BinaryTreeIsBinarySearchTree{
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
    
        one.right = two;
        two.right = three;
        
	if(binaryTreeIsBinarySearchTree(four, -1, 100)) 
	    System.out.println("Binary Tree is binary search tree");
        else 
	    System.out.println("Binary Tree is not a binary search tree");
	    
    }
    
    private static boolean binaryTreeIsBinarySearchTree(final BinaryTreeNode root, final int minValue, final int maxValue){
        if(root == null) return true;
	System.out.format("Root %d, MIn %d, Max %d.%n", root.data, minValue, maxValue);

	return root.data > minValue && root.data < maxValue && 
	       binaryTreeIsBinarySearchTree(root.left, minValue, root.data) && 
	       binaryTreeIsBinarySearchTree(root.right, root.data, maxValue);
    }
}
