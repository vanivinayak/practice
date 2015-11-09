package leetode50;

import test.TreeNode2;

/*
Given a binary tree, determine if it is height-balanced.
For this problem, a height-balanced binary tree is defined as a binary tree 
in which the depth of the two subtrees of every node never differs by more than 1.
 */
public class BalancedBT {

	//finds the maximum depth of the tree
	public int maxDepth(TreeNode2 root){
		if (root == null) return 0;
		return Math.max(maxDepth(root.left), maxDepth(root.right))+1;
	}
	
	//checks the tree is balanced - brute force approach
	public boolean isBalanced(TreeNode2 root){
		if (root == null) return true;
		
		return Math.abs(maxDepth(root.left)-maxDepth(root.right))<=1
				&& isBalanced(root.left) && isBalanced(root.right);
	}
	
	//finds the depth of the tree, if its not balanced then returns -1 else the depth
	public int findTreeDepth(TreeNode2 root){
		if(root == null) return 0;
		int left = findTreeDepth(root.left);
		int right = findTreeDepth(root.right);
		if(Math.abs(left - right) > 1) return -1;
		else return Math.max(left, right)+1;
	}
	
	public boolean checkBalancedBT(TreeNode2 root){
		return findTreeDepth(root) != -1;
	}
	
	public static void main(String args[]){
		BalancedBT bt = new BalancedBT();
		TreeNode2 a1, b1, c1, d1, e1, f1;
		a1 = new TreeNode2(5, null, null);
		b1 = new TreeNode2(4, null, null);
		c1 = new TreeNode2(6, null, null);
		d1 = new TreeNode2(3, null, null);
		e1 = new TreeNode2(7, null, null);
		f1 = new TreeNode2(56, null, null);
		a1.addLeft(b1);
		a1.addRight(c1);
		b1.addLeft(d1);
		b1.addRight(e1);
		e1.addLeft(f1);
		System.out.println("brute force= "+bt.isBalanced(a1));
		System.out.println("diff approach= "+bt.checkBalancedBT(a1));
	}
}
