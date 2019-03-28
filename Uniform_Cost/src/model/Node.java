package model;
import java.util.HashMap;
import java.util.Map;

public class Node {
	
	private String nodeName;
	private boolean visited;
	private Map<Node, Integer> neighbours;
	
	public Node(String nodeName) {
		this.nodeName = nodeName;
		this.visited = false;
		this.neighbours = new HashMap<Node, Integer>();
	}
	
	public boolean isVisited() {
		return this.visited;
	}
	
	public void addNeighbour(Node n, int cost) {
		this.neighbours.put(n, cost);
	}

	public String getNodeName() {
		return nodeName;
	}

	public void setNodeName(String nodeName) {
		this.nodeName = nodeName;
	}

	public Map<Node, Integer> getNeighbours() {
		return neighbours;
	}

	public void setNeighbours(Map<Node, Integer> neighbours) {
		this.neighbours = neighbours;
	}
	
	public void setVisited( boolean status  ) {
		this.visited = status;
	}
	

}
