public class Main2{
    public class Node{
        int data;
        Node next;

        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    public static Node head;
    public static Node tail;

     //add
    public void addFirst(int data) {
        //O(1)
        //step1 -create new node
        Node newNode = new Node(data);

        if (head == null) {
            head = tail = newNode;
            return;
        }

        //step 2-newNode next = head
        newNode.next = head;

        // step 3- head = newNode
        head = newNode;
    }


    //print
     public void print() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println("null");
    }
    
    //detect cycle or loop
    public boolean detect(){
        Node slow = head;
        Node fast = head;
        while(fast!= null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                return true;
            }
        }
        return false;
    }

    //remove cycle or loop
    public static void removeCycle(){
        //detect loop
        Node slow = head;
        Node fast = head;
        boolean cycle = false;
        while(fast!= null && fast.next!=null){
            slow = slow.next;
            fast= fast.next.next;
            if(slow == fast){
                cycle = true;
                break;
            }
        }
        if(cycle==false){
            return;
        }

        //find meeting node
        slow = head;
        Node prev = null; //last node
        while(slow!=fast){
            prev = fast;
            slow = slow.next;
            fast = fast.next;
        }

        //remove cycle
        prev.next = null;
    }

    //merge sort
    public Node mid(Node head){
       Node slow = head;
        Node fast = head.next;
        while(fast!= null && fast.next!= null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private Node merge(Node head1,Node head2){
        Node mergedLL = new Node(-1);
        Node temp = mergedLL;

        while(head1 !=null && head2 != null)
        {
            if(head1.data <= head2.data){
                temp.next = head1;
                head1 = head1.next;
                temp = temp.next;
            }else{
                temp.next = head2;
                head2 = head2.next;
                temp = temp.next;
            }
        }

        while(head1 != null){
            temp.next = head1;
            head1 = head1.next;
            temp = temp.next;
        }

        while(head2 != null){
            temp.next = head2;
            head2 = head2.next;
            temp = temp.next;
        }

        return mergedLL.next;
    }

    public Node mergeSort(Node head) {
        if(head == null || head.next == null){
          return head;
        }
        //find mid
        Node findmid = mid(head);
        //left right mid
        Node rigmid = findmid.next;
        findmid.next = null;
         Node newleft = mergeSort(head);
        Node newright = mergeSort(rigmid);

        // merge
        return merge(newleft,newright);   
    }

    //zig zag
    public void zigZag(){
        //find mid
        Node slow = head;
        Node fast = head.next;
        while(fast!=null && fast.next!= null){
            slow = slow.next;
            fast = fast.next.next;
        }
        Node mid = slow;
        //reverse 2nd half
         Node curr = mid.next;
         mid.next = null;
         Node prev = null;
         Node next;

         while(curr!= null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
         }
         Node left = head;
         Node right = prev;
         Node nextl,nextr;
        //alternate merge
         while(left!= null && right!=null){
            nextl=left.next;
            left.next = right;
            nextr= right.next;
            right.next = nextl;

            left = nextl;
            right = nextr;

         }
    }


    //doubly linked list
    


    public static void main(String[] args) {
      Main2 ll = new Main2();
      //head = ll.new Node(1);
      //Node temp =ll. new Node(2);
      //head.next=temp;
      //head.next.next= ll.new Node(3);
      //head.next.next.next = temp;
      //ll.print();
      //System.out.println(ll.detect());
      //ll.removeCycle();
      //System.out.println(ll.detect());
      ll.addFirst(6);
      ll.addFirst(5);
      ll.addFirst(3);
      ll.addFirst(6);
      ll.addFirst(7);
      ll.addFirst(2);
      //ll.print();
      ll.mergeSort(head);
      ll.print();
      ll.zigZag();
      ll.print();


    }
}