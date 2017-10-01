class validPalindrome {
    public boolean isPalindrome(String s) {
        
        if(s.length()==0 || s.length()==1) return true;
        s= s.toLowerCase().replaceAll("[^a-zA-Z0-9]", "");
        int len= s.length()/2;
        Stack<Character> stack=new Stack<>();
        
        for(int i=0;i<len;i++){
            stack.push(s.charAt(i));
        }
        
        
        int index;
        if(s.length()%2==0)
            index=len;
        else    
            index= len+1;
        
        for(;index<s.length();index++){
            char check= stack.pop();
            //System.out.println(check+" "+s.charAt(index));
            if(check!= s.charAt(index))
                return false;
        }
        
        return true;
    }
}
