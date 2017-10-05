/*
    Time Complexity near to O(Kn);
    Sum of all Subarrays
    
*/

import java.io.*;
import java.util.*;



class SumOfSubArry
{
    public static void main (String[] args) throws java.lang.Exception
    {
        int[] array = {1,2,3};
        int result= sumOfAllSubArry(array);
        System.out.println(result);
    }
    
    static int sumOfAllSubArry(int[] array){
        
        if(array.length==0) return 0;
        if(array.length==1) return array[0];  
        
        int sum=0,result=0,total=0;
        
        for(int i=0;i<array.length;i++){
            for(int j=i;j<array.length;j++){
                int val= array[j];
                sum=sum+ val;
                total=total+sum;
            }
            result+= total;
            sum=0;
            total=0;
        }
        return result;
    }
}
