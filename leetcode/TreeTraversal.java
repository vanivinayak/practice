package leetode50;

import org.omg.PortableInterceptor.Interceptor;

import test.TreeNode2;

public class TreeTraversal {
	
	//left-root-right
	public void inorderTraversal(TreeNode2 root){
		
		if(root == null) return;
		inorderTraversal(root.left);
		System.out.print(root.data+"-");
		inorderTraversal(root.right);
	}
	//root-left-right
	public void preorderTraversal(TreeNode2 root){
		
		if(root == null) return;	
		System.out.print(root.data+"-");
		preorderTraversal(root.left);
		preorderTraversal(root.right);
	}
	//left-right-root
	public void postorderTraversal(TreeNode2 root){
		
		if(root == null) return;
		postorderTraversal(root.left);
		postorderTraversal(root.right);
		System.out.print(root.data+"-");
	}
	public static void main(String args[]){
		//Making Binary tree for test
				TreeTraversal t = new TreeTraversal();
				TreeNode2 a1, b1, c1, d1, e1;
				a1 = new TreeNode2(5, null, null);
				b1 = new TreeNode2(4, null, null);
				c1 = new TreeNode2(6, null, null);
				d1 = new TreeNode2(3, null, null);
				e1 = new TreeNode2(7, null, null);
				a1.addLeft(b1);
				a1.addRight(c1);
				b1.addLeft(d1);
				b1.addRight(e1);
				System.out.println("Inorder Traversal");
				t.inorderTraversal(a1);
				System.out.println();
				System.out.println("Preorder Traversal");
				t.preorderTraversal(a1);
				System.out.println();
				System.out.println("Postorder Traversal");
				t.postorderTraversal(a1);
		
	}

}
