import java.io.*;

class Op{
    
    int kSubSeq(int[] array,int k){
        if(array.length == 0) return 0;
        return kSubSeq(array,k,0,0);
    }
    
    int kSubSeq(int[] array,int k,int count,int index){
        int i;
        int sum=0;
        for(i=index;i<array.length;i++){
            int temp= array[i];
            sum= sum+ temp;
            if(sum%k== 0)
                count++;
        }
        
        if(index== array.length) return count;
        
        return kSubSeq(array,k,count,++index);
    }
}

class myCode
{
    public static void main (String[] args) throws java.lang.Exception
    {
        //int[] array={1,2,3,4,1};
        int[] array= {1,2,1,2,1,2};
        Op op=new Op();
        int result=op.kSubSeq(array,3); 
        System.out.println(result);
    }
}
