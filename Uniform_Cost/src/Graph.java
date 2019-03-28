// package BFS;

import java.util.*;

public class Graph {
	// Attributes 
	private List<Node> allNodes;
	
	
	// Methods 
	public Graph() {
		this.allNodes = new ArrayList<Node>();
	}
	
	public void setAllNodes(List<Node> allNodes) {
		this.allNodes = allNodes;
	}
	
	public List<Node> getAllNodes(){
		return this.allNodes;
	}

}
