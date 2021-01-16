public class DiameterOfABinaryTree{

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

	System.out.format("Diameter of the binary tree is %d.%n", diameter(four));
    }

    private static int diameter(final BinaryTreeNode root){
        if(root == null) return 0;

	final int heightOfTheLeftSubtree = height(root.left);
	final int heightOfTheRightSubtree = height(root.right);

	final int diameterThroughTheRoot = heightOfTheRightSubtree + heightOfTheLeftSubtree + 1;

	final int diameterOfTheLeftSubtree = diameter(root.left);
	final int diameterOfTheRightSubtree = diameter(root.right);

	return Math.max(diameterThroughTheRoot, Math.max(diameterOfTheRightSubtree, diameterOfTheLeftSubtree));
    }
}
