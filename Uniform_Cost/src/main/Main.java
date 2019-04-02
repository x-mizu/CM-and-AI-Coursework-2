package main;

import java.util.List;

import model.Node;
import model.Path;
import search.UniformCost;

public class Main {
	public static void main(String[] args) {
		
		// creates every node
		Node S = new Node("S");
		Node A = new Node("A");
		Node B = new Node("B");
		Node C = new Node("C");
		Node D = new Node("D");
		Node E = new Node("E");
		Node F = new Node("F");
		Node G1 = new Node("G1");
		Node G2 = new Node("G2");
		Node J = new Node("J");
		// ------------------
		
		// add neighbours and costs
		// S node
		S.addNeighbour(A, 4);
		S.addNeighbour(D, 1);
		S.addNeighbour(C, 3);
		// ------------------
		// A node
		A.addNeighbour(B, 3);
		A.addNeighbour(G1, 8);
		// ------------------
		// B node
		B.addNeighbour(G1, 4);
		// ------------------
		// C node
		C.addNeighbour(B, 2);
		C.addNeighbour(D, 2);
		C.addNeighbour(J, 4);
		C.addNeighbour(F, 2);
		// ------------------
		// D node
		D.addNeighbour(E, 3);
		// ------------------
		// E node
		E.addNeighbour(G2, 6);
		E.addNeighbour(F, 3);
		// ------------------
		// F node
		F.addNeighbour(G2, 4);
		// ------------------
		// J node
		J.addNeighbour(G1, 3);
		J.addNeighbour(F, 5);
		// ------------------
		
		
		UniformCost uc = new UniformCost(S);
		List<Path> listPath = uc.SearchBestPath();
		
		for (Path path : listPath) {
			System.out.println(path.toString());
		}
	}

}
