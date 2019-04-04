
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
        
        IterativeDeepening i = new IterativeDeepening(g1, g2);
        i.runDeepeningSearch(s);
        
//        System.out.println(s.getName());
//        System.out.println(s.getNumber());
//        System.out.println(s.getAdjacenciesList());
//        
//        System.out.println(a.getName());
//        System.out.println(a.getNumber());
//        System.out.println(a.getAdjacenciesList());
//        
//        System.out.println(b.getName());
//        System.out.println(b.getNumber());
//        System.out.println(b.getAdjacenciesList());
//        
//        System.out.println(c.getName());
//        System.out.println(c.getNumber());
//        System.out.println(c.getAdjacenciesList());
//        
//        System.out.println(d.getName());
//        System.out.println(d.getNumber());
//        System.out.println(d.getAdjacenciesList());
//        
//        System.out.println(e.getName());
//        System.out.println(e.getNumber());
//        System.out.println(e.getAdjacenciesList());
//        
//        System.out.println(f.getName());
//        System.out.println(f.getNumber());
//        System.out.println(f.getAdjacenciesList());
//        
//        System.out.println(j.getName());
//        System.out.println(j.getNumber());
//        System.out.println(j.getAdjacenciesList());

    }
}