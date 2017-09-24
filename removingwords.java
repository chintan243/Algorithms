
/*
You are given two string (like two statements). You have to remove all the words of second string from first string and
print the remaining first string. Please maintain the order of the remaining words from the first string. You will be only
removing the first word, not all occurrence of a word. 
Example: Str1 = "A Statement is a Statement", Str2 = "Statement a" Output: "A is Statement"
*/

import java.io.*;
import java.util.*;

class myCode
{
    public static void main (String[] args) throws java.lang.Exception
    {
        String str1= "A Statement is a Statement";
        String str2= "Statement a";
        
        String[] s1= str1.trim().split(" ");
        String[] s2= str2.trim().split(" ");
        
        for(int i=0;i<s1.length;i++){
            for(int j=0;j<s2.length;j++){
                if(s1[i].equals(s2[j])){
                    s1[i]=" ";
                    s2[j]=" ";
                }
            }
        }
        String result="";
        
        //Here we removing space and Adding remaining words into the resulting String
        for(int i=0;i<s1.length;i++){
                if(!s1[i].equals(" ")){
                    result+=s1[i]+" ";
                }       
        }
        System.out.println(result);
    }
}
