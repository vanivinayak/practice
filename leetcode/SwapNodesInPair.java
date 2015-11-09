package leetode50;

import test.ListNode;
/*
 Given a linked list, swap every two adjacent nodes and return its head.
For example,
Given 1->2->3->4, you should return the list as 2->1->4->3.
Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.
----Odd number of nodes, last node shall stay as it is.
 */
public class SwapNodesInPair {
	
	public ListNode swappedPairList(ListNode head){
		ListNode dummy = new ListNode();
		ListNode p = head;
		dummy.next = p;
		ListNode q,r;
		ListNode prev = dummy;
		while(p != null && p.next !=null){
			q = p.next;
			r = p.next.next;
			prev.next = q;
			q.next= p;
			p.next = r;
			prev = p;
			p = r;
		}
		
		return dummy.next;
	}
	
	public static void main (String str[]){
		
		SwapNodesInPair sw = new SwapNodesInPair();
		ListNode n1 = new ListNode(3);
		ListNode n2 = new ListNode(7);
		ListNode n3 = new ListNode(45);
		ListNode n4 = new ListNode(4);	
		ListNode n5 = new ListNode(9);
		//ListNode n6 = new ListNode(19);
		n1.next = n2; n2.next = n3; n3.next = n4; n4.next = n5;n5.next = null; //n6.next = null;
		ListNode res = sw.swappedPairList(n1);
		
		while(res!=null){
			System.out.print(res.val +"->");
			res = res.next;
		}
	}

}
