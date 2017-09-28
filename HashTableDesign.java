/*
    Hash Table with Separate Chaining in Java
*/


import java.io.*;
import java.util.*;

class Node<K,V>{
    K key;
    V value;
    Node next= null;
    
    Node(K key, V value){
        this.key= key;
        this.value = value;
    }
}

class HashMaps<K,V>{
    Node<K,V>[] bucket;
    int numBucket;
    int bucketSize;
    
    public HashMaps(){
        numBucket= 10;
        bucketSize= 0;
        bucket= new Node[numBucket];
        
        for(int i=0;i<numBucket;i++)
            bucket[i]= null;
        
    }
    
    int hash(K key){
        int hashcode= key.hashCode();
        int index=hashcode %numBucket;
        return index; 
    }
    
    void put(K key, V value){
        int index= hash(key);
        Node<K,V> head= bucket[index];
        
        while(head!=null){
        
            if(head.key.equals(key)){
                head.value=value;
                return;
            }
            head= head.next;
        }
        
        bucketSize++;
        Node<K,V> newNode= new Node<K,V>(key,value);
        newNode.next= bucket[index];
        bucket[index]= newNode;
    }
    
    V get(K key){
        int index= hash(key);
        Node<K,V> head= bucket[index];
        
        while(head != null)
        {
            if(head.key.equals(key))
                return head.value;
            
            head= head.next;
        }
        return null;
    }
    
    void remove(K key){
        int index= hash(key);
        Node<K,V> head= bucket[index];
        Node<K,V> prev=null;
        
        if(head==null) return;
        
        while(head != null)
        {
            if(head.key.equals(key)){
                break;
            }
            prev= head;
            head= head.next;
            
        }
        
        if(prev!=null)
            prev.next= head.next;
        else{
            bucket[index]= head.next;
        }
        
    }
    
}

class HashTableDesign
{
    public static void main (String[] args) throws java.lang.Exception
    {
        HashMaps<Integer,Integer> hm=new HashMaps<>();
        HashMaps<Integer,Integer> hm2=new HashMaps<>();
        hm.put(1,10);
        hm.put(3,30);
        hm.put(5,50);
        hm.put(7,70);
        hm2.put(5,60);
        System.out.println(hm.get(5));
        hm2.remove(5);
        System.out.println(hm.get(5));
        hm.remove(3);
        System.out.println(hm.get(7));
    }
}
