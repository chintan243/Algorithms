class MinPathSum {
    public int minPathSum(int[][] grid) {
        if(grid.length==0 && grid[0].length==0) return 0;
        return helper(grid,0,0);
    }
    
    static int helper(int[][] array,int i,int j){
        if(i>= array.length || j>= array[0].length)
            return 0;
        
        int current = array[i][j]; 
        if(i== array.length-1 && j== array[0].length-1) return current;
        
        int right= helper(array,i,j+1);
        int down= helper(array,i+1,j);
        
        int min=0;
        
        if(right>0 && down>0)
            min= Math.min(right,down);
        else
            min= right+down;
        
        return min+current;
    }
}
