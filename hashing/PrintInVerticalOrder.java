import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class PrintInVerticalOrder{
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
        
	printInVerticalOrder(four);
    }

    private static HashMap<Integer, LinkedList<BinaryTreeNode>> map = new HashMap<>();

    private static void printInVerticalOrder(final BinaryTreeNode root){
        createAMapWithVerticalOrder(root, 0);
	for(final Map.Entry<Integer, LinkedList<BinaryTreeNode>> entry : map.entrySet()){
	    final int order = entry.getKey();
	    final LinkedList<BinaryTreeNode> listOfBinaryTreeNodes = entry.getValue();
	    System.out.format("Order %d -> ", order);
	    for(final BinaryTreeNode node : listOfBinaryTreeNodes) printBinaryTreeNode(node);
	    System.out.println();
	}
    }

    private static void createAMapWithVerticalOrder(final BinaryTreeNode root, final int order){
        if(root == null) return ;
	if(!map.containsKey(order)) map.put(order, new LinkedList<BinaryTreeNode>());
	map.get(order).add(root);
	createAMapWithVerticalOrder(root.left, order - 1);
	createAMapWithVerticalOrder(root.right, order + 1);
    }
}
