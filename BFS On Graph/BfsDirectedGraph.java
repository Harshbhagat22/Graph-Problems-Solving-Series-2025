import java.util.*;
public class BfsDirectedGraph {
    public static void main(String[]args){
        Graph g = new Graph();
        // Add Vertex
        
        g.addVertex("A");
        g.addVertex("B");
        g.addVertex("C");
        g.addVertex("D");
        g.addVertex("E");
        
        // Add Edge..
        
        g.addEdge("B", "A");
        g.addEdge("B", "E");
        g.addEdge("C", "A");
        g.addEdge("C", "D");
        g.addEdge("D", "C");
        g.addEdge("E", "D");
        
        // Display Graph..
        g.printGraph();
        System.out.println();
        System.out.println("BFS Sequence :");
        g.bfs("B");
    }
}

class Graph {
    HashMap<String,List<String>>graph;
        public Graph(){
            graph = new HashMap<>();
        }
        
        public void addVertex(String v){
            graph.putIfAbsent(v,new ArrayList<>());
        }
        
        public void addEdge(String v1, String v2){
            graph.get(v1).add(v2);
        }
        
        public void printGraph(){
            for(String key : graph.keySet()){
                System.out.print(key+" : ");
                List<String> temp = graph.get(key);
                if(temp.isEmpty())System.out.print("NULL");
                    for(String buff : temp){
                        System.out.print(buff+" ");
                    }
                    
                System.out.println();
            }
        }
        
        public void bfs(String v){
            Set<String> visited = new HashSet<>();
            Queue<String> q = new LinkedList<>();
                visited.add(v);
                q.offer(v);
                    while(!q.isEmpty()){
                        String node = q.poll();
                        System.out.print(node +" ");
                        
                        List<String> temp = graph.get(node);
                            for(String buff : temp){
                                if(!visited.contains(buff)){
                                    q.offer(buff);
                                    visited.add(buff);
                                }
                            }
                    }
        }
}