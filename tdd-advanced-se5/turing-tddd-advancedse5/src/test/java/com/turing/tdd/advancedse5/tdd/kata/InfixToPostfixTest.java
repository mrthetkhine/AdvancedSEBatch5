package com.turing.tdd.advancedse5.tdd.kata;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
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
	@ParameterizedTest
	@MethodSource("baseCaseProvider")
	void testBaseCaseWithOperator(String infix, String postFix) {
		String result = converter.convert(infix);
		assertEquals(postFix,result);
	}

	static Stream<Arguments> baseCaseProvider() {
	    return Stream.of(
	        arguments("a+b", "ab+"),
	        arguments("2+3", "23+")
	    );
	}
	
	@ParameterizedTest
	@MethodSource("baseCaseProviderWithMultipleOperator")
	void testBaseCaseWithMultipleOperator(String infix, String postFix) {
		String result = converter.convert(infix);
		assertEquals(postFix,result);
	}

	static Stream<Arguments> baseCaseProviderWithMultipleOperator() {
	    return Stream.of(
	        arguments("a+b+c", "ab+c+"),
	        arguments("a*b+c", "ab*c+"),
	        arguments("a+b*c", "abc*+"),
	        arguments("2*3+c", "23*c+")
	    );
	}
	@ParameterizedTest
	@MethodSource("caseProviderWithMultipleOperatorAndParenthesis")
	void testBaseCaseWithParenthesisMultipleOperator(String infix, String postFix) {
		String result = converter.convert(infix);
		assertEquals(postFix,result);
	}

	static Stream<Arguments> caseProviderWithMultipleOperatorAndParenthesis() {
	    return Stream.of(
	        arguments("a*(b+c)", "abc+*"),
	        arguments("(a+b)*(c+d)", "ab+cd+*")
	       
	    );
	}
	
}
