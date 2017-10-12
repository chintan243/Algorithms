import java.util.*;

public class AirpostIntervals {
    public static void main(String args[]) {
        int a[]={4,5};
        int b[]={}; 
        System.out.println(airPort(a, b));
    }
    
    static int airPort(int[] a,int[] b){
        HashMap<Integer,Integer> map= new HashMap<>();
        Set<Integer> set=new  HashSet<>();
        // Here count take care about highest number of gate required counting
        int count=1,arrv=0,dep=0,arrv2=0,dep2=0;
        
        if(a.length==0 && b.length==0) return 0;
        if(a.length!=0 && b.length==0) return a.length;
        
        //make table for arrival time(key) and departure time(value) 
        for(int i=0;i<a.length;i++)
            map.put(a[i],b[i]);    
        
        arrv=a[0];
        dep=b[0];
        //default count add to set (count=1)
        set.add(count);
        
        // Traverse through all the Intervals
        for(int i=1;i<a.length;i++){
            arrv2=a[i];
            dep2= b[i];
            
            //compare first interval departuare is greater than second interval arrival time than merge Intervals
            if(dep >= arrv2){
                count++;
            }else{
                set.add(count);
                count=1;
            }
            
            // from two merged Intervals take higher departure for new Interval 
            dep=Math.max(dep,dep2);
        }
        set.add(count);
        
        // Find max data and print it
        int max= 1;
        for(int data:set)
            max=data;
        
        // Return max gate required
        return max;
    }
}
