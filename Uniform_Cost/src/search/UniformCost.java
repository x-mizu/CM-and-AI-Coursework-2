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
	private List<String[]> result;
	
	public UniformCost () {
		this.iterations = 0;
		this.pathList = new ArrayList<Path>();
		this.visitedNodes = new ArrayList<Node>();
		this.result = new ArrayList<String[]>();
	}
	
	public List<Path> SearchBestPath(Node startNode) {
		this.startNode = startNode;
		for (Node node : this.startNode.getNeighbours().keySet()) 
			this.pathList.add(new Path(this.startNode, node, this.startNode.getNeighbours().get(node)));
		
		// this.visitedNodes.add(this.startNode); // add start Node to visited Nodes
		
		// print and set result Table
		System.out.println("Start Node: " + this.startNode.getNodeName());
		
		String[] title = {"Uniform Cost"};
		this.result.add(title);
		String[] headers = {"Step", "Open Nodes", "Close Nodes", "Current Node"};
		this.result.add(headers);
		String[] firstRow = {String.valueOf(this.iterations), "(" + this.startNode.getNodeName() + ": 0)", "", "(" + this.startNode.getNodeName() + ": 0)"};
		this.result.add(firstRow);
		
		String closeStringNodes = "(" + this.startNode.getNodeName() + ": 0)";
		
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
				
				String openStringNodes = "";
				System.out.println("Open Nodes: ");
				for (Node node : openNodes) {
					System.out.print(node.getNodeName() + ", ");
					openStringNodes += "(" + node.getNodeName() + ": " + startNeighbours.get((node)) + ")";
				}
				System.out.println();
				
				Node nextNode = (Node) openNodes.toArray()[0];
				
				// iterate until find the one with less cost
				for (Node node : openNodes)			
					if (startNeighbours.get(node) < startNeighbours.get(nextNode))
						nextNode = node;
				
				System.out.println("Next Node: " + nextNode.getNodeName() +"; Cost: " + startNeighbours.get(nextNode));
				
				Map<Node, Integer> nextNeighbours = nextNode.getNeighbours(); // get neighbours relating the next Node
				Set<Node> nextNodes = nextNeighbours.keySet(); // get all next neighbours Nodes
				
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
				
				String currentStringNode = "(" + nextNode.getNodeName() + ": " + startNeighbours.get((nextNode)) + ")";
				
				this.visitedNodes.add(nextNode);
				this.iterations++;
				
				String[] nextRow = {String.valueOf(this.iterations), openStringNodes, closeStringNodes, currentStringNode};
				this.result.add(nextRow);
				closeStringNodes += currentStringNode;
				
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

	public List<Path> getPathList() {
		return pathList;
	}

	public void setPathList(List<Path> pathList) {
		this.pathList = pathList;
	}

	public List<String[]> getResult() {
		return result;
	}

	public void setResult(List<String[]> result) {
		this.result = result;
	}

	
	
}
