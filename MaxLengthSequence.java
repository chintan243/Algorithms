/*
    Input : arr[] = {2, 5, 6, 3, 7, 6, 5, 8}
    Output : 5
    The subsequence is {5, 6, 7, 6, 5}.
*/

import java.util.*;

public class MaxLengthSequence {
    static List<Integer> maxLengthSequence(int[] array){
        List<Integer> list= new ArrayList<>();
        if(array.length==0) return list;
        
        int last= Integer.MIN_VALUE;
        int x= array[0];
        
        for(int i=1;i<array.length;i++){
            int y= array[i]; 
            int temp= Math.abs(y-x);
            
            if(last != Integer.MIN_VALUE){
                temp= Math.abs(y-last);
                if(temp==0 || temp==1){
                    list.add(y);
                    last=y;
                }
            }else if(temp==0 || temp==1){
                list.add(x);
                list.add(y);
                last=y;
            }
            x=y;
        }
        
        if(list.size()<1)
            list.add(x);
        return list;
    }
    
    public static void main(String args[]) {
        
        //int[] a= {2,5,6,3,7,6,5,8};
        int[] a= {-2, -1, 5, -1, 4, 0, 3};
        List<Integer> list= maxLengthSequence(a);
        System.out.println("Maximum length subsequence = "+ list.size());
    }
}
