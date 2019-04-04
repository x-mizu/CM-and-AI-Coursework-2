

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Stack;

/**
 *
 * @author mjhussa3
 */
public class IterativeDeepening {
    
    private Node targetNode;
    private Node targetNode2;
    private boolean isTargetFound;
    
    public IterativeDeepening(Node targetNode, Node targetNode2){
        this.targetNode = targetNode;
        this.targetNode2 = targetNode2;
    }
    
    public void runDeepeningSearch(Node startNode){
        
        int depth = 0;
        
        while( !isTargetFound){
            System.out.println("K : " + depth);
            dfs(startNode,depth);
            depth++;
        }
    }
    
    private void dfs(Node startNode, int depth){
        
        Stack<Node> stack = new Stack<>();
        startNode.setDepthlevel(0);
        stack.push(startNode);
        
        while(!stack.isEmpty() ){
            Node actualNode;
            actualNode = stack.pop();
            System.out.println(actualNode+ " ");
            
            if( actualNode.getName().equals(this.targetNode.getName()) || actualNode.getName().equals(this.targetNode2.getName())){
                System.out.println("\nNode has been found...");
                this.isTargetFound=true;
                return;
            }
            
            if( actualNode.getDepthlevel() >= depth){
                continue;
            }
            
            for(Node node : actualNode.getAdjacenciesList()){
                node.setDepthlevel(actualNode.getDepthlevel()+1);
                stack.push(node);
            }
        }
    }
    }