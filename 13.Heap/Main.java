//import java.util.PriorityQueue;
//import java.util.Comparator;
import java.util.*;

public class Main{
    static class Student implements Comparable<Student> {
     String name;
     int rank;

     public Student(String name, int rank){
       this.name = name;
       this.rank = rank;
     }    
     @Override
     public int compareTo(Student s2){
        return this.rank - s2.rank;
     }
} 

static class heap{
  ArrayList<Integer> arr = new ArrayList<>();

  public void add(int data){
    arr.add(data);

    int x = arr.size()-1;
    int par = (x-1)/2;

    while(arr.get(x) < arr.get(par)){
        int temp = arr.get(x);
        arr.set(x, arr.get(par));
        arr.set(par,temp);
    }
  }

  public int peek(){
    return arr.get(0);
  }
}


  public static void main(String[] args) {
    // PriorityQueue <Student> pq = new PriorityQueue<>();
    //      pq.add(new Student("A",1));
    //      pq.add(new Student("D",4));
    //      pq.add(new Student("C",3));
    //      pq.add(new Student("B",2));

    //    while(!pq.isEmpty()){
    //     System.out.println(pq.peek().name + "->" + pq.peek().rank);
    //     pq.remove();
    //    }

    heap hp = new heap();
    hp.add(3);
    hp.add(15);
    hp.add(13);
    hp.add(1);
    System.out.println(hp.peek());
    
   }
}