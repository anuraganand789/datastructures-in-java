import java.util.Set;
import java.util.LinkedHashSet;

import java.util.Deque;
import java.util.ArrayDeque;

public class DepthFirstSearch{
    
    public static void main(final String ... args){
        final DepthFirstSearch bfs = new DepthFirstSearch();

        final Node nodeA = bfs.new Node("A");
        final Node nodeB = bfs.new Node("B");
        final Node nodeC = bfs.new Node("C");
        final Node nodeD = bfs.new Node("D");
        final Node nodeE = bfs.new Node("E");
        final Node nodeF = bfs.new Node("F");

	nodeA.setOfChildNodes.add(nodeB);
	nodeA.setOfChildNodes.add(nodeF);

	nodeB.setOfChildNodes.add(nodeC);
	nodeB.setOfChildNodes.add(nodeD);

	nodeC.setOfChildNodes.add(nodeB);
	nodeC.setOfChildNodes.add(nodeA);

	nodeD.setOfChildNodes.add(nodeE);
	nodeE.setOfChildNodes.add(nodeB);

	depthFirstSearch(nodeA);
    }

    private class Node {
        private final String name;
	private final Set<Node> setOfChildNodes;
	private boolean isVisited;

	private Node(final String name){
	    this.name = name;
	    this.setOfChildNodes = new LinkedHashSet<>();
	}
    }

    private static void depthFirstSearch(final Node root){
        final Deque<Node> stack = new ArrayDeque<>();
	stack.push(root);

	while(!stack.isEmpty()){
	   final Node currentNode = stack.removeFirst();
	   System.out.format("Node %s.%n", currentNode.name);

	   for(final Node childNode : currentNode.setOfChildNodes){
	       if(childNode.isVisited) continue;

	       childNode.isVisited = true;
	       stack.addFirst(childNode);
	   }
	}
    }
}
