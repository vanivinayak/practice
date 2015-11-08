package leetode50;
import test.ListNode;
public class CloneList {
	
	//this method will return the head to a cloned list
	//which is a deep copy of the given list
	//Deep copy- even after original list is modified, deep copy stays the same
	public ListNode cloneMyList(ListNode head){
		ListNode dummy = new ListNode();
		ListNode p = head;
		ListNode q = new ListNode();
		dummy = q;
		while(p!=null){ //while node of original list is not null keep reading it to create clone nodes
			ListNode temp = new ListNode(p.val); // create a new node with the value same as original node 
			q.next = temp; //link the recently added node of clone list to this new node (this takes care of the next pointer of the clone list)
			q=q.next; // increment the pointer of clone list
			p=p.next; //increment the pointer to next for reading next node
		}
		
		return dummy.next;
	}
	
	public static void main (String str[]){
		ListNode n1 = new ListNode(3);
		ListNode n2 = new ListNode(7);
		ListNode n3 = new ListNode(45);
		n1.next = n2; n2.next = n3; n3.next = null;
		
		CloneList cl = new CloneList();
		ListNode res = cl.cloneMyList(n1);
		ListNode res2 = res;
		
		while(res!=null){
			System.out.print(res.val +"->");
			res = res.next;
		}
		System.out.println();
		n1.next = null;
		System.out.println("modified list");
		while(n1!=null){
			System.out.print(n1.val +"->");
			n1 = n1.next;
		}
		System.out.println();
		System.out.println("after manipulating existing list--- check if deep copy is maintained");
		while(res2!=null){
			System.out.print(res2.val +"->");
			res2 = res2.next;
		}
	}

}
