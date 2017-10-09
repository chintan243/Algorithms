class WordPattern {
    public boolean wordPattern(String pattern, String str) {
        String[] array= str.trim().split(" ");
        if(array.length != pattern.length()) return false;
        
        HashMap<Character, String> map = new HashMap<Character, String>();
        HashMap<String, Character> revMap = new HashMap<>();

        int index=0;
        
        for(char c: pattern.toCharArray()){
            String val=map.getOrDefault(c,array[index]);
            char revVal=revMap.getOrDefault(array[index],c);
            
            if(c!= revVal || !val.equals(array[index])) return false;
            
            map.put(c,val);
            revMap.put(val,c);
            index++;
        }
        
        return true;
    }
}
