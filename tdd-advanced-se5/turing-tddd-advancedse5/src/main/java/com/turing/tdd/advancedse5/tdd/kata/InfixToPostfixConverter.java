package com.turing.tdd.advancedse5.tdd.kata;

import java.util.HashMap;
import java.util.Stack;

public class InfixToPostfixConverter {
	HashMap<Character,Integer> precedences = new HashMap<>();
	
	InfixToPostfixConverter()
	{
		//+,- -> 1
		this.precedences.put('+', 1);
		this.precedences.put('-', 1);
		this.precedences.put('*', 2);
		this.precedences.put('/', 2);
		this.precedences.put('%', 2);
		this.precedences.put('(', 3);
		this.precedences.put(')', 3);
		
	}
	boolean isPrecedenceGte(Character op1,Character op2)
	{
		Integer p1 = this.precedences.get(op1);
		Integer p2 = this.precedences.get(op2);
		return p1>=p2;
	}
	boolean isOperator(char ch)
	{
		return ch=='+' || ch=='-' || ch=='*' || ch=='/' || ch=='%';
	}
	boolean isOperand(char ch)
	{
		return Character.isLetterOrDigit(ch);
	}
	public String convert(String infix)
	{
		
		if(infix == null || "".equals(infix))
		{
			return "";
		}
		else
		{
			return covertNonEmpty(infix);
		}
	}
	private String covertNonEmpty(String infix) {
		Stack<Character> stack = new Stack<>();
		String postFix = "";
		for(int i=0;i< infix.length();i++)
		{
			char current = infix.charAt(i);
			if(this.isOperand(current))
			{
				postFix += current;
			}
			else if( current=='(')
			{
				stack.push(current);
			}
			else if( current==')')
			{
				
				while( !stack.empty() && (stack.peek() != '('))
				{
					postFix += stack.pop();
				}
				if(!stack.isEmpty() && stack.peek() =='(')
				{
					stack.pop();
				}
			}
			else if(this.isOperator(current))
			{
				if(!stack.empty() && stack.peek()=='(')
				{
					stack.push(current);
				}
				else
				{
					while( !stack.empty() &&  this.isPrecedenceGte( stack.peek(),current))
					{
						//append operator
						postFix += stack.pop();	
					}
					stack.push(current);
				}
				
			}
			
		}
		while(!stack.isEmpty())
		{
			postFix += stack.pop();
		}
		return postFix;
	}
}
