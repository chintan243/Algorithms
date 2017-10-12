class UniquePath {
    public int uniquePaths(int m, int n) {
        if(m<=1 && n<=1) return Math.max(m,n);
        int cap= m*n;
        int[] res = new int[cap+1];
        res[0]= 0;
        res[1]= 1;
        return helper(res,m,n);
    }
    
    static int helper(int[] res,int m,int n){
        
        int left=0,up=0;
        //fill the array from 1,2,3....,(m*n+1) for m*n positions
        int[][] array= new int[m][n];
        int count=1;
         for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                array[i][j]= count;
                count++;
            }
         }
        
        int cur=0;
        // Check Left and Up for previous value
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                cur= array[i][j];
                // check if left(row) and up(col) not less than 0
                if(i-1>=0 && j-1>=0){
                     left=array[i-1][j];
                     up= array[i][j-1];
                     res[cur]= res[left]+res[up]; 
                 }else if(i-1>=0 && j-1<0){
                      left=array[i-1][j];
                      res[cur]= res[left];
                 }else if(i-1<0 && j-1>=0){
                     up= array[i][j-1];
                     res[cur]= res[up];
                 }
                 
            }
        }
        
        // return last position element
        return res[cur];
    }
}
