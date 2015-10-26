package leetode50;

import java.util.*;
/*
 * Design and implement a TwoSum class. It should support the following operations: add and find.
add(input) – Add the number input to an internal data structure.
find(value) – Find if there exists any pair of numbers which sum is equal to the value.
For example,
add(1); add(3); add(5); find(4)􏰀true; find(7)􏰀false
 */

public class TwoSumIII {
	
	Map<Integer, Integer> myList = new HashMap<Integer, Integer>();
	public void add(int num){
		if(!myList.containsKey(num)){
			myList.put(num, 1);
		} else {
			myList.put(num, myList.get(num)+1);
		}
	}
	
	public boolean find(int target){
		boolean hasTarget = false;
		int diff = 0;
		for(Map.Entry<Integer,Integer> entry : myList.entrySet()){
			int num = entry.getKey();
			diff = target - num;
			if(diff == num){
				if(entry.getValue() >=2) return true;
			} else {
				if(myList.containsKey(diff)) return true;
			}
		}
		return hasTarget;	
	}
	
	public static void main(String[] args){
		TwoSumIII ts = new TwoSumIII();
		ts.add(3);
		ts.add(5);
		ts.add(1);
		ts.add(1);
		System.out.println(ts.find(2));
	}
	

}
