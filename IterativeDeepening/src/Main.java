
import aiii2.Node;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mjhussa3
 */
public class Main {
    public static void main(String[] args) {
        Node s = new Node("S" , 9);
        Node a = new Node("A" , 6);
        Node b = new Node("B" , 2);
        Node c = new Node("C" , 2);
        Node d = new Node("D" , 5);
        Node e = new Node("E" , 5);
        Node f = new Node("F" , 3);
        Node j = new Node("J" , 1);
        Node g1 = new Node("G1" , 0);
        Node g2 = new Node("G2" , 0);
        
        s.addNeighbour(a);
        s.addNeighbour(c);
        s.addNeighbour(d);
        
        a.addNeighbour(b);
        a.addNeighbour(g1);
        
        b.addNeighbour(g1);
        
        c.addNeighbour(b);
        c.addNeighbour(d);
        c.addNeighbour(j);
        c.addNeighbour(f);
        
        d.addNeighbour(e);
        
        e.addNeighbour(f);
        e.addNeighbour(g2);
        
        f.addNeighbour(g2);
        
        j.addNeighbour(f);
        j.addNeighbour(g1);
        
//        System.out.println(s.getName());
//        System.out.println(s.getNumber());
//        System.out.println(s.getAdjacenciesList());

    }
}