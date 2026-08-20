// import java.util.*;
// public class Main{

//     //queue by array
//     // static class Queue{
//     //     static int arr[];
//     //     static int size;
//     //     static int rear;

//     //      Queue(int n ){
//     //        arr = new int[n];
//     //        size = n;
//     //        rear = -1;
//     //     }

//     //     public static boolean QisEmpty(){
//     //         return rear == -1;
//     //     }

//         //add
//         //  public static void Qadd(int n){
//         //     if(rear == size-1){
//         //         System.out.println("queue is full");
//         //         return;
//         //     }

//         //     rear = rear +1;
//         //     arr[rear] = n;
//         //  }

//          //remove 
//         //  public static void Qremove(){
//         //     if(QisEmpty()){
//         //         System.out.println("Queue is empty");
//         //         return;
//         //     }

//         //     int front = arr[0];
//         //     for(int i = 0; i<rear ;i++){
//         //         arr[i] = arr[i+1];
                
//         //     }
//         //     rear = rear - 1;
//         //     System.out.println(front+" remove ");
//         //  }

//          //peek
//     //      public static int Qpeek(){
//     //         if(QisEmpty()){
//     //             System.out.println("Queue is empty");
//     //             return -1;
//     //         }
//     //         return arr[0];
//     //      }
//     // }





//     //circular queue by array
//     // static class CircularQueue{
//     //     static int arr[];
//     //     static int size;
//     //     static int rear;
//     //     static int front;

//     //      CircularQueue(int n ){
//     //        arr = new int[n];
//     //        size = n;
//     //        rear = -1;
//     //        front = -1;
//     //     }

//     //     public static boolean isEmpty(){
//     //         return rear == -1 && front == -1;
//     //     }

//     //     public static boolean isFull(){
//     //         return (rear+1)%size == front;
//     //     }

//         //add
//         //  public static void add(int n){
//         //     if(isFull()){
//         //         System.out.println("queue is full");
//         //         return;
//         //     }
//         //     if(front == -1){
//         //         front =0;
//         //     }
//         //     rear = (rear +1) % size;
//         //     arr[rear] = n;
//         //  }

//          //remove 
//         //  public static void remove(){
//         //     if(isEmpty()){
//         //         System.out.println("Queue is empty");
//         //         return;
//         //     }

//         //     int result = arr[front];
            
//         //     //last element
//         //     if(rear == front){
//         //         rear = front = -1;
//         //     }
//         //     else{
//         //         front = (front+1) % size;
//         //     }
//         //     System.out.println(result +" remove ");
//         //  }

//          //peek
//     //      public static int peek(){
//     //         if(isEmpty()){
//     //             System.out.println("Queue is empty");
//     //             return -1;
//     //         }
//     //         return arr[front];
//     //      }
//     // } 




//     //queue by linked list
//     // static class Node{
//     //     int data;
//     //     Node next;

//     //     Node(int data){
//     //         this.data = data;
//     //         this.next = null; 
//     //     }
//     // }
//     // static class Queue{
       
//     //     static Node head = null;
//     //     static Node tail = null;

//     //     public static boolean isEmpty(){
//     //         return tail == null && head == null;
//     //     }

//         //add
//         //  public static void add(int data){
//         //    Node newNode = new Node(data);
//         //    if(head == null){
//         //     head = tail = newNode;
//         //     return;
//         //    }
//         //    tail.next = newNode;
//         //    tail = newNode;
//         //  }

//          //remove 
//         //  public static void remove(){
//         //     if(isEmpty()){
//         //         System.out.println("Queue is empty");
//         //         return;
//         //     }
//         //     int result = head.data;
            
//         //     //single element
//         //     if(head==tail){
//         //         head = tail = null;
//         //     }else{
//         //         head = head.next;
//         //     }
//         //  }

//          //peek
//     //      public static int peek(){
//     //         if( isEmpty()){
//     //             System.out.println("Queue is empty");
//     //             return -1;
//     //         }
//     //         return head.data;
//     //      }
//     // }



//     //queue by using 2 stacks add operation
//     public class QueueS{
//         static Stack<Integer> s1 = new Stack<>();
//         static Stack<Integer> s2 = new Stack<>();

//         public static boolean isEmpty(){
//             return s1.isEmpty();
//         }

//         //add
//         public static void add(int data){
//             while(!s1.isEmpty()){
//                 s2.push(s1.pop());
//             }

//             s1.push(data);

//             while(!s2.isEmpty()){
//                 s1.push(s2.pop());
//             }

