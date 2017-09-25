/*

    Given a stream of numbers which represent the stock prices of a company with timestamp.
    You need to perform some set of operations on the stream of data efficiently as below:
    1. findStockPriceAtGivenTimeStamp(Timestamp) 
    2. deleteAndGetMinimumStockPriceForToday() 
    Timstamp: 1  2   3  4  5 
    Prices:  12  4  4  1  18

*/

import java.io.*;
import java.util.*;

class Stock{
    int TimeStamp,Price;
    Stock(int TimeStamp,int Price){
        this.TimeStamp= TimeStamp;
        this.Price = Price;
    }
}

class StockOperation{
    HashMap<Integer,Stock> map;
    PriorityQueue<Stock> list;
    
    StockOperation(){
        map= new HashMap<>();
        list = new PriorityQueue<>((x, y) ->x.Price-y.Price);
    }
    
    void add(int timestamp,int price){
        Stock temp= new Stock(timestamp,price);
        map.put(timestamp,temp);
        list.add(temp);
    }
    
    int findStockPriceAtGivenTimeStamp(int Timestamp){
        try{
            Stock temp = map.get(Timestamp); 
            return temp.Price;
        }catch(Exception e){
            System.out.println(e);
            return -1;
        }  
    }
    
    int deleteAndGetMinimumStockPriceForToday(){
        if(list.size()<1) return -1; 
        Stock temp= list.poll();
        int time= temp.TimeStamp;
        int price= temp.Price;
        if(map.containsKey(time)){
            map.remove(time);
        }
        return price;
    }
    
}

class myCode
{
    public static void main (String[] args) throws java.lang.Exception
    {
        
        StockOperation st= new StockOperation();
        StockOperation st1= new StockOperation();
        st.add(1,12);
        st.add(2,4);
        st1.add(3,4);
        st1.add(4,1);
        st.add(5,18);
        
        int stockPrice=st.findStockPriceAtGivenTimeStamp(5);
        int minPriceTimeStamp = st.deleteAndGetMinimumStockPriceForToday();
        
        System.out.println(stockPrice+" "+minPriceTimeStamp);
        
        stockPrice=st.findStockPriceAtGivenTimeStamp(1);
        minPriceTimeStamp = st.deleteAndGetMinimumStockPriceForToday();
        System.out.println(stockPrice+" "+minPriceTimeStamp);
        
        stockPrice= st1.findStockPriceAtGivenTimeStamp(3);
        minPriceTimeStamp = st1.deleteAndGetMinimumStockPriceForToday();
        System.out.println(stockPrice+" "+minPriceTimeStamp);
    }
}
