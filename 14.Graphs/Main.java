import java.util.*;
public class Main{
    

    // create graph by array of arraylist
    public static class Edges{
        int st;
        int en;
        int wt;

       

        public Edges(int s,int e,int wt){
            this.st = s;
            this.en = e;
            this.wt = wt;
        }
    }

    public static void create(int vertex, ArrayList<Edges>[] graph) {
        for(int i=0;i<vertex;i++){
            graph[i] = new ArrayList<>();
        }
        // 0
        // graph[0].add(new Edges(0, 1, 0));
        // graph[0].add(new Edges(0, 2, 0));

        //1
        // graph[1].add(new Edges(1, 0, 0));
        // graph[1].add(new Edges(1, 3, 0));

        //2
        graph[2].add(new Edges(2, 3, 0));
        //graph[2].add(new Edges(2, 4, 0));

        //3
        graph[3].add(new Edges(3, 1, 0));
        //graph[3].add(new Edges(3, 4, 0));
        // graph[3].add(new Edges(3, 5, 1));

        //4
        graph[4].add(new Edges(4, 0, 0));
        graph[4].add(new Edges(4, 1, 0));

        //5
        graph[5].add(new Edges(5, 0, 1));
        graph[5].add(new Edges(5, 2, 1));
        // graph[5].add(new Edges(5, 6, 1));

        //6
        //graph[6].add(new Edges(6, 5, 1));


        //  for (int i = 0; i < graph[2].size(); i++) {
        //      //Edges e = graph[2].get(i); 
        //      //System.out.println(e.en);
        //  }
    }


    //bfs
    // public static void bfs( ArrayList<Edges>[] graph) {
    //     Queue<Integer> q = new LinkedList<>();
    //     boolean vis[] = new boolean[graph.length];
    //     q.add(0);

    //     while(!q.isEmpty()){
    //         int curr = q.remove();

    //         if(!vis[curr]){
    //             System.out.print(curr+" ");
    //             vis[curr]= true;
    //             for(int i=0;i<graph[curr].size();i++){
    //                Edges e = graph[curr].get(i);
    //                q.add(e.en);
    //             }

    //         }
    //     }
        
    // }
       

    //connected compoenents
    public static void bfs(ArrayList<Edges>[] graph) {
          boolean vis[] = new boolean[graph.length];

          for (int i = 0; i < graph.length; i++) {
              if(!vis[i]){
                bfsutil(graph, vis);
              }
          }
    }

    public static void bfsutil( ArrayList<Edges>[] graph, boolean  vis[]) {
        Queue<Integer> q = new LinkedList<>();
        q.add(0);

        while(!q.isEmpty()){
            int curr = q.remove();

            if(!vis[curr]){
                System.out.print(curr+" ");
                vis[curr]= true;
                for(int i=0;i<graph[curr].size();i++){
                   Edges e = graph[curr].get(i);
                   q.add(e.en);
                }

            }
        }
        
    }



    //dfs
    // public static void dfs(ArrayList<Edges> [] graph,int curr, boolean vis[]) {
    //     System.out.print(curr+" ");
    //     vis[curr]= true;

    //     for (int i = 0; i < graph[curr].size(); i++) {
    //         Edges e = graph[curr].get(i);
    //         if(!vis[e.en]){
    //             dfs(graph, e.en, vis);
    //         }
            
    //     }
    // }



