class TopKFrequent {
    public List<Integer> topKFrequent(int[] array, int k) {
    
        HashMap<Integer,Integer> map =new HashMap<>();
        List<Integer> list= new ArrayList<>();
        
        // store value based on frequencies  
        PriorityQueue<Map.Entry<Integer, Integer>> heap = new PriorityQueue<>((x, y) ->y.getValue() -x.getValue());
        
        // if k value 
        if( k > array.length) return list;
        
        // Find the frequency of each integer value
        for(int i=0;i< array.length;i++){
            int key= array[i];
            map.put(key, map.getOrDefault(key, 0) + 1);
        }
        
        // put map value into min heap 
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            heap.offer(entry);
        }
        
        // iterate through priorityqueue and store value upto k elements 
        for(int i=0;i<k;i++){
            Map.Entry<Integer, Integer> entry = heap.poll();
            list.add(entry.getKey());
        }
        
        return list;
    }
}
