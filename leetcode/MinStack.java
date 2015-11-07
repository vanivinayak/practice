package leetode50;

import java.util.Stack;

class MinStack {
	   private Stack<Integer> stack = new Stack<>();
	   private Stack<Integer> minStack = new Stack<>();
	   public void push(int x) {
	      stack.push(x);
	      if (minStack.isEmpty() || x <= minStack.peek()) {
	         minStack.push(x);
	      }
	}
	   public void pop() {
	      if (stack.pop().equals(minStack.peek())) minStack.pop();
	}
	   public int top() {
	      return stack.peek();
	}
	   public int getMin() {
	      return minStack.peek();
	} 

	   public static void main(String args[]){
		   MinStack ms = new MinStack();
		   ms.push(1);
		   ms.push(4);
		   ms.push(3);
		   ms.push(0);
		   ms.push(3);
		   
		   System.out.println("----");
		   ms.pop();
		   ms.pop();
		   
	   } 
}
