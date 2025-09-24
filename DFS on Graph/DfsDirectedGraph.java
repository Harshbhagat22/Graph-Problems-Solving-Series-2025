import java.util.*;
public class DfsDirectedGraph {
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
        System.out.println("DFS Sequence : ");
        g.dfs("B");
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
        
        public void dfs(String v){
            Set<String>visited = new HashSet<>();
            Stack<String>s = new Stack<>();
                s.push(v);
                    while(!s.isEmpty()){
                        String curr = s.pop();
                            if(!visited.contains(curr)){
                                visited.add(curr);
                                System.out.print(curr+" ");
                                
                                List<String> temp = graph.get(curr);
                                    if(temp != null){
                                        for(int i = temp.size() - 1; i>=0; i--){
                                            if(!visited.contains(temp.get(i))){
                                                    s.push(temp.get(i));
                                            }
                                                }
                                   }
                            }
                            
                    }
        }
}