import java.io.*;
import java.util.*;

class lengthOfLongestSubstringKDistinct
{
    public static void main (String[] args) throws java.lang.Exception
    {    
        String s= "abcadcacacaca";
        s="aabbcc";
        int result= lsuc(s,1);
        System.out.println(result);
    }
    
    //longest substring unique character
    static int lsuc(String s, int k){
        int prev=0,p1=0,p2=0,result=0,max=0;
        
        if(s.length()<k) return s.length(); 
        
        if(k==0) return 0;
        
        char[] str= s.toCharArray();
        
        HashMap<Character,Integer> map= new HashMap<>();
        HashSet<String> set= new HashSet<>();
        LinkedList<Character> list= new LinkedList<>();
        
        
        // here intitaly counter=0 and k=2
        while(p2<str.length){
            char temp=str[p2];
            
            if(!list.contains(temp)){
                list.add(temp);
            }
            
            if(temp != str[prev] || p2==0){
                map.put(temp,p2);
            }
            
            if(map.size()>k){
                set.add(s.substring(p1,p2));
                if(k==1)
                    remove(map, list,k);
                else
                    remove(map, list,k-1);
                char maxIndex= list.peek();
                p1= map.get(maxIndex);
            }
            
            prev =p2;
            p2++;
        }
        
        set.add(s.substring(p1));
        
        // Find maximum length
        for(String data: set){
            if(data.length()>max)
                max=data.length();
            System.out.println(data);
        }
        
        return max;
    }
    
    // remove upto k element
    static void remove(HashMap<Character,Integer> map, LinkedList<Character> list,int k){
        
        for(int i=0;i<k;i++)
            map.remove(list.removeFirst());
    }
}
