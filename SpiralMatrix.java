class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list= new ArrayList<>();
        if(matrix.length==0) return list;
        
        int m=matrix.length;
        int n= matrix[0].length;
        int size= m * n;
    
        SpiralMatrix(matrix,0,0,list, size,4);
        return list;
    }
    
    static int SpiralMatrix(int[][] grid,int i,int j,List<Integer> list,int size,int call)
    {    
        if(i>= grid.length || j>= grid[0].length || i<0 || j<0 ||  grid[i][j]==Integer.MIN_VALUE){
            if(call==4){           // If right than go to down
                return 3;
            }else if(call==3){     // If down than go to left
                return 2;
            }else if(call==2){     // If left than go to up
                return 1;
            }else{                 //If up than go to right
                return 4;
            }
        } 
        
        // If list size and the number of elements in matrix are same than return 0 so it will not move ahead for other 
        if(list.size()==size)
            return 0;
        
        list.add(grid[i][j]);
        grid[i][j]=Integer.MIN_VALUE;
        
        if(call==4)
            call=SpiralMatrix(grid,i,j+1,list,size,4);    //right
        if(call==3)
            call=SpiralMatrix(grid,i+1,j,list,size,3);    //down
        if(call==2)
            call=SpiralMatrix(grid,i,j-1,list,size,2);    //left
        if(call==1)
            call=SpiralMatrix(grid,i-1,j,list,size,1);    //up
        
        //System.out.print(call+" ");
        if(call==0)
            return call;
        else
            return SpiralMatrix(grid,i,j+1,list,size,4);   //if still element than go to right
    }
}
