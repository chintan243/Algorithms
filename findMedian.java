import java.io.*;

class findMedian
{
    public static void main (String[] args) throws java.lang.Exception
    {
        int[] a= {1,2,3,4};
        int[] b= {3,6,9,10,12,13};
        double out= findMedian(b);
        System.out.println(out);
    }
    
    static double findMedian(int[] array){
        
        int len= array.length;
        int index;
        double data;
        
        if(len==0) return 0.0; 
        if(len==1) return array[len-1];
        
        if(len%2 !=0){
            index= array[len/2];
            data= index;
        }else{
            index= array[len/2]+array[(len/2)-1];
            data= (double)index/2;
        }
        
        return data;
    }
}
