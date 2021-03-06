/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
//import java.util.List;

/**
 *
 * @author mjhussa3
 */

public class Node {
    private String name;
    private int depthlevel;
    private ArrayList<Node> adjacenciesList;
    private int number;
    
    public Node(String name, int number){
        this.name = name;
        this.number = number;
        this.adjacenciesList = new ArrayList<>();
    }
    
    public void addNeighbour(Node node){
        this.adjacenciesList.add(0, node);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDepthlevel() {
        return depthlevel;
    }

    public void setDepthlevel(int depthlevel) {
        this.depthlevel = depthlevel;
    }

    public ArrayList<Node> getAdjacenciesList() {
        return adjacenciesList;
    }

    public void setAdjacenciesList(ArrayList<Node> adjacenciesList) {
        this.adjacenciesList = adjacenciesList;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
    
    @Override 
    public String toString(){
        return this.name;
    }

 
    
}