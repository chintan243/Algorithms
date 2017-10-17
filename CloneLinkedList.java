/*
  -Copy(Clone) Linked List:-
*/
import static java.lang.System.out;
import java.util.*;

class Node{
    int data;
    Node next;
    Node rand;
    
    public Node(int data){
        this.data=data;
        next=null;
        rand=null;
    }
}


public class CloneLinkedList {
    
    static void  print(Node head){
        Node temp=head;
        while(temp!=null){
            out.println(temp.data+" "+temp.rand.data);
            temp=temp.next;
        }
    }
    
    
    static Node cloneLinkedList(Node head){
        if(head==null) return null;
        
        HashMap<Node,Node> map= new HashMap<>();
        
        Node current=head;
        Node newHead= new Node(current.data);
        Node start=newHead;
        
        map.put(current,newHead);
        
        //create copy linkedList from original LinkedList
        while(current.next !=null){
            int cdata=current.next.data;
            newHead.next= new Node(cdata);
            
            map.put(current.next,newHead.next);
            
            newHead= newHead.next;
            current=current.next;
        }
        
        //Assign random pointer
        current=head;
        newHead=start;
        while(current!=null){
            Node temp= map.getOrDefault(current.rand,null);
            if(temp!=null)
                newHead.rand=temp;
            current= current.next;
            newHead= newHead.next;
            
        }
        
        return start;
    }
    
    public static void main(String args[]) {
        Node root= new Node(1);
        root.next=new Node(2);
        root.next.next=new Node(3);
        root.next.next.next=new Node(4);
        root.next.next.next.next=new Node(5);
        
        root.rand=root.next.next;
        root.next.rand= root;
        root.next.next.rand=root.next.next.next.next;
        root.next.next.next.rand= root.next.next;
        root.next.next.next.next.rand= root.next;
        
        
        //root= ReverseLinkedList(root);
        Node head=cloneLinkedList(root);
        //list After Reversing
        out.println("Clone LinkedList: ");
        print(head);
        
        out.println("Original LinkedList: ");
        print(root);
        
    }
}
