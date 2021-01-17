import java.util.IdentityHashMap;
public class CloneBinarySearchTree{
    private static void inorder(final BinaryTreeNode root){
        if(root == null) return ;
	inorder(root.left);
	printBinaryTreeNode(root);
	if(root.random != null) System.out.format("%d has a Random %d. ", root.data, root.random.data);
	inorder(root.right);
    }
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
        private BinaryTreeNode random;
    
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
        two.random = one;

	final BinaryTreeNode clonedTree = cloneBinarySearchTree(four);
	cloneRandomNode(four, clonedTree);
	inorder(clonedTree);
    }
    
    private static final IdentityHashMap<BinaryTreeNode, BinaryTreeNode> map = new IdentityHashMap<>();

    private static BinaryTreeNode cloneBinarySearchTree(final BinaryTreeNode rootOriginal){
        if(rootOriginal == null) return null;

	final BinaryTreeNode clonedRoot = new BinaryTreeNode(rootOriginal.data);

	clonedRoot.left  = cloneBinarySearchTree(rootOriginal.left);
	clonedRoot.right = cloneBinarySearchTree(rootOriginal.right);
        
	map.put(rootOriginal, clonedRoot);

	return clonedRoot;
    }

    private static void cloneRandomNode(final BinaryTreeNode original, final BinaryTreeNode clone){
        if(original == null) return;

	clone.random = map.get(original.random);
	cloneRandomNode(original.left, clone.left);
	cloneRandomNode(original.right, clone.right);
    }
}
