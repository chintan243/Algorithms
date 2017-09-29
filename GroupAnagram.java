class GroupAnagram {
    public List<List<String>> groupAnagrams(String[] str) {
        List<List<String>> result = new ArrayList<List<String>>();
        List<String> list; 
        if(str.length==0) return result;
    
        HashMap<String,List<String>> map= new HashMap<>();
        
        for(int i=0; i< str.length; i++){
            String s= sort(str[i]);
            if(map.containsKey(s)){
                list= map.get(s);
                list.add(str[i]);
            }else{
                list= new ArrayList<>();
                list.add(str[i]);
                map.put(s,list);
            }
        }
        
        for(List<String> lists: map.values()){
            result.add(lists);
        }
        return result;
    }
    
    private String sort(String str){
        char[] c= str.toCharArray();
        Arrays.sort(c);
        return new String(c);   
    }
}
