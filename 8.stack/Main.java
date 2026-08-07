// //stack using arraylist
// // import java.util.ArrayList;
// // import java.util.LinkedList;
// import java.util.*;

// public class Main{
//     // static class Stack{
//     //     static ArrayList<Integer> list = new ArrayList<>();
//     //     //isempty
//     //     public static boolean isEmpty(){
//     //         return list.size() == 0;
//     //     }

//     //     //push
//     //     public static void Push(int data){
//     //         list.add(data);
//     //     }

//     //     //pop
//     //     public static int Pop(){
//     //         if(isEmpty()){
//     //             return -1;
//     //         }
//     //         int top = list.get(list.size()-1);
//     //         list.remove(list.size()-1);
//     //         return top;
//     //     }

//     //     //peek
//     //     public static int peek(){
//     //         if(isEmpty()){
//     //             return -1;
//     //         }
//     //         return list.get(list.size()-1);
//     //     }


//     //     static class Node{
//     //        int data;
//     //        Node next;

//     //        Node(int data){
//     //         this.data = data;
//     //         this.next = null;
//     //        }
//     //     }

//     //     static class StackL{
//     //       static Node head = null;

//     //       public static boolean isEmpty(){
//     //         return head == null;
//     //       }

//     //     }


//     // }
//     public static void main(String[] args) {
//         Stack<Integer> s = new Stack();
//         s.push(3);
//         s.push(2);
//         s.push(10);

//         while(!s.isEmpty()){
//             System.out.println(s.peek());
//             s.pop();
//         }
//     }
// }


import java.util.*;

public class Main{
    
    //print
    public static void print(Stack<Integer> s) {
        while(!s.isEmpty()){
         int top = s.peek();
         System.out.println(top);
         s.pop();
        }
    }

    //Push at bottom 
    public static void pushatBottom(Stack<Integer> s, int data){
        if(s.isEmpty()){
           s.push(data);
           return;
        }
        int top = s.pop();
        pushatBottom(s, data);
        s.push(top);
    }
    

    //reverse string
    public static String reverse(String s){
       
       Stack<Character> sr = new Stack<>();
       int idx = 0;
       
       while(idx < s.length()){
        sr.push(s.charAt(idx));
        idx++;
       }

       StringBuilder res = new StringBuilder("");
       while(!sr.isEmpty()){
        char curr = sr.pop();
        res.append(curr); 
       }

       return res.toString();
    }


    //reverse stack
    public static void reverseStack(Stack<Integer> s){
        if(s.isEmpty()){
            return;
        }
        int top = s.pop();
        reverseStack(s);
        pushatBottom(s, top);
    }
    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);

        //pushatBottom(s,4);
       
        reverseStack(s);
        print(s);
        
    }
}