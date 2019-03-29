package model;

import java.util.ArrayList;
import java.util.List;

public class Path {
	
	private List<Node> nodesPath;
	private Node startNode;
	private Node finalNode;
	private int totalCost;

	public Path (Node startNode, Node finalNode) {
		this.startNode = startNode;
		this.finalNode = finalNode;
		this.totalCost = -1;
		this.nodesPath = new ArrayList<Node>();
	}
	
	public List<Node> addNodesPath(Node node) {
		this.nodesPath.add(node);
		return nodesPath;
	}
	
	public List<Node> removeNodesPath(Node node) {
		this.nodesPath.remove(node);
		return nodesPath;
	}
	
	public List<Node> getNodesPath() {
		return nodesPath;
	}

	public void setNodesPath(List<Node> nodesPath) {
		this.nodesPath = nodesPath;
	}

	public Node getStartNode() {
		return startNode;
	}

	public void setStartNode(Node startNode) {
		this.startNode = startNode;
	}

	public Node getFinalNode() {
		return finalNode;
	}

	public void setFinalNode(Node finalNode) {
		this.finalNode = finalNode;
	}

	public int getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(int totalCost) {
		this.totalCost = totalCost;
	}
}
