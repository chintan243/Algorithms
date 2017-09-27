

import java.io.*;
import java.util.*;

/*
  Data Structure of each node in MyLinkedList
*/
class Node{
    int data;
    Node next=null;
    Node(int data){    
        this.data =data;
    }    
}

class MyLinkedList{

    Node head,head1, headPalindrome;
    int counter=0;
    
    public MyLinkedList(Node head){
        this.head=head;
        head1=head;    // For maintaining the starting point of the linked list
        headPalindrome=head;
    }
    
    /*
        Intersection:
        Here,  we have used two linked list
        list 1 :- 3 -> 3 -> 2 -> 1
                            ^ 
                            |
                            3
                            list 2 :- 3->2->1
        Here Intersection noed is 2. As per node reference.
        
    */
    
    static int InterSection(MyLinkedList l1, MyLinkedList l2){
        Node temp1= l1.head1;
        Node temp2= l2.head1;
        Stack<Node> s1= fillToStack(temp1);
        Stack<Node> s2= fillToStack(temp2);
        int result = 0;
        
        while(s1.peek() == s2.peek()){
            Node nodeValue= s1.peek();
            result = nodeValue.data;
            s1.pop();
            s2.pop();
        }
        
        return result;
    }
    
    static Stack<Node> fillToStack(Node node){
        Stack<Node> stack =new Stack<>();
        while(node!=null){
            stack.push(node);
            node= node.next;
        }
        return stack;
    }
    
    /*
        Add the new node to the linkeList
    */
    
    void add(int data){
        Node newNode= new Node(data);
        this.head.next = newNode;
        this.head = newNode;
    }
    
    /*
        Prints the Given LinkedList
    
    */
    
    void prints(){
        Node temp = this.head1;
        while(temp!= null){
            System.out.print(temp.data+" ");
            temp= temp.next;
        }
        System.out.println();
    }
    
    /*
        Get length of the Linked list
    */
    int lengths(){
        int counter=0;
        Node temp= this.head1; //Start of the linked list
        while(temp!= null){
            counter++;
            temp= temp.next;
        }
        return counter; 
    }
}

class MyLinkedLists
{
    public static void main (String[] args) throws java.lang.Exception
    {
        MyLinkedList l1 = new MyLinkedList(new Node(3));
        MyLinkedList l2 = new MyLinkedList(new Node(3));
        l1.add(3);
        l1.add(2);
        l1.add(1);
        l2.head.next= l1.head1.next.next; // value = 2 
        l2.head.next.next= l1.head1.next.next.next; // value =1
        
        
        int data= MyLinkedList.InterSection(l1,l2);
        System.out.println("Intersection of two LinkedList   : "+ data);
        
        l1.prints();
        System.out.println(l1.lengths());
        l2.prints();
        System.out.println(l2.lengths());
        
    }
}
