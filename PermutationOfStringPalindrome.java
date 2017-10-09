
/*

    Is Permutation of given string is palindrome
    
    String s="abcab"; retunr true;
    String s="baabc"; retunr true;
    String s="bacad"; retunr false;
    String s="dbacb"; retunr false;
*/

import java.io.*;
import java.util.*;

class PermutationOfStringPalindrome
{
    public static void main (String[] args) throws java.lang.Exception
    {
        String s="";
        boolean result= isPalindrome(s);
        System.out.println(result);
    }
    
    static boolean isPalindrome(String s){
        
        HashMap<Character,Integer> map = new HashMap<>();
        int len= s.length();
        int counter=0;
        boolean isOdd=false;
        
        //If String is empty or string length is 1 than return true
        if(len==0 || len==1 ) return true;
        
        if(len%2==0) isOdd=false;
        else isOdd=true;
        
        // store all value with frequency
        for(char key: s.toCharArray()){
            int val= map.getOrDefault(key,0)+1;
            map.put(key,val);
        }
        
        // Check for even and odd length for frequency condition
        for(int val: map.values()){
            // Condition for odd length String
            if(isOdd && val%2!=0){
                if(counter==2)
                    return false;
                counter++;
            }
            //Condition for even length String
            else{
                if(val%2!=0)
                    return false;
            }
        }
        
        return true;
    }
}
