package com.turing.tdd.advancedse5.tdd.kata;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import com.turing.tdd.advancedse5.delimiter.DelimiterTest;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ExtendWith(MockitoExtension.class)
public class InfixToPostfixTest {
	InfixToPostfixConverter converter = new InfixToPostfixConverter();
	
	@Test
	void testEmptyAndNull()
	{
		
		String postFix = converter.convert(null);
		assertEquals("",postFix);
		
		postFix = converter.convert("");
		assertEquals("",postFix);
	}
	
	@Test
	void testBaseCaseWithNoOperator()
	{
		
		String postFix = converter.convert("ab");
		assertEquals("ab",postFix);
	}
	@Test
	void testBaseCaseWithOperator()
	{
		
		String postFix = converter.convert("a+b");
		assertEquals("ab+",postFix);
	}
}
