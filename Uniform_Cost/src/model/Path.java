package model;

public class Path {
	
	private Node destinationNode;
	private Node previousNode;
	private int totalCost;

	public Path (Node previousNode, Node destinationNode, int totalCost) {
		this.previousNode = previousNode;
		this.destinationNode = destinationNode;
		this.totalCost = totalCost;
	}
	
	public String toString() {
		return ("Node: " + this.destinationNode.getNodeName() + 
				"; Previous Node: " + this.previousNode.getNodeName() + 
				"; Total Cost: " + this.totalCost);
	}
	
	public Node getDestinationNode() {
		return destinationNode;
	}

	public void setDestinationNode(Node destinationNode) {
		this.destinationNode = destinationNode;
	}

	public Node getPreviousNode() {
		return previousNode;
	}

	public void setPreviousNode(Node previousNode) {
		this.previousNode = previousNode;
	}

	public int getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(int totalCost) {
		this.totalCost = totalCost;
	}
}
