import java.util.*;

public class DirectedGraphListSimple {

    public static void main(String[] args) {
        SimpleGraph g = new SimpleGraph(5); 

        g.addEdge(1, 0); 
        g.addEdge(1, 4); 
        g.addEdge(2, 0); 
        g.addEdge(2, 3); 
        g.addEdge(3, 2); 
        g.addEdge(4, 3); 
        
        g.printGraph();
        System.out.println();
        g.totalNodes();
        g.totalEdges();
    }
}

class SimpleGraph {
    private ArrayList<ArrayList<Integer>> adjList;
    private int numVertices;

    public SimpleGraph(int V) {
        numVertices = V;
        adjList = new ArrayList<>(V);
        
        for (int i = 0; i < V; i++) {
            adjList.add(new ArrayList<Integer>());
        }
    }

    public void addEdge(int source, int destination) {
        if (source >= 0 && source < numVertices && destination >= 0 && destination < numVertices) {
            adjList.get(source).add(destination);
        }
    }

    public void printGraph() {
        System.out.println("--- Adjacency List ---");
        
        for (int i = 0; i < numVertices; i++) {
            System.out.print(i + " : ");
            
            ArrayList<Integer> neighbors = adjList.get(i);
            
            if (neighbors.isEmpty()) {
                System.out.print("NULL");
            } else {
                for (int neighbor : neighbors) {
                    System.out.print(neighbor + " ");
                }
            }
            System.out.println();
        }
        System.out.println("----------------------");
    }
    
    public void totalNodes() {
        System.out.println("Total Nodes: " + numVertices);
    }
    
    public void totalEdges() {
        int edgeCount = 0;
        
        for (int i = 0; i < numVertices; i++) {
            edgeCount += adjList.get(i).size();
        }
        System.out.println("Total Edges: " + edgeCount);
    }
}
