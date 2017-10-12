import java.io.*;
import java.util.*;

class StringCompare {
    public static void main(String args[]) {
        String s="BCcaAa";
        System.out.println("Sum of x+y = " + doesMatch(s));
    }
    
    static boolean doesMatch(String s){
        Stack<Character> stack= new Stack<>();
        
        for(char c:s.toCharArray()){
            boolean isUpper= Character.isUpperCase(c);
            char lower= Character.toLowerCase(c);
            
            if(isUpper){
                stack.push(lower);
            }else{
                
                if(stack.size()<=0 || stack.pop()!=lower)
                    return false;
            }
        }
        
        return true;
    }
}
