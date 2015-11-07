package leetode50;

import java.util.*;

/*
Evaluate the value of an arithmetic expression in Reverse Polish Notation.
Valid operators are +, -, *, /. Each operand may be an integer or another expression.
*/

public class EvaluatePostfix {
	
	public int evaluatePostfixExpression(String[] str){
		int val = 0;
		int result = 0;
		Map<String, Integer> operators = new HashMap<String, Integer>(); 
		operators.put("+", 1);
		operators.put("-", 2);
		operators.put("*", 3);
		operators.put("/", 4);
		Stack<Integer> stack = new Stack<Integer>();
		
		for(int i=0; i< str.length; i++){
			String ch = str[i];
			if(!operators.containsKey(ch)){
				stack.push(Integer.parseInt(ch));
			} else {
				int op1 = stack.pop();
				int op2 = stack.pop();
				int operation = operators.get(ch);
				val = applyOperator(operation, op2, op1);
				stack.push(val);
			}
			
		}
		result = stack.pop();
		return result;
	}
	
	public int applyOperator(int operator, int a, int b){
		int res = 0;
		switch (operator){
		case 1:
			res = a+b; break;
		case 2:
			res = a-b;break;
		case 3:
			res = a*b; break;
		case 4:
			res = a/b; break;
		}
		return res;
	}

	
	 public static void main(String args[])
	 {
		 EvaluatePostfix ep = new EvaluatePostfix();
		 String[] input = {"3","4","+"};
		 System.out.println(ep.evaluatePostfixExpression(input));
	 }
}