      //connected component dfs
      public static void dfs(ArrayList<Edges> [] graph) {
          boolean vis[]= new boolean[graph.length];
          
          for (int i = 0; i < graph.length; i++) {
              if(!vis[i]){
                dfsutil(graph, i, vis);
              }
          }
      }
      public static void dfsutil(ArrayList<Edges> [] graph,int curr, boolean vis[]) {
        System.out.print(curr+" ");
        vis[curr]= true;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edges e = graph[curr].get(i);
            if(!vis[e.en]){
                dfsutil(graph, e.en, vis);
            }
            
        }
    }

    //haspath
    public static boolean hasPath(ArrayList<Edges>[] graph,int sr, int des, boolean  vis[]) {
        if(sr==des){
            return true;
        }

        vis[sr]= true;

        for (int i = 0; i < graph[sr].size(); i++) {
            Edges e = graph[sr].get(i);
            if(!vis[e.en] && hasPath(graph, e.en, des, vis)){
                return true;
            }
        }
        
        return false;
    }


    //detect cycle
    public static boolean  detectCycle(ArrayList<Edges>[] graph) {
        boolean vis[] = new boolean[graph.length];

        for (int i = 0; i < graph.length; i++) {
            if(!vis[i]){
                if(detectCycleutil(graph,vis,i,-1)){
                    return true;
                }
            }
        }
        return false;
    } 
    
    public static boolean detectCycleutil(ArrayList<Edges>[] graph,boolean vis[],int curr,int par) {
        vis[curr]= true;
        for (int idx = 0; idx < graph[curr].size(); idx++) {
            Edges e = graph[curr].get(idx);
            if(!vis[e.en]){
                if(detectCycleutil(graph, vis, e.en, curr)){
                    return true;
                }
            }
            else if(vis[e.en] && e.en!=par){
                return true;
            } 
        }
        return false; 
    }


    //bipartite graph
    public static boolean  bipartite(ArrayList<Edges>[] graph) {
        int col[] = new int[graph.length];
        for (int i = 0; i < col.length; i++) {
            col[i]= -1; //no color
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < graph.length; i++) {
            if(col[i]==-1){
              q.add(i);
              col[i]=0;
              while(!q.isEmpty()){
                int curr = q.remove();
                for (int k = 0; k < graph[curr].size(); k++) {
                  Edges e = graph[curr].get(k);
                  if(col[e.en]== -1){
                     int nextcol = col[curr] == 0 ? 1 : 0;
                     col[e.en]= nextcol;
                     q.add(e.en);
                  }else if (col[e.en]== col[curr]){
                    return false;
                  }
                    
                }
              }
            }
            
        }
        return true;
    }
    

    //directed graph cycle detect
    public static boolean  isCycle(ArrayList<Edges>[] graph) {
      boolean vis[] = new boolean[graph.length];
      boolean stack[] = new boolean[graph.length];

      for (int i = 0; i < graph.length; i++) {
          if(!vis[i]){
            if(isCycleutil(graph,i,vis,stack)){
                return true;
            }
          }
      }   
      return false;     
    }

    public static boolean isCycleutil(ArrayList<Edges>[] graph, int curr, boolean vis[], boolean stack[]) {
        vis[curr] = true;
        stack[curr] = true;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edges e = graph[curr].get(i);
            if(stack[e.en]){
                return true;
            }
            else if(!vis[e.en] && isCycleutil(graph, e.en, vis, stack)){
                return true;
            }
        }
        stack[curr]= false;
        return false;
    }
    

    //topological sorting
    public static void topoSort(ArrayList<Edges> [] graph) {
        boolean vis[] = new boolean[graph.length];
        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < graph.length; i++) {
            if(!vis[i]){
                topoSortutil(graph,i,vis,s);
            }
        }

        while(!s.isEmpty()){
            System.out.print(s.pop()+" ");
        }
        
    }
    
    public static void topoSortutil(ArrayList<Edges> [] graph,int st,boolean vis[], Stack<Integer> s) {
        vis[st]= true;
        for (int i = 0; i < graph[st].size(); i++) {
            Edges e = graph[st].get(i);
            if(!vis[e.en]){
                topoSortutil(graph,e.en,vis,s);
            }
        }
        s.push(st);        
    }


    //printallPath
    public static void printAllPath(ArrayList<Edges>[] graph,int src, int des,String path){
      if(src==des){
        System.out.println(path+des);
        return;
      }

      for (int i = 0; i < graph[src].size(); i++) {
          Edges e = graph[src].get(i);
          printAllPath(graph, e.en, des, path+src);
          
      }
    }

    public static void main(String[] args) {
        //int vertex = 5;
        //@SuppressWarnings("unchecked")
        //ArrayList<Edges>[] graph = new ArrayList[vertex];
        //create(vertex, graph);
        // //bfs(graph);
        // // System.out.println("");
        // //dfs(graph);
        // // System.out.println(hasPath(graph, 0, 6, new boolean[vertex]));
        // System.out.println(isCycle(graph));
        //topoSort(graph);
        //String path ="";
        //printAllPath(graph, 2, 4, path);
            
    }
}