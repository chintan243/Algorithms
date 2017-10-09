/*abstract

s = aabb, t = ab, return = 2; s = aabcbdc, t = abc, return 1; 


*/

import java.io.*;


class Solution{
    
    public int deleteSubstring(String str,String sub){
        if(str.length()< sub.length()) return Integer.MIN_VALUE;
        
        if(sub.length()==0 && str.length==0) return 0;
        
        int len = sub.length();
        char first = sub.charAt(0);
        String s="";
        
        for(int i=0;i<str.length();i++){
            char c= str.charAt(i);
            
            if(c== first){
                int end= i+len;
                if(end<= str.length())
                    s= str.substring(i,end);
                if(s.equals(sub)) return i;
            }
        }
        
        return Integer.MIN_VALUE;
        
    }
}

class DeleteSubstring
{
    public static void main (String[] args) throws java.lang.Exception
    {
        Solution s= new Solution();
        String str=  "ABABDABACDABABCABAB";
        String sub = "ABABCABAB";
        System.out.println(s.deleteSubstring(str,sub));
    }
}
