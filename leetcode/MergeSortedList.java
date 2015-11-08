package leetode50;

import test.ListNode;

public class MergeSortedList {
	
	public ListNode mergeSortedLists(ListNode l1, ListNode l2){
		ListNode newHead = new ListNode(0);
		ListNode p = newHead;
		if(l1==null && l2==null) return null;
		if (l1==null && l2 != null) return l2;
		if (l1!=null && l2 == null) return l1;
		
		while(l1!=null && l2!=null){
			if(l1.val < l2.val){
				p.next = l1;
				l1 = l1.next;
			} else {
				p.next = l2;
				l2 = l2.next;
			}
			p = p.next;
		}
		
		if(l1!=null){
			p.next =l1;
		}
		if(l2!=null){
			p.next = l2;
		}
		return newHead.next;
	}
	//try test function
	/*public ListNode mergeSortedLists2(ListNode l1, ListNode l2){
		ListNode newHead = new ListNode(0);
		ListNode p1;
		ListNode p2;
		if(l1==null && l2==null) return null;
		if (l1==null && l2 != null) return l2;
		if (l1!=null && l2 == null) return l1;
		ListNode temp;
		p1 = l1;
		p2 = l2;
		while(l1!=null && l2!=null){
			if(l1.val < l2.val){
				temp = p1.next;
				p1.next = p2;
				p1 = temp;
				p2 = p2.next;
			} else {
				temp = p2.next;
				p2.next = p1;
				p2 = temp;
				p1 = p1.next;
			}
		
		}
		
		if(l1!=null){
			//p.next =l1;
		}
		if(l2!=null){
			//p.next = l2;
		}
		return newHead.next;
	}*/
	public static void main (String str[]){
		/*ListNode n1 = new ListNode(3);
		ListNode n2 = new ListNode(7);
		ListNode n3 = new ListNode(45);
		n1.next = n2; n2.next = n3; n3.next = null;
		ListNode n4 = new ListNode(4);
		ListNode n5 = new ListNode(6);
		ListNode n6 = new ListNode(33);
		n4.next = n5; n5.next = n6; n6.next = null;*/
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(5);
		ListNode n3 = new ListNode(7);
		n1.next = n2; n2.next = n3; n3.next = null;
		ListNode n4 = new ListNode(2);
		ListNode n5 = new ListNode(4);
		ListNode n6 = new ListNode(8);
		n4.next = n5; n5.next = n6; n6.next = null;
		ListNode res = new ListNode();
		MergeSortedList msl = new MergeSortedList();
		res = msl.mergeSortedLists(n1, n4);
		
		while(res!=null){
			System.out.print(res.val +"->");
			res = res.next;
		}
		
	}

}
