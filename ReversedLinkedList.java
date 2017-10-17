/*
  -Reverse Linked List:-
  
  Input : Head of following linked list  
       1->2->3->4->NULL
  Output : Linked list should be changed to,
       4->3->2->1->NULL
*/
import static java.lang.System.out;

class Node{
    int data;
    Node next;
    
    public Node(int data){
        this.data=data;
        next=null;
    }
}


public class ReversedLinkedList {
    
    // Method that perform reverse operation
    static Node ReverseLinkedList(Node head){
      
        if(head==null) return null;
        
        Node temp=head;
       
        //make current to next
        Node current=temp.next;
        //make next to current
        Node next= temp;
        // first element become last, and lastNode.next=null 
        temp.next=null;
    
        while(current!=null && next!=null){
           temp=current;
           current= temp.next;
           temp.next=next;
           next=temp;
            
        }
        return temp;
    }
    
    static void  print(Node head){
        Node temp=head;
        while(temp!=null){
            out.print(temp.data+" ");
            temp=temp.next;
        }
    }
    
    public static void main(String args[]) {
        Node root= new Node(1);
        root.next=new Node(2);
        root.next.next=new Node(3);
        root.next.next.next=new Node(4);;
        
        //list before reversing
        print(root);
        System.out.println();
        
        root= ReverseLinkedList(root);
        
        //list After Reversing
        System.out.println();
        print(root);
    }
}
