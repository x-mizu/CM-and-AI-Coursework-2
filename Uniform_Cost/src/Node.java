//package BFS;

import java.util.*;

public class Node {
	
	// Attributes
	private Object element;
	private boolean visited;
	private List<Node> neighbours;
	
	// Methods 
	public Node(Object e) {
		this.element = e;
		this.visited = false;
		this.neighbours = new ArrayList<Node>();
	}
	
	public boolean isVisited() {
		return this.visited;
	}
	
	public void addNeighbour(Node n) {
		this.neighbours.add(n);
	}

	public Object getElement() {
		return element;
	}

	public void setElement(Object element) {
		this.element = element;
	}

	public List<Node> getNeighbours() {
		return neighbours;
	}

	public void setNeighbours(List<Node> neighbours) {
		this.neighbours = neighbours;
	}
	
	public void setVisited( boolean status  ) {
		this.visited = status;
	}
	

}
