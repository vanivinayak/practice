package leetode50;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

	public int[] twoSum(int[] nums, int target){
			int[] res = new int[2];
        
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        
        for(int i=0;i<nums.length;i++)
        {
            if(!map.containsKey(nums[i])){
                map.put(nums[i],i);
            } else {
                map.remove(nums[i]);
                map.put(nums[i],i);
            }
        }
        
        for(int j =0; j< nums.length;j++){
            int diff = target - nums[j];
            if(map.containsKey(diff)){
                if (j < map.get(diff)) {
                    res[0] = j+1;
                    res[1] = map.get(diff)+1;
                    break;
                }
            }
        }
        return res;
	}
	
	public static void main(String[] args ){
		TwoSum ts = new TwoSum();
		int[] input =  {2, 7, 11, 14, 10, 6};
		int[] res = ts.twoSum(input, 17);
		System.out.println("index1= "+res[0]+"  index2= "+res[1] );
	}
}
