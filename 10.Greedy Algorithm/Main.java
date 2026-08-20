import java.util.*;
public class Main{


    //Activity Selector
    public static void ActivitySelector(int start[], int end[]){
    //   int max = 0;
    //   ArrayList<Integer> li = new ArrayList<>();
    //   li.add(0);
    //   max = 1;
    //   int lastend = end[0];
    //   for(int i=1; i<end.length; i++){
    //     if(start[i]>= lastend){
    //         max++;
    //         li.add(i);
    //         lastend = end[i];
    //     }
    //   }
    //  System.out.println(max);
    //  for(int i=0; i<li.size();i++){
    //     System.out.print("A"+li.get(i)+" ");
    //  }
      
      int activities[][] = new int[start.length][3];
      for(int i=0;i<start.length;i++){
        activities[i][0] = i;
        activities[i][1] = start[i];
        activities[i][2]= end[i];
      }

      Arrays.sort(activities, Comparator.comparingDouble(o -> o[2]));
      
      int max = 0;
      ArrayList<Integer> li = new ArrayList<>();

      li.add(activities[0][0]);

      max = 1;
      int lastend = activities[0][2];
      for(int i=1; i<end.length; i++){
        if(activities[i][1]>= lastend){
            max++;
            li.add(activities[i][0]);
            lastend = activities[i][2];
        }
      }
     System.out.println(max);
     for(int i=0; i<li.size();i++){
        System.out.print("A"+li.get(i)+" ");
     }

    }
    public static void main(String[] args){
       int start[] = {1,3,0,5,8,5};
       int end[]= {2,4,6,7,9,9};
       ActivitySelector(start, end);
    }
}