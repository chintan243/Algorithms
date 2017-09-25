/*

      Input:   price[] = {10, 22, 5, 75, 65, 80}
      Output:  87
      87 as sum of 12(22-10) and 75(80-5)


      Input:   price[] = {2, 30, 15, 10, 8, 25, 80}
      Output:  100
      100 as sum of 28(30-2) and 72(80-8)

*/
import java.io.*;
import java.util.*;

class Stock{
    int MaximumProfit(int[] price){
        int i=1;
        int[] temp= new int[price.length];
        
        //check for decreasing order index because we will not consider upto decreasing order
        
        for(;i<price.length;i++){
            if(price[i]>price[i-1])
                break;
        }
        
        //Find Two minimum
        for(int itr=0;itr<price.length;itr++){
            temp[itr]=price[itr];
        }
        Arrays.sort(temp);
        int min =temp[0];
        int min2=temp[1];
        
        
        // Finding index value of two minimum value of array
        int c1=-1; //index value for first minimum value
        int c2=-1; // index value for second minimum value
        for(int k=i-1;k<price.length;k++){
            if(price[k]==min && c1==-1)
                c1=k;
            if(price[k]==min2 && c2==-1)
                c2=k;
        }
        

        // two big difference and make addition of it.
        int a=0,b=0;
        if(c2<c1){
            a=find(price,c2,c1,min2);
            b=find(price,c1,price.length,min); 
        }else{
            a=find(price,c1,c2,min);
            b=find(price,c2,price.length,min2); 
        }
        
        return a+b;
    }
    
    
    // Method finding big difference of array 
    private int find(int[] price,int start,int end,int min){
        if(end-start==1) return 0;
        // here start or end can be negative if array in begining is negative
        // than c1 or c2 can get negative value;
        if(start<0 || end<0) return 0; 
        
        int max=Integer.MIN_VALUE;
        for(int i=start;i<end;i++){
            if(price[i]>max)
                max=price[i];
        }
        
        return max-min;
    }
}

class myCode
{
    public static void main (String[] args) throws java.lang.Exception
    {  
        int price[] ={100, 30, 15, 10, 8, 25, 80};
        Stock st=new Stock();
        int result=st.MaximumProfit(price);
        System.out.println("Price :" + result);
    }
}
