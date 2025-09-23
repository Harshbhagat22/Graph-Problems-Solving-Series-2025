import java.util.*;
public class GraphImplementation {
    // drive code
    public static void main(String args[]){
        Graph g = new Graph();
        g.addVertex(1);
        g.addVertex(2);
        g.addVertex(3);
        
        g.addEdge(1,2);
        g.addEdge(1,3);
        g.addEdge(2,3);
        g.addEdge(2,1);
        g.addEdge(3,1);
        g.addEdge(3,2);
        
        g.printGraph();
    }
}

class Graph {
    Map<Integer,List<Integer>>maplist;
    
        public Graph(){
            maplist = new HashMap<>();
        }
        
        public void addVertex(int vertex){
            maplist.putIfAbsent(vertex, new ArrayList<>());
        }
        
        public void addEdge(int v1 , int v2){
            maplist.putIfAbsent(v1, new ArrayList<>());
            maplist.get(v1).add(v2);
        }
        
        public void printGraph(){
            for(Integer key : maplist.keySet()){
                System.out.print(key + " : ");
                List<Integer> temp = maplist.get(key);
                    for(int buff : temp){
                        System.out.print(buff+" ");
                    }
                    
                System.out.println();
            }
        }
        
}