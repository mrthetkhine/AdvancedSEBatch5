package com.turing.tdd.advancedse5.tdd.kata;

import java.util.Stack;

public class InfixToPostfixConverter {
	boolean isOperator(char ch)
	{
		return ch=='+' || ch=='-' || ch=='*' || ch=='/';
	}
	public String convert(String infix)
	{
		Stack<Character> stack = new Stack<Character>();
		if(infix == null || "".equals(infix))
		{
			return "";
		}
		else
		{
			String postFix = "";
			for(int i=0;i< infix.length();i++)
			{
				char current = infix.charAt(i);
				if(this.isOperator(current))
				{
					stack.push(current);
				}
				else //operand
				{
					postFix += current;
				}
			}
			while(!stack.isEmpty())
			{
				postFix += stack.pop();
			}
			return postFix;
		}
	}
}
