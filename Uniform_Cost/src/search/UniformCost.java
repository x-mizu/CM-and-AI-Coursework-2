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
		
		this.currentNode = this.startNode; // set current Node
		
		
		this.allNodes.remove(this.currentNode); // remove current Node from all Nodes
		this.visitedNodes.add(this.currentNode); // add current Node to visited Nodes
		
		Map<Node, Integer> currentNeighbours = this.currentNode.getNeighbours(); // get neighbours for current Node
		Set<Node> openNodes = currentNeighbours.keySet(); // get all neighbours Nodes
		
		// if there is at least one neighbour, iterate until find the one with less cost
		if (openNodes.size() > 0 ) {
			Node nextNode = (Node) openNodes.toArray()[0];
			
			for (Node node : openNodes) {
				
				if (currentNeighbours.get(node) < currentNeighbours.get(nextNode)) {
					nextNode = node;
				}
					
				// set path and cost to reach each node
				for (Path path : this.pathList) {
					if (
						path.getFinalNode() == node && 
						path.getStartNode() == this.currentNode && 
						path.getTotalCost() > currentNeighbours.get(node)
						) {
						path.setTotalCost(currentNeighbours.get(node));
						path.addNodesPath(node);
					} else if (path.getFinalNode() == node) {
						
					}
				}
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
