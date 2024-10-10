package com.turing.tdd.advancedse5.delimiter;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import com.turing.tdd.advancedse5.tdd.MockitoExplanatoryTest;


import lombok.extern.slf4j.Slf4j;


/*
 * 
 *  c[d]
	a{b[c]d}e
	a{b(c]d}e
	a[b{c}d]e}  // not correct; nothing matches final }
	a{b(c)      // not correct; Nothing matches opening
 * */
@Slf4j
public class DelimiterTest {

	  Delimiter delimiter = new Delimiter();
	  
	  @DisplayName("Test for empty case")
	  @Test
	  void testEmptyCase()
	  {
		  assertTrue(delimiter.isBalance(""));
		  assertTrue(delimiter.isBalance(null));
	  }
	  
	
	  @DisplayName("Test for all negative case")
	  @ParameterizedTest
	  @ValueSource(strings = {"a{","a}", "a[b}", "a[b]}"})
	  void testNegativeCaseWithParameters(String input) {
			System.out.println("Test testNegativeCaseWithParameters "+input);
			assertFalse(delimiter.isBalance(input)); 
	  }
	  @ParameterizedTest
	  @ValueSource(strings = {"c[d]","a{[b]}","a{c[b]d}"})
	  void testPositiveCase(String input) {
			System.out.println("Test testPositiveCase "+input);
			assertTrue(delimiter.isBalance(input));  
	  }
	  
	  @Test
	  public void testNumericalOverflow()
	  {
		  int a = 2147483647;
		  a++;
		  log.info("A " +a);
	  }
	 
}
