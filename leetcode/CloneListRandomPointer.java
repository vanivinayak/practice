package leetode50;

import java.util.HashMap;
import java.util.Map;

/*
 A linked list is given such that each node contains an additional random pointer that could point to any node in the list or null.
Return a deep copy of the list.
 */
class MyNode{
	public int data;
	public MyNode next;
	public MyNode randomNext;
	
}
public class CloneListRandomPointer {

	public static void main(String args[]){
		
		MyNode n1,n2,n3,n4;
		n1 = new MyNode(); n1.data = 1;
		n2 = new MyNode(); n2.data = 2;
		n3 = new MyNode(); n3.data = 3;
		n4 = new MyNode(); n4.data = 4;
		n1.next = n2; n2.next = n3; n3.next = n4; n4.next = null;
		n1.randomNext = n3; n2.randomNext = n4; n3.randomNext = null; n4.randomNext = n1;
		CloneListRandomPointer cl = new CloneListRandomPointer();
		MyNode res1 = cl.createClonedList(n1);
		MyNode res = res1;
		while(res!=null){
			System.out.print("data="+res.data);
			if(res.next != null) System.out.print(" next= "+res.next.data);
			if(res.randomNext != null) System.out.print(" Random Next= "+res.randomNext.data);
			res = res.next;
			System.out.println();
		}
		
		System.out.println("~~~~Original List Modified~~~");
		n1.next = null;
		System.out.println("----Cloned List----");
		while(res1!=null){
			System.out.print("data="+res1.data);
			if(res1.next != null) System.out.print(" next= "+res1.next.data);
			if(res1.randomNext != null) System.out.print(" Random Next= "+res1.randomNext.data);
			res1 = res1.next;
			System.out.println();
		}
	} 
	
	public MyNode createClonedList(MyNode head){
		MyNode dummyHead = new MyNode();
		MyNode p = head;
		MyNode ptr;
		ptr = dummyHead;
		if(head == null) return null;
		Map<Integer, MyNode> map = new HashMap<Integer, MyNode>();
		//first traversal - to create clone nodes and put them to map 
		while(p!=null){
			MyNode newNode = new MyNode();
			newNode.data = p.data;
			map.put(p.data, newNode);
			p = p.next;
		}
		p = head;
		//second traversal - create cloned list 
		while(p != null){
			int val = p.data;
			MyNode node = map.get(val);
			node.next = (p.next != null)? map.get(p.next.data):null;
			node.randomNext = (p.randomNext != null) ? map.get(p.randomNext.data) : null;
			ptr.next = node;
			ptr = ptr.next;
			p = p.next;
		}
		
		return dummyHead.next;
		
	}
}


