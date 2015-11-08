package leetode50;
import java.util.*;
/*
 * Given an array of integers, every element appears twice except for one. Find that single one.
 */
		
public class SingleNumber {
	
	//using set approach, to find the single existing number in an array
	//Space = O(n) Time = O(n)
	public int findSingleNmber(int[] ar){
		int single = -1;
		
		Set<Integer> set = new HashSet<Integer>();
		for(int x :ar){
			if(set.contains(x)){
				set.remove(x);
			} else {
				set.add(x);
			}
		}
		single = set.iterator().next();
		return single;
	}
	
	//XOR a number with itself yields zero so we can XOR all numbers in array and the single number is the finla answer we are looking for
	//Space = O(1) Time = O(n)
	public int findSinglebyXOR(int[] ar){
		int num =0;
		for(int x :ar){
			 num = num ^ x;
		}
		return num;
	}
	
	
	public static void main(String ar[]){
		SingleNumber sn = new SingleNumber();
		int[] xAr = {2,3,4,2,4,5,6,7,6,5,7};
		System.out.println(sn.findSingleNmber(xAr));
		System.out.println(sn.findSinglebyXOR(xAr));
	}

}
