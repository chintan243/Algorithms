/*
    INPUT: int[] array = {3,2,3,8,8,5,1,7,7,7,5,5} 
    OUTPUT: 5 5 5 7 7 7 3 3 8 8 1 2
    
    -> sort the array with decreasing frequency of elements
    -> If two elements have the same frequency, sort them by their actual value in increasing order

*/


import java.io.*;
import java.util.*;

class SortArrayBasedOnFrequency
{
    public static void main (String[] args) throws java.lang.Exception
    {
        int[] array = {3,2,3,8,8,5,1,7,7,7,5,5};
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
        
        
        // store value based on frequencies first and than Key 
        PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>(
            (x, y) ->{
                
                // if two key has the same freq than sort in ascending order
                if(x.getValue()== y.getValue())
                    return x.getKey()- y.getKey();
                
                //sorting based on high frequency and low value
                if(y.getKey()> x.getKey() && y.getValue() < x.getValue() ){
                    return x.getKey()-y.getKey();
                }
                
                // sorting based on frequencies
                else{
                    return y.getValue()- x.getValue();
                }
            }                                                              
        );
        
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
            
            //store key with equivalent frequency
            for(int i=0;i<freq;i++){
                result[index] = key;
                index++;
            }
        }
        
        return result;
        
    }
}
