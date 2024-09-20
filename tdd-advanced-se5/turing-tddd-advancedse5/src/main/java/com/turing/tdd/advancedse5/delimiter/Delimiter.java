package com.turing.tdd.advancedse5.delimiter;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Delimiter {

	private List<Character> startDelimiter = new ArrayList<>();
	private List<Character> endDelimiter = new ArrayList<>();
	private Stack<Character> delimiter =new Stack<>();
	
	Delimiter()
	{
		this.startDelimiter.add('[');
		this.endDelimiter.add(']');
		
		this.startDelimiter.add('{');
		this.endDelimiter.add('}');
		
	}
	private boolean isStarterDelimiter(Character ch)
	{
		return this.startDelimiter.contains(ch);
	}
	private boolean isEndDelimiter(Character ch)
	{
		return this.endDelimiter.contains(ch);
	}
	private boolean isPair(Character start, Character end)
	{
		int startIndex = this.startDelimiter.indexOf(start);
		int endIndex = this.endDelimiter.indexOf(end);
		return startIndex == endIndex ;
	}
	public boolean isBalance(String input) {
		
		if(null== input || input.equals(""))
		{
			return true;
		}
		else
		{
			for(int i=0;i< input.length();i++)
			{
				char ch = input.charAt(i);
				if(this.isStarterDelimiter(ch))
				{
					this.delimiter.push(ch);
				}
				if(this.isEndDelimiter(ch))
				{
					Character topElement = this.delimiter.pop();
					if(! this.isPair(topElement, ch))
					{
						return false;
					}
				}
				
			}
			return this.delimiter.isEmpty();
		}
		
	}

}
