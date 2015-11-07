package leetode50;

import java.util.Map;
import java.util.*;
public class LRU_146 {
      int capacity;
	    Map<Integer, Integer> lru;
	    public  LRU_146(int capacity) {
	        this.capacity = capacity;   
	        this.lru = new LinkedHashMap<Integer, Integer>(){
	        	//specifically for LRU implementation
	            protected boolean removeEldestEntry(Map.Entry eldest) {
                 return lru.size() > capacity;
            }};
	    }
	    
	    
	    public int get(int key) {
	        if(lru.containsKey(key)){
	           int val = lru.get(Integer.valueOf(key));
	            lru.remove(Integer.valueOf(key));
	            lru.put(key,val);
	            return val;
	        } else{
	            return -1;
	        }
	    }
	    
	    public void set(int key, int value) {
	    	 if(lru.containsKey(key)){
		        lru.remove(Integer.valueOf(key));
	    	 }
		      	lru.put(key,value);
	    }
	    
	    public static void main(String[] s){
	    	LRU_146 lruObj = new LRU_146(2);
	    	lruObj.set(2, 1); 
	    	lruObj.set(2, 2);
	    	System.out.print(lruObj.get(2)+" ");
	    	lruObj.set(1, 1);
	    	System.out.print(lruObj.get(1)+" ");
	    	System.out.print(lruObj.get(2)+" ");
	    	lruObj.set(4, 4);
	    	System.out.print(	lruObj.get(4)+" ");
	    	System.out.print(lruObj.get(1)+" ");
	    	//Output 2 1 2 4 -1 
	    	
	    }
}
