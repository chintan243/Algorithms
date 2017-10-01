class LongestConsecutive {
    public int longestConsecutive(int[] ary) {
        TreeMap<Integer,Integer> map =new TreeMap<>();
        
        if(ary.length==0 || ary.length==1) return ary.length;
        
        for(int i=0;i<ary.length;i++){
            int temp = ary[i];
            map.put(temp,0);
        }
        
        int max=0,count=0;
        int prev= Integer.MIN_VALUE;
        for(int val: map.keySet()){
            
            if(prev+1!=val && count!=0){
                if(max<count)
                    max=count;
                count=0;
                
            }
            if(count==0)
                count++;
            if(prev+1==val)
                count++;
            
            prev=val;
        }
        
        return Math.max(max,count);

    }
}
