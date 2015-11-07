package leetode50;
import test.TreeNode2;

/* Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
( checks validoty when Only distinct vales are thr in BST)

 */
public class ValidateBST {
	
public boolean isBST(TreeNode2 root, Integer min, Integer max){
		
		if(root == null) 
			return true;
		int p = root.data;
		TreeNode2 left = root.left;
		TreeNode2 right = root.right;
		
		return ((min == null || p > min) && 
		         (max == null || p < max) && 
		            isBST(left, min, root.data) && isBST(right, root.data, max));
	}
	
	public boolean validateBST(TreeNode2 root)
	{
		//nulls bcos node's value could be INT_MAX/MIN as well so we handle it as an object
		return isBST(root, null, null);
	}
	
	public static void main (String sr[]){
	
		
	}

}
