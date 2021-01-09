import java.util.Set;
import java.util.LinkedHashSet;

import java.util.Deque;
import java.util.ArrayDeque;

public class TopologicalSorting{

    final static Deque<Node> stack = new ArrayDeque<>();

    private static void topologicalSort(final Node node){
        if(node.isVisited) return;

	node.isVisited = true;

	for(final Node child : node.setOfChildNodes){
	    topologicalSort(child);
	}
        
	stack.addFirst(node);
    }
    
    public static void main(final String ... args){
        final TopologicalSorting top = new TopologicalSorting();

        final Node nodeA = top.new Node("A");
        final Node nodeB = top.new Node("B");
        final Node nodeC = top.new Node("C");
        final Node nodeD = top.new Node("D");
        final Node nodeE = top.new Node("E");
        final Node nodeF = top.new Node("F");

	nodeA.setOfChildNodes.add(nodeB);
	nodeA.setOfChildNodes.add(nodeF);

	nodeB.setOfChildNodes.add(nodeC);
	nodeB.setOfChildNodes.add(nodeD);

	nodeC.setOfChildNodes.add(nodeB);
	nodeC.setOfChildNodes.add(nodeA);

	nodeD.setOfChildNodes.add(nodeE);
	nodeE.setOfChildNodes.add(nodeB);

	for(final Node node : new Node[] { nodeA, nodeB, nodeC, nodeD, nodeE, nodeF}) {
	    topologicalSort(nodeA);
	}

	while(!stack.isEmpty()){
	    System.out.format("Node %s.%n", stack.removeFirst().name);
	}
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

}
