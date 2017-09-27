
/*

    Check whether the tree is valid Binary Search Tree or not!
    Complexity<O(n) in Avg case
    if we find that tree is not valid( root.left<= root< root.right) than we will skip rigth sub tree.

*/


import java.io.*;
import java.util.*;

/*
    Structure of each Node storing data

*/

class Node{
    Node left,right;
    int val;
    
    Node(int val){
        this.val=val;
        left=null;
        right=null;
    }
}

/*
    Wrapper class storing result true or false
*/
class Istree{
    boolean IsValid;;
    Istree(boolean result){
        IsValid= result;
    }
}

/*
    class contains method isValid Tree which check whether it is valid binary tree or not

*/

class BinaryTree{
    
    boolean isValidTree(Node root){
        if(root==null) return true;
        Istree result= new Istree(true);
        isValidTree(root,Integer.MIN_VALUE,result);
        return result.IsValid;
    }
    
    int isValidTree(Node root,int min,Istree result){
        if(root.left!=null)
            min=isValidTree(root.left,min,result);
        
        if(root.val<min){
            result.IsValid = false;
        }
        
        // If we found left subtree with false we will not check right subtree of each node
        if(!result.IsValid) return min;
        
        if(root.right!=null)
            min=isValidTree(root.right,min,result);
        
        min= Math.max(root.val,min);
        
        return min;
        
     }
    
}

/*
    Main Method
*/
class ValidateBinary
{
    public static void main (String[] args) throws java.lang.Exception
    {
        
        Node root= new Node(50);
        root.left=new Node(20);
        root.left.left=new Node(10);
        root.left.right= new Node(60);
        root.right= new Node(80);
        root.right.left=new Node(70);
        root.right.right= new Node(90);
        
        BinaryTree bt= new BinaryTree();
        boolean output=bt.isValidTree(root);
        System.out.println(output);
    }
}
