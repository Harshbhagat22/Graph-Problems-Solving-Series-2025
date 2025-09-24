# Graph-Problems-Solving-Series-2025
## Graph Used : 
<img width="818" height="373" alt="image" src="https://github.com/user-attachments/assets/4bbc7f13-53d0-4b5f-8be3-5185a49a35e5" />


## Graph Class :


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
    }

## GRAPH OUTPUT : 
<img width="426" height="262" alt="image" src="https://github.com/user-attachments/assets/71dfd93f-c3ec-41ce-b433-2f07c34b26ed" />

