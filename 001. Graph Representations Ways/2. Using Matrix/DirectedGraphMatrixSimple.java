import java.util.*;

public class DirectedGraphMatrixSimple {
    
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
    private int[][] matrix;
    private int numVertices;

    public SimpleGraph(int V) {
        numVertices = V;
        matrix = new int[V][V]; 
    }

    public void addEdge(int source, int destination) {
        if (source >= 0 && source < numVertices && destination >= 0 && destination < numVertices) {
            matrix[source][destination] = 1;
        }
    }

    public void printGraph() {
        System.out.println("--- Adjacency Matrix ---");
        
        System.out.print("  ");
        for (int k = 0; k < numVertices; k++) {
            System.out.print(k + " ");
        }
        System.out.println();
        
        for (int i = 0; i < numVertices; i++) {
            System.out.print(i + " "); 
            System.out.print("|");
            
            String neighbors = "";
            for (int j = 0; j < numVertices; j++) {
                System.out.print(matrix[i][j] + " ");
                if (matrix[i][j] == 1) {
                    neighbors += j + " ";
                }
            }
            
            System.out.print("| -> " + i + " : ");
            if (neighbors.isEmpty()) {
                System.out.print("NULL");
            } else {
                System.out.print(neighbors.trim());
            }
            System.out.println();
        }
        System.out.println("------------------------");
    }
    
    public void totalNodes() {
        System.out.println("Total Nodes: " + numVertices);
    }
    
    public void totalEdges() {
        int edgeCount = 0;
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                edgeCount += matrix[i][j];
            }
        }
        System.out.println("Total Edges: " + edgeCount);
    }
}
