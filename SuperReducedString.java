import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static String remove(String s,int start,int end ){
        String temp= s.substring(0,start);
        if(end== s.length()-1){
            return temp;
        }
        s=s.substring(end+1);
        return temp+s;
    } 
    
    static String super_reduced_string(String s){
        int i=1;
        while(i<s.length()){
            if(s.charAt(i)==s.charAt(i-1)){
                s=remove(s,i-1,i);
                i=1;
            }else{
                i++;
            }
        }
        if(s.length()!=0) return s;
        s= "Empty String";
        return s;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        String result = super_reduced_string(s);
        System.out.println(result);
    }
}
