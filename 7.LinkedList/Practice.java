public class Practice{
    public static class Node{
        int data;
        Node next;

        public Node(int data){
           this.data = data;
           this.next = null;
        }
    }

    public  Node head;
    public  Node tail; 
    //print ll
    public void printl(Node head){
      for(int i =1; i<= sizeof(head);i++){
         
      }        
    }

    //add starting
    public void addStart(int data){
         Node newNode = new Node(data);
        if(head== null ){
           head = tail = newNode;
           return;
        }
     
      newNode.next = head;

     head = newNode;
    }
    public static void main(String[] args) {
        Practice ll = new Practice();
        ll.head = new Node(3);
        ll.head.next = new Node(4);

    }
}