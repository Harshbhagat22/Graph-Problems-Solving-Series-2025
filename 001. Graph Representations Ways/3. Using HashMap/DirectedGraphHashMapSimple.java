import java.util.*;

public class DirectedGraphHashMapSimple {

    public static void main(String[] args) {
        SimpleGraph g = new SimpleGraph(); 

        g.addVertex("A");
        g.addVertex("B");
        g.addVertex("C");
        g.addVertex("D");
        g.addVertex("E");
        
        g.addEdge("B", "A");
        g.addEdge("B", "E");
        g.addEdge("C", "A");
        g.addEdge("C", "D");
        g.addEdge("D", "C");
        g.addEdge("E", "D");
        
        g.printGraph();
        System.out.println();
        g.totalNodes();
        g.totalEdges();
    }
}

class SimpleGraph {
    private HashMap<String, List<String>> adjList;

    public SimpleGraph() {
        adjList = new HashMap<>();
    }

    public void addVertex(String v) {
        adjList.putIfAbsent(v, new ArrayList<>());
    }

    public void addEdge(String v1, String v2) {
        if (adjList.containsKey(v1) && adjList.containsKey(v2)) {
            adjList.get(v1).add(v2);
        }
    }

    public void printGraph() {
        System.out.println("--- Adjacency List ---");
        
        for (String vertex : adjList.keySet()) {
            System.out.print(vertex + " : ");
            
            List<String> neighbors = adjList.get(vertex);
            
            if (neighbors.isEmpty()) {
                System.out.print("NULL");
            } else {
                for (String neighbor : neighbors) {
                    System.out.print(neighbor + " ");
                }
            }
            System.out.println();
        }
        System.out.println("----------------------");
    }
    
    public void totalNodes() {
        System.out.println("Total Nodes: " + adjList.size());
    }
    
    public void totalEdges() {
        int edgeCount = 0;
        
        for (List<String> neighbors : adjList.values()) {
            edgeCount += neighbors.size();
        }
        System.out.println("Total Edges: " + edgeCount);
    }
}
