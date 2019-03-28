//package BFS;

import java.util.*;

public class Main {
	public static void main(String[] args) {
		
		// Prepare the graph 
		Graph g = new Graph();
		
		int nodesNumber = 100;
		List<Node> allNodes = new ArrayList<Node>();
		
		for (int i = 0; i < nodesNumber; i++) {
			allNodes.add(new Node(i+1));
		}

		
		for (int i = 0; i < Math.round((float)nodesNumber/2); i++) {
			if (2*i + 1 != allNodes.size()) {
				System.out.print("Node: " + (i+1) + "-->" + (2*(i+1)));
				allNodes.get(i).addNeighbour(allNodes.get(2*i + 1));
				
				if (2*i + 2 != allNodes.size()) {
					System.out.println( "-->" + (2*(i+1) + 1));
					allNodes.get(i).addNeighbour(allNodes.get(2*i + 2));
				}
				
				System.out.println("\n-------------------------------------------");
			}
		}			
		
		g.setAllNodes(allNodes);
		
		// BFS the graph
		BFS dfsSearchEngine = new BFS();
		dfsSearchEngine.bfs(g);
		
	}

}
