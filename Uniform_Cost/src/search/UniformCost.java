package search;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import model.Node;
import model.Path;

public class UniformCost {

	private Node startNode;
	private int iterations;
	private List<Path> pathList;
	private List<Node> visitedNodes;
	
	public UniformCost (Node startNode) {
		this.startNode = startNode;
		this.iterations = 0;
		this.pathList = new ArrayList<Path>();
		
		for (Node node : this.startNode.getNeighbours().keySet()) 
			this.pathList.add(new Path(this.startNode, node, this.startNode.getNeighbours().get(node)));
		
		
		this.visitedNodes = new ArrayList<Node>();
	}
	
	public List<Path> SearchBestPath() {
		
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
			
			// if there is at least one neighbour
			if (openNodes.size() > 0 ) {
				System.out.println("Open Nodes: ");
				for (Node node : openNodes) {
					System.out.print(node.getNodeName() + ", ");
				}
				System.out.println();
				
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
					int totalCostToNode = startNeighbours.get(nextNode) + nextNeighbours.get(node);
					
					if (startNeighbours.containsKey(node)) {
						if (startNeighbours.get(node) > totalCostToNode) {
							this.pathList.add(new Path(nextNode, node, totalCostToNode));
							this.startNode.addNeighbour(node, totalCostToNode);
						}
					} else {
						this.pathList.add(new Path(nextNode, node, totalCostToNode));
						this.startNode.addNeighbour(node, totalCostToNode);
					}
				}
				
				System.out.println("---------------");
				this.visitedNodes.add(nextNode);
				
			} else {
				break;
			}
		}
		
		this.removeHighCostFromDuplicatePath();
		
		return this.pathList;
	}
	
	private void removeHighCostFromDuplicatePath() {
		List<Path> pathsToRemove = new ArrayList<Path>();
		
		for (Path path : this.pathList) {
			for (Path path2 : this.pathList) {
				if (path != path2) {
					if (path.getDestinationNode() == path2.getDestinationNode() && path.getTotalCost() >= path2.getTotalCost()) {
						pathsToRemove.add(path);
						break;
					}
				}
				
			}
		}
		
		this.pathList.removeAll(pathsToRemove);
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