//         }

//         //remove
//         public static int remove(){
//             if(s1.isEmpty()){
//                 System.out.println("empty");
//                 return -1;
//         }
//         return s1.pop();
//         }


//         //peek
//         public static int peek(){
//             if(s1.isEmpty()){
//                 System.out.println("empty");
//                 return -1;
//         }
//           return s1.peek();
//     }
//     }


//     //stack by using 2 queue , remove opertion
//     static class stack{
//        static Queue<Integer> q1 = new LinkedList();
//        static Queue<Integer> q2 = new LinkedList();

//        public static boolean  isEmpty(){
//         return q1.isEmpty() && q2.isEmpty();
//        }

//        //add 
//        public static void push(int data){
//          if(!q1.isEmpty()){
//             q1.add(data);
//          }else{
//             q2.add(data);
//          }
//        }


//        //remove
//        public static int pop(){
//         if(isEmpty()){
//             System.out.print("empty");
//             return -1;
//         }
//         int top = -1;

//         //case 1
//         if(!q1.isEmpty()){
//             while(!q1.isEmpty()){
//                 top = q1.remove();
//                 if(q1.isEmpty()){
//                     break;
//                 }
//                 q2.add(top);
//             }
//         }
//         else{ // case 2 
//             while(!q2.isEmpty()){
//                 top = q2.remove();
//                 if(q2.isEmpty()){
//                     break;
//                 }
//                 q1.add(top);
//             }

//             }
//             return top;
//        }
       

//        //peek
//        //remove
//        public static int peek(){
//         if(isEmpty()){
//             System.out.print("empty");
//             return -1;
//         }
//         int top = -1;

//         //case 1
//         if(!q1.isEmpty()){
//             while(!q1.isEmpty()){
//                 top = q1.remove();
//                 q2.add(top);
//             }
//         }
//         else{ // case 2 
//             while(!q2.isEmpty()){
//                 top = q2.remove();
//                 q1.add(top);
//             }

//             }
//             return top;
//        }
//     }

//     public static void main(String[] args) {
//         // Queue q = new Queue(5);
//         // q.remove();
//         // q.add(1);
//         // q.add(2);
//         // q.add(3);
//         // q.add(4);
//         // q.add(5);
//         // System.err.println(q.peek());
//         //   q.remove();  q.remove();  q.remove();  q.remove();  q.remove();
//         // System.err.println(q.peek());
//         // CircularQueue q = new CircularQueue(3);
//         // q.add(1);
//         // q.add(2);
//         // q.add(3);
//         // q.remove();
//         // q.add(4);
//         // q.remove();
//         // q.add(5);
//         // while(!q.isEmpty()){
//         //     System.out.println(q.peek());
//         //     q.remove();
//         // }
//         Stack s = new Stack();
//         s.push(1);
//         s.push(2);
//         s.push(3);

//         while(!s.isEmpty()){
//             System.out.println(s.peek());
//             s.pop();
//         }
//     }
// }


public class Main{

    static class Queue{
        static int arr[];
        static int size;
        static int rear;
        static int front;

        Queue(int n){
           arr = new int[n];
           size = n;
           rear = -1;
           front = -1;
        }


        public static boolean isEmpty(){
           return rear == -1 && front == -1;
        }

        //full
        public static boolean  full() {
            return (rear+1)%size == front;
        }

        //add
        public static void add(int data){
          if(full()){
            System.out.println("Queue is full");
            return;         
          }
          //add 1st
          if(front == -1){
            front = 0;
          }
          rear = (rear + 1) % size;
          arr[rear] = data;
        }

        //remove
        public static int remove(){
            if(isEmpty()){
                System.out.println("Queue empty");
                return -1;
            }

            int front = arr[0];
            for (int i = 0; i < rear; i++) {
                arr[i] = arr[i+1];
            }
            rear--;
            return front;
        }
        //in o(1)
        public static int removeop(){
            if(isEmpty()){
                System.out.println("Queue empty");
                return -1;
            }

            int res = arr[front];
            
            //last el delete
            if(rear==front){
                rear = front = -1;
            }else {
                front = (front + 1)%size;
            }
            return res;
        }

        //peek
        public static int peek() {
            if(isEmpty()){
                System.out.println("Queue empty");
                return -1;
            }

            return arr[front];
        }
    }
    public static void main(String[] args) {
        Queue q = new Queue(5);
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        while(!q.isEmpty()){
            System.out.println(q.peek());
            q.removeop();
        }
       
    }
}