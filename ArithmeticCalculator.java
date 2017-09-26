/*
 
   code a RPN calculator that incorporates parenthesis and an indeterminate amount of numbers 
   per operation (where as RPN will always be only two numbers per operation).
   An example:
   1) "( add 1 ( mul 3 4 ) )" = 13.
   
   2) "( add ( mul 2 2 ) ( mul 3 4 ) )" = 16

*/

import java.io.*;
import java.util.*;

class Calc{
    
    int ArithmeticOp(String[] s){
        Stack<String> stack=new Stack<>();
        Stack<String> number =new Stack<>();
        
        for(int i=0;i<s.length;i++){
            String temp=s[i];
            String str=")";
            
            if(temp.equals("(")){
                stack.push(")");    
            }else if(temp.equals(str)){
                stack.pop();
                int val=performOperation(number);
                number.push(String.valueOf(val));
            }else{
                number.push(temp);
            }
        }
        return Integer.parseInt(number.peek());
    }
    
    private int performOperation(Stack<String> number){
        int a=Integer.parseInt(number.pop());
        int b=Integer.parseInt(number.pop());
        String op= number.pop();
        return calculate(a,b,op);
    }
    
    private int calculate(int a,int b,String op){
       if(op.equals("add"))
            return a+b;
        if(op.equals("mul"))
            return a*b;
        else{
            return a/b;
        }
    }
    
}

class myCode
{
    public static void main (String[] args) throws java.lang.Exception
    {
        String s="( add ( mul 2 2 ) ( mul 3 4 ) )";
        String[] str= s.trim().split(" ");
        
        Calc cal= new Calc();
        int out = cal.ArithmeticOp(str);
        System.out.println(out);
    }
    
}
