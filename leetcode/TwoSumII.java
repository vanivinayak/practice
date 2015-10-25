package leetode50;

import java.util.HashMap;
import java.util.Map;

/*
 * Given an array of integers, find two numbers such that they add up to a specific target number.
 * -----except that the input array is already sorted in ascending order.
 */
public class TwoSumII {
	
	/* Mine*/
	 public int[] twoSum(int[] nums, int target){
		int[] res = new int[2];
		int st = 0, end = nums.length-1, mid = 0, diff;	
		for(int j =0; j< nums.length;j++){
			int val = nums[j];
			st = j+1;
			while(st<end){
				diff = target - val;
				mid = (st+end)/2;
				if(diff== nums[mid]){
					res[0] = j+1;
					res[1] = mid+1;
					return res;
				} else if(diff < nums[mid]){
					end = mid;
				}else if(diff > nums[mid]){
					st = mid+1;
				}	
			}
		}	
		return res;
	}
	
	/*
	 * LeetCode Solution
	 */
	/*public int[] twoSum(int[] numbers, int target) {
		   // Assume input is already sorted.
		   for (int i = 0; i < numbers.length; i++) {
		      int j = bsearch(numbers, target - numbers[i],  i + 1);
		      if (j != -1) {
		return new int[] { i + 1, j + 1 }; }
		}
		   throw new IllegalArgumentException("No two sum solution");
		}
		private int bsearch(int[] A, int key, int start) {
		   int L = start, R = A.length - 1;
		   while (L < R) {
		      int M = (L + R) / 2;
		      if (A[M] < key) {
		         L = M + 1;
		      } else {
		R = M; }
		}
		   return (L == R && A[L] == key) ? L : -1;
		}*/
	public static void main(String[] args ){
		TwoSumII ts = new TwoSumII();
		int[] input =  {2, 7,8, 9, 9,10,11,11, 15};
		int[] res = ts.twoSum(input, 20);
		System.out.println("index1= "+res[0]+"  index2= "+res[1] );
	}

}
