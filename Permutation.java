/*
Input = "123";
Output: 123,132,213,231,312,321
Logic: 
1 - 2 - 3
  - 3 - 2
  
2 - 1 - 3
  - 3 - 1
  
3 - 2 - 1
  - 1 - 2

*/

import java.io.*;
import java.util.*;

class Permutation
{
    public static void main (String[] args) throws java.lang.Exception
    {
        String s="123";
        List<String> list=getPerm(s);
        for(String str: list)
            System.out.println(str);
    }
    
    static List<String> getPerm(String data){
        ArrayList<String> list = new ArrayList<>();
        getPermutation("",data,list);
        return list;
    }
    
    static void getPermutation(String p,String str,ArrayList<String> list){
        int len= str.length();
        if(len==1){
            list.add(p+str);
            return;
        } 
        for(int i=0;i<len;i++){
            String result = str.substring(0, i) + str.substring(i+1);
            char pre= str.charAt(i);
            getPermutation(p+pre,result,list);
        }
    }
}




