class UniquePaths {
    public int uniquePaths(int m, int n) {
        if(m<=1 && n<=1) return Math.max(m,n);
        return uniquePath(0,0,m,n);
    }
    
    static int uniquePath(int i,int j,int m,int n){
        
        if(i>= m || j>= n) return 0;
        
        if(i==m-1 && j== n-1) return 1;
        
        int right= uniquePath(i,j+1,m,n);
        int down= uniquePath(i+1,j,m,n);
            
        return right+down;
    }
}
