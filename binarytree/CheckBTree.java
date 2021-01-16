public class CheckBTree{

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

        final BinaryTreeNode one_subTree   = new BinaryTreeNode(1);
        final BinaryTreeNode two_subTree   = new BinaryTreeNode(2);
        final BinaryTreeNode three_subTree = new BinaryTreeNode(3);

        one_subTree.left = two_subTree;
        one_subTree.right = three_subTree;

	if(isSubTree(four, one_subTree)) System.out.println("Subtree exists");
        else System.out.println("Subtree does not exists");

        one_subTree.left = two_subTree;
        one_subTree.right =  null;

	if(isSubTree(four, one_subTree)) System.out.println("Subtree exists");
        else System.out.println("Subtree does not exists");
    }

    private static boolean allTheNodesMatches(final BinaryTreeNode rootOfMainTree, final BinaryTreeNode rootOfSubTree){
        if(rootOfSubTree == null && rootOfMainTree == null) return true;
        if(rootOfSubTree == null || rootOfMainTree == null) return false;

	return rootOfSubTree.data == rootOfMainTree.data && 
	       allTheNodesMatches(rootOfMainTree.left, rootOfSubTree.left) && 
	       allTheNodesMatches(rootOfMainTree.right, rootOfSubTree.right);  

    }

    private static boolean isSubTree(final BinaryTreeNode rootOfMainTree, final BinaryTreeNode rootOfSubTree){
        if(rootOfSubTree == null && rootOfMainTree == null) return true;
        if(rootOfSubTree == null || rootOfMainTree == null) return false;

	return allTheNodesMatches(rootOfMainTree, rootOfSubTree) || 
	       isSubTree(rootOfMainTree.left, rootOfSubTree)     || 
	       isSubTree(rootOfMainTree.right, rootOfSubTree);
    }
}
