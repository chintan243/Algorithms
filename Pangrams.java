import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Pangrams {
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        Scanner sc=new Scanner(System.in);
        String s="";
        while(sc.hasNext())
            s+= sc.next();
        String str= s.toLowerCase();
        boolean result= isPangram(str);
        if(result)
            System.out.println("pangram");
        else
            System.out.println("not pangram");
    }
    
    static boolean isPangram(String str){
       
        if(str.length()<26) return false;
        
        for(int i='a';i<='z';i++){
            char temp= (char)i;
            int result=str.indexOf(temp);
            if(result<=-1){
                return false;
            }
        }
        return true;  
    }
}
