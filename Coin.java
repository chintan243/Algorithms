
/* 
    Coin Count Problem:
    -> find the number of ways make particular amount
*/

import java.io.*;
import java.util.*;


class Count{
    
    /* 
        code to find the number of ways make particular amount
    */
    int makeChanges(int n){
        if(n==0) return 0;
        if(n==1) return 1;
        return makeChanges(n,0,25);
    }
    
    int makeChanges(int n,int count, int call){
        if(n<0) return count;
        if(n==0) return ++count;
        /*
            here call represent the number of coin
            If we used coin 25 than next time we willfollow 10
            than 10 follow 5 and 1. and so on
            
        */
        if(call>=25)
          count= makeChanges(n-25,count,25); 
        if(call>=10)
           count= makeChanges(n-10,count,10);
        if(call>=5)
            count=makeChanges(n-5,count,5);
        if(call>=1)
            count=makeChanges(n-1,count,1);
            
        return count;
    } 
}

public class Coin
{
    public static void main (String[] args) throws java.lang.Exception
    {
        
        Count count=new Count();
        int result= count.makeChanges(10);
        System.out.println(" RESULT: "+result);
    }
}
