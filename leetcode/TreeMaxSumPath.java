package leetode50;

import test.TreeNode2;

/*
 Given a binary tree, find the maximum path sum. The path may start and end at any node in the tree. For example, given the below binary tree,
  1
 /\ 
2  4
/\ 
2 3
The highlighted path yields the maximum sum 10. 1-2-3-4
 */
public class TreeMaxSumPath {
	static int maxSum = Integer.MIN_VALUE;
	
	//returns the max sum found in the Binary Tree
	public int maxSumPathInBT(TreeNode2 root){
		maxSum(root);
		return maxSum;
	}
	
	public int maxSum(TreeNode2 root){
		
		if(root == null) return 0;
		int max = 0;
		int val = root.data;
		int left = maxSum(root.left);
		int right = maxSum(root.right);
		maxSum = Math.max((val+left+right), maxSum);
		max = Math.max(left, right)+val;
		return max>0 ? max:0;
	}
	
	public static void main (String sr[]){
	
		TreeMaxSumPath tsmp = new TreeMaxSumPath();
		TreeNode2 a1, b1, c1, d1, e1;
		a1 = new TreeNode2(1, null, null);
		b1 = new TreeNode2(2, null, null);
		c1 = new TreeNode2(-4, null, null);
		d1 = new TreeNode2(-22, null, null);
		e1 = new TreeNode2(3, null, null);
		a1.addLeft(b1);
		a1.addRight(c1);
		b1.addLeft(d1);
		b1.addRight(e1);
		System.out.println(tsmp.maxSumPathInBT(a1));
	}

}
