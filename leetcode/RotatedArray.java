package leetode50;

import generalPkg.*;

public class RotatedArray {
	
	BinarySearch bs = new BinarySearch();
	//This function finds the count by which the sorted array has been rotated
	//if the array is not rotated then return -1
	//Time = O(n)
	public int rotationBy(int[] ar){
		int len = ar.length;
		int st =0;
		for(int i=1; i< (len)-1; i++){
			if(ar[i-1]>ar[i])
			{
				st=i;
				return st;
			}
		}
		return -1;
	}
	
	//This function finds index where the sorted array has been rotated (using Binary search approach to find that point)
	//if the array is not rotated then return -1
	//Time = O(log n)
	public int rotatedIndexByBinarySearch(int[] ar, int st, int end){
		int mid;
		if (st<end)
		{
			mid = (st+end)/2;
			if( (ar[mid] < ar[mid-1] && ar[mid]< ar[mid+1]) ){
				return mid;
			}
			if(ar[mid]<ar[end]){
				return rotatedIndexByBinarySearch(ar,st,mid-1);
			} else{
				return rotatedIndexByBinarySearch(ar,mid+1,end);
			}
		}
		else {
			return st;
		}
		
		
	}
	
	//function to search on a rotated array
	// 1. check for the index to find rotation
	// 2. if target is greater than start of rotated then look for between 0-pivot index
	// 3. else if target is less than end of array then look for it between pivot -end
	public int binarySearchOnRotatedArray(int[] ar, int target){
		int pivot = rotationBy(ar);
		int index=-1;
		if(pivot == -1){
			return  bs.searchUsingBinary(ar, 0, ar.length-1, target);
		}
		if (ar[pivot] ==  target) return pivot;
		
		if(target > ar[0]){
			index = bs.searchUsingBinary(ar, 0, pivot-1, target);
		} else if(target < ar[ar.length-1]){
			index = bs.searchUsingBinary(ar, pivot, ar.length-1, target);
		}
		
		return index;
	}
	
	// Returns the minimum element of the rotated array
	//Condition: provided there are no duplicates
	public int findMinimumInRotatedArray(int[] ar){
		//int pivot = rotationBy(ar);
		int pivot = rotatedIndexByBinarySearch(ar,0,ar.length-1);
		if(pivot == -1) return -1234;
		else return ar[pivot];
	}
	
	// Returns the minimum element of the rotated array
	//Condition: provided there are DUPLICATES
	public int findMinimumInRotatedArray2(int[] ar){
		int st = 0, end = ar.length -1;
		
		while (st < end && ar[st]>=ar[end]){
			int mid = (st+end)/2;
			if (ar[mid] > ar[end]){
				st = mid +1;
			} else if (ar[mid] < ar[st]){
				end = mid;
			} else{
				st = st+1;
			}		
		}
		
		return ar[st];
	}
	
	public static void main(String args[]){
		RotatedArray ra = new RotatedArray();
		int[] ar= {4,5,6,7,8,-5,0,1,2,3};
		System.out.println("Array ar Rotate by= "+ra.rotationBy(ar));
		
		int[] ar1= {1,2,3};
		System.out.println("Array ar1 Rotate by= "+ra.rotationBy(ar1));
		
		int[] ar2= {1};
		System.out.println("Array ar2 Rotate by= "+ra.rotationBy(ar2));
		
		System.out.println("index of target on rotated array ar= "+ ra.binarySearchOnRotatedArray(ar, 7));
		System.out.println("index of target on rotated array ar1= "+ ra.binarySearchOnRotatedArray(ar1, 2));
		System.out.println("Find Min in Rorate Array ar= "+ra.findMinimumInRotatedArray(ar));
		
		System.out.println("Find rotated Index using binary search in Array ar= "+ra.rotatedIndexByBinarySearch(ar, 0, ar.length-1));
		int[] ar3= {2,3,1,2,2,2,2,2,2,2,2}; //{1,0,1,1,1,1};
		System.out.println("Find Min in Rorate Array with DUPLICTAES ar3= "+ra.findMinimumInRotatedArray2(ar3));
	}

}
