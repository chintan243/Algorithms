class arrayIntersection {
    public int[] intersection(int[] n1, int[] n2) {
        int len=0;
        int[] min,max;
        HashSet<Integer> set=new HashSet<>();
        
        if(n1.length<n2.length){
            len= n1.length;
            min= n1;
            max=n2;
        }else{
            len= n2.length;
            min=n2;
            max=n1;
        }  
        
        if(n1.length ==0 || n2.length==0 )  return new int[0];
      
        // Sorting array
        Arrays.sort(n1);
        Arrays.sort(n2);
        
        
        // take smallest element from the minimum length array and find it from maximum lengh
        // array and put it into the HashSet for storing only unique array
        for(int i=0;i<len;i++){
            int temp= min[i];
            int data= Integer.MIN_VALUE;
            
            if( !set.contains(temp))
                data=search(max,temp);
            
            if(data==temp)
                set.add(data);
        }
        
        
        // Transfer data from set to the result integer array 
        int index=0;
        int[] result= new int[set.size()];
        for(int data:set){
            result[index]= data;
            index++;
        }
        
        return result;
    }
    
     // Binary Search for finding intersection of the array
    static int search(int[] max,int data){
        return find(max,0,max.length,data);
        
    }
    
    
    static int find(int[] max,int start,int end,int data){
        
        if(start>end || start>=max.length) return Integer.MIN_VALUE;
        
        int mid= (start+end)/2;
        if(max[mid]==data) return data;
        
        int left= find(max,start,mid-1,data);
        int right = find(max,mid+1,end,data);
        
        if(left==data || right == data)
            return data;
        else
            return Integer.MIN_VALUE;
        
    }
}
