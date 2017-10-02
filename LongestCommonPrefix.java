class LongestCommonPrefix {
    public String longestCommonPrefix(String[] s) {
        int len= s.length;
        
        String result="";
        if(len==0) return result;
        
        String str= s[0];
        if(len==1) return str;
        
        for(int i=0;i<str.length();i++){
            char temp= str.charAt(i);
            
            for(int j=1;j<len;j++){
                String str2= s[j];
                if(str2.length()>i){
                    if(temp != str2.charAt(i))
                         return result;
                }else{
                    return result;
                }
            }
            result+=temp;
        }
        return result;
    }
}
