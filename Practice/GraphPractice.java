import java.util.*;
public class GraphPractice{

    public static class Edges{
    int curr;
    int des;
    
    public Edges(int st, int des){
        this.curr = st;
        this.des = des;
       }
    }


    public static void Create(ArrayList<Edges> [] graph){
      for (int i = 0; i < graph.length; i++) {
          graph[i]= new ArrayList<>();
      }

      graph[0].add(new Edges(0,1));
      graph[0].add(new Edges(0,2));
      
      graph[1].add(new Edges(1,0));
      graph[1].add(new Edges(1,3));

      graph[2].add(new Edges(2,0));
      graph[2].add(new Edges(2,4));
      
      
      graph[3].add(new Edges(3,1));
      graph[3].add(new Edges(3,5));
      
      graph[4].add(new Edges(4,2));
      graph[4].add(new Edges(4,5));

      graph[5].add(new Edges(5,3));
    //   graph[5].add(new Edges(5,6));

      graph[6].add(new Edges(6,5));
      

    }

    //print graph
    public static void print(ArrayList<Edges> [] graph) {
      // neighbours
      
      for (int cur = 0; cur < graph.length; cur++) {
             System.out.print(cur+" ->");
         for (int j = 0; j < graph[cur].size(); j++) {
             Edges e = graph[cur].get(j);
        
             System.out.print(e.des+" ");
         }
         System.out.println("");
          
      }        
    }


    //bfs 
    public static void bfsgraph(ArrayList<Edges> [] graph) {
        boolean vis[] = new boolean[graph.length];
        Queue<Integer> q = new LinkedList<>();
        q.add(0);

        while(!q.isEmpty()){
            int curr = q.remove();
            
            if(!vis[curr]){
             System.out.println(curr);
             vis[curr] = true;
             for (int i = 0; i < graph[curr].size(); i++) {
                 Edges e = graph[curr].get(i);
                q.add(e.des);
             }
            }
        } 
    }

    //bfs connected
    public static void bfs(ArrayList<Edges> [] graph){
       boolean vis[] = new boolean[graph.length];
      
      

        for (int i = 0; i < graph.length; i++) {
            
            if(!vis[i]){
                bfsutil(graph,vis);
            }
        }
    }

    public static void bfsutil(ArrayList<Edges> [] graph, boolean [] vis) {
        Queue<Integer> q = new LinkedList<>();
        q.add(0);

        while(!q.isEmpty()){ 
            int curr = q.remove();
            if(!vis[curr]){
             System.out.println(curr);
             vis[curr] = true;
             for (int i = 0; i < graph[curr].size(); i++) {
                 Edges e = graph[curr].get(i);
                q.add(e.des);
             }
            }
        }
    }

    //dfs
    public static void dfsgraph(ArrayList<Edges> [] graph, int curr,boolean vis[]) {
        System.out.println(curr);
        vis[curr] = true;
      
        for (int i = 0; i < graph[curr].size(); i++) {
            Edges e = graph[curr].get(i);
            if(!vis[e.des]){
                dfsgraph(graph, e.des,vis);
            }
            
        }
    }

    public static void dfs(ArrayList<Edges> [] graph) {
        boolean vis[] = new boolean[graph.length];

        for (int i = 0; i < graph.length; i++) {
           if(!vis[i]){
            dfsutil(graph,i, vis);
           } 
        }
    }
    

    public static void dfsutil(ArrayList<Edges> [] graph, int curr,boolean vis[]) {
        System.out.println(curr);
        vis[curr] = true;
      
        for (int i = 0; i < graph[curr].size(); i++) {
            Edges e = graph[curr].get(i);
            if(!vis[e.des]){
                dfsgraph(graph, e.des,vis);
            }
            
        }
    }

    // has path
    public static boolean haspath(ArrayList<Edges> [] graph,int src, int des, boolean vis[]){
        if(src==des){
            return true;
        }
        
        vis[src] = true;

        for (int i = 0; i < graph[src].size(); i++) {
            Edges e = graph[src].get(i);
            
            if(!vis[e.des] && haspath(graph, e.des, des, vis)){
                return true;
            }
        }
      return false;
        
    }

    //cycle detect
    public static boolean  cycledetect(ArrayList<Edges>[] graph) {
        boolean vis[] = new boolean[graph.length];

        for (int i = 0; i < graph.length; i++) {
            if(!vis[i]){
                if(cycledetectutil(graph,i,-1, vis)){
                    return true;
                }
                
            }
        }
        return false;
    }

    public static boolean  cycledetectutil(ArrayList<Edges>[] graph, int cur, int par, boolean vis[]) {
       vis[cur] = true;
       
       for (int i = 0; i < graph[cur].size(); i++) {
            Edges e = graph[cur].get(i);
            if(!vis[e.des]){
                if(cycledetectutil(graph, e.des, cur, vis)){
                    return true;
                }
            }else if(vis[e.des] && e.des!=par){
               return true;
            }
           
       }
       return false;
    }

    public static void main(String[] args) {
    int vertex = 7;
    @SuppressWarnings("unchecked")
    ArrayList<Edges> [] graph = new ArrayList[vertex];
    Create(graph);
    //print(graph);
    //bfs(graph);
     //dfs(graph, 0,new boolean[vertex]);
     //System.out.println(haspath(graph, 5, 6, new boolean[vertex]));
     //bfs(graph);
     //dfs(graph);
     System.out.println(cycledetect(graph));
    }
}