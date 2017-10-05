/*
    INPUT: [2 4 5 4 7 9 5 4 7] 
    OUTPUT: [4 4 4 5 5 7 7 2 9]
    
    -> sort the array with decreasing frequency of elements
    -> If two elements have the same frequency, sort them by their actual value in increasing order

*/


import java.io.*;
import java.util.*;

class SortArrayBasedOnFrequency
{
    public static void main (String[] args) throws java.lang.Exception
    {
        int[] array = {3,2};
        int[] result= sortArrayBasedOnFrequency(array);
        for(int val:result)
            System.out.print(val+" ");
    }
    
    static int[] sortArrayBasedOnFrequency(int[] array){
        
        if(array.length== 0 || array.length==1) return array;
        
        //Store the resulting value 
        int[] result= new int[array.length];
        
        //store the frequency of each Integer
        HashMap<Integer,Integer> map =new HashMap<>();
        
        // store value based on frequencies  
        PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>((x, y) ->y.getValue() -x.getValue());
        
        for(int i=0;i<array.length;i++){
            int key= array[i];
            map.put(key,map.getOrDefault(key, 0)+1);
        }
        
        // put map value into min heap 
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            queue.offer(entry);
        }
        
        //Store value from the queue to the resulting array
        int index=0;
        while(queue.size()>0){
            Map.Entry<Integer,Integer> entry= queue.poll();
            int key= entry.getKey();
            int freq = map.get(key);
            
            //store key with maximum frequency first
            for(int i=0;i<freq;i++){
                result[index] = key;
                index++;
            }
        }
        
        return result;
        
    }
}
