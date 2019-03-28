// package BFS;

import java.util.*;

public class BFS {
	// Attributes 
	private Queue<Node> myQueue;
	
	// Methods
	public BFS() {
		this.myQueue = new LinkedList<Node>();
	}
	
	public void bfs(Graph g) {
		List<Node> nodeList = g.getAllNodes();
		
		for (Node n : nodeList) {
			if (n.isVisited() == false) {
				n.setVisited(true);
				bsfInQueue(n);
			}
		}
	}
	

	private void bsfInQueue(Node root) {
		this.myQueue.add(root);
		root.setVisited(true);
		
		while(this.myQueue.isEmpty() == false) {
			Node currentNode = this.myQueue.remove();
			System.out.println("Current node: " + currentNode.getElement().toString());
			
			for (Node n : currentNode.getNeighbours()) {
				if (n.isVisited() == false) {
					n.setVisited(true);
					this.myQueue.add(n);
				}
			}
		}
		
	}
}
