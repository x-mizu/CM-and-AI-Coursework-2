

import java.util.PriorityQueue;
import java.util.HashSet;
import java.util.Set;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;

//diff between uniform cost search and dijkstra algo is that UCS has a goal

public class UniformCostSearch_original{
    public static void main(String[] args){

        //initialize the graph base on the Romania map
        Node n1 = new Node("S,9");
        Node n2 = new Node("A,6");
        Node n3 = new Node("B,2");
        Node n4 = new Node("C,2");
        Node n5 = new Node("D,5");
        Node n6 = new Node("E,5");
        Node n7 = new Node("F,3");
        Node n8 = new Node("G1,0");
        Node n9 = new Node("G2,0");
        Node n10 = new Node("J,1");
      

        //initialize the edges
        n1.adjacencies = new Edge[]{
            new Edge(n1,0),
            new Edge(n2,4),
            new Edge(n3,7),
            new Edge(n4,3),
            new Edge(n5,1),
            new Edge(n6,4),
            new Edge(n7,5),
            new Edge(n8,9),
            new Edge(n9,9),
            new Edge(n10,7)
       
        };

        n2.adjacencies = new Edge[]{
            new Edge(n1,-1),
            new Edge(n2,0),
            new Edge(n3,3),
            new Edge(n4,0),
            new Edge(n5,0),
            new Edge(n6,0),
            new Edge(n7,0),
            new Edge(n8,0),
            new Edge(n9,0),
            new Edge(n10,0)
            
        };

        n3.adjacencies = new Edge[]{
            new Edge(n1,0),
            new Edge(n2,0),
            new Edge(n3,0),
            new Edge(n4,0),
            new Edge(n5,0),
            new Edge(n6,0),
            new Edge(n7,0),
            new Edge(n8,4),
            new Edge(n9,0),
            new Edge(n10,0)
              
            
        };

        n4.adjacencies = new Edge[]{
            new Edge(n1,0),
            new Edge(n2,0),
            new Edge(n3,2),
            new Edge(n4,2),
            new Edge(n5,2),
            new Edge(n6,5),
            new Edge(n7,2),
            new Edge(n8,6),
            new Edge(n9,6),
            new Edge(n10,4)

           
        };

        n5.adjacencies = new Edge[]{
            new Edge(n1,0),
            new Edge(n2,0),
            new Edge(n3,0),
            new Edge(n4,0),
            new Edge(n5,0),
            new Edge(n6,3),
            new Edge(n7,3),
            new Edge(n8,0),
            new Edge(n9,6),
            new Edge(n10,0)

        };

        n6.adjacencies = new Edge[]{
            new Edge(n1,0),
            new Edge(n2,0),
            new Edge(n3,7),
            new Edge(n4,3),
            new Edge(n5,1),
            new Edge(n6,4),
            new Edge(n7,3),
            new Edge(n8,9),
            new Edge(n9,6),
            new Edge(n10,7)

         
        };

        n7.adjacencies = new Edge[]{
            new Edge(n1,0),
            new Edge(n2,0),
            new Edge(n3,0),
            new Edge(n4,0),
            new Edge(n5,0),
            new Edge(n6,0),
            new Edge(n7,0),
            new Edge(n8,0),
            new Edge(n9,4),
            new Edge(n10,0)

           
        };

        n8.adjacencies = new Edge[]{
            new Edge(n1,0),
            new Edge(n2,0),
            new Edge(n3,0),
            new Edge(n4,0),
            new Edge(n5,0),
            new Edge(n6,0),
            new Edge(n7,0),
            new Edge(n8,0),
            new Edge(n9,0),
            new Edge(n10,0)
        };

        n9.adjacencies = new Edge[]{
            new Edge(n1,0),
            new Edge(n2,0),
            new Edge(n3,0),
            new Edge(n4,0),
            new Edge(n5,0),
            new Edge(n6,0),
            new Edge(n7,0),
            new Edge(n8,0),
            new Edge(n9,0),
            new Edge(n10,0)
        };

        n10.adjacencies = new Edge[]{
            new Edge(n1,0),
            new Edge(n2,0),
            new Edge(n3,0),
            new Edge(n4,0),
            new Edge(n5,0),
            new Edge(n6,0),
            new Edge(n7,5),
            new Edge(n8,3),
            new Edge(n9,0),
            new Edge(n10,0)
        };


      

        UniformCostSearch(n1,n10);

        List<Node> path = printPath(n10);

        System.out.println("Path: " + path);

    }

    public static void UniformCostSearch(Node source, Node goal){

        source.pathCost = 0;
        PriorityQueue<Node> queue = new PriorityQueue<Node>(20, 
            new Comparator<Node>(){

                //override compare method
                public int compare(Node i, Node j){
                    if(i.pathCost > j.pathCost){
                        return 1;
                    }

                    else if (i.pathCost < j.pathCost){
                        return -1;
                    }

                    else{
                        return 0;
                    }
                }
            }

        );

        queue.add(source);
        Set<Node> explored = new HashSet<Node>();
        boolean found = false;

        //while frontier is not empty
        do{

            Node current = queue.poll();
            explored.add(current);


            if(current.value.equals(goal.value)){
                found = true;


            }




            for(Edge e: current.adjacencies){
                Node child = e.target;
                double cost = e.cost;
                child.pathCost = current.pathCost + cost;



                if(!explored.contains(child) && !queue.contains(child)){

                    child.parent = current;
                    queue.add(child);

                    System.out.println(child);
                    System.out.println(queue);
                    System.out.println();
               

                }


                else if((queue.contains(child))&&(child.pathCost>current.pathCost)){

                    child.parent=current;
                    current = child;

                }


            }
        }while(!queue.isEmpty());

    }

    public static List<Node> printPath(Node target){
        List<Node> path = new ArrayList<Node>();
        for(Node node = target; node!=null; node = node.parent){
            path.add(node);
        }

        Collections.reverse(path);

        return path;

    }

}

class Node{

    public final String value;
    public double pathCost;
    public Edge[] adjacencies;
    public Node parent;

    public Node(String val){

        value = val;

    }

    public String toString(){
        return value;
    }

}

class Edge{
    public final double cost;
    public final Node target;

    public Edge(Node targetNode, double costVal){
        cost = costVal;
        target = targetNode;

    }
}