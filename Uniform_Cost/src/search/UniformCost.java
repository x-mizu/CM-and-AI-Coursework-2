package search;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import model.Node;
import model.Path;

public class UniformCost {

	private List<Node> allNodes;
	private Node currentNode;
	private Node startNode;
	private int iterations;
	private List<Path> pathList;
	private List<Node> visitedNodes;
	private List<Node> nextNodes;
	
	public UniformCost (List<Node> allNodes, Node startNode) {
		this.allNodes = allNodes;
		this.startNode = startNode;
		this.iterations = 0;
		this.pathList = new ArrayList<Path>();
		
		for (Node node : allNodes)
			this.pathList.add(new Path(this.startNode, node));
		
		
		this.visitedNodes = new ArrayList<Node>();
		this.nextNodes = new ArrayList<Node>();
	}
	
	public List<Path> SearchBestPaths() {
		
		// this.currentNode = this.startNode; // set current Node
		System.out.println("Start Node: " + this.startNode.getNodeName());
		
		// this.allNodes.remove(this.currentNode); // remove current Node from all Nodes
		this.visitedNodes.add(this.startNode); // add current Node to visited Nodes
		while (true) {
			Map<Node, Integer> startNeighbours = this.startNode.getNeighbours(); // get neighbours realting the start Node
			Set<Node> openNodes = startNeighbours.keySet(); // get all neighbours Nodes

			List<Node> nodesToBeRemoved = new ArrayList<Node>();
			for (Node node : openNodes) 
				if (this.visitedNodes.contains(node))
					nodesToBeRemoved.add(node);
			
			openNodes.removeAll(nodesToBeRemoved);
			
			System.out.println("Open Nodes: ");
			for (Node node : openNodes) {
				System.out.print(node.getNodeName() + ", ");
			}
			System.out.println();
			// if there is at least one neighbour
			if (openNodes.size() > 0 ) {
				
				Node nextNode = (Node) openNodes.toArray()[0];
				
				// iterate until find the one with less cost
				for (Node node : openNodes)			
					if (startNeighbours.get(node) < startNeighbours.get(nextNode))
						nextNode = node;
				
				System.out.println("Next Node: " + nextNode.getNodeName() +"; Cost: " + startNeighbours.get(nextNode));
				
				Map<Node, Integer> nextNeighbours = nextNode.getNeighbours(); // get neighbours realting the next Node
				Set<Node> nextNodes = nextNeighbours.keySet(); // get all neighbours Nodes
				
				// att first Node neighbours with this new information
				for (Node node : nextNodes) {
					if (startNeighbours.containsKey(node)) {
						if (startNeighbours.get(node) > startNeighbours.get(nextNode) + nextNeighbours.get(node)) {
							this.startNode.addNeighbour(node, startNeighbours.get(nextNode) +  nextNeighbours.get(node));
						}
					} else {
						this.startNode.addNeighbour(node, startNeighbours.get(nextNode) + nextNeighbours.get(node));
					}
				}
				
				System.out.println("---------------");
				this.visitedNodes.add(nextNode);
				
			} else {
				break;
			}
		}
		
		
		
		return this.pathList;
	}

	public Node getStartNode() {
		return startNode;
	}

	public void setStartNode(Node startNode) {
		this.startNode = startNode;
	}

	public int getIterations() {
		return iterations;
	}

	public void setIterations(int iterations) {
		this.iterations = iterations;
	}

	public List<Path> getPathList() {
		return pathList;
	}

	public void setPathList(List<Path> pathList) {
		this.pathList = pathList;
	}
	
	
}
