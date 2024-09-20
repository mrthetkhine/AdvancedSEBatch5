package com.turing.tdd.advancedse5.delimiter;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

/*
 * 
 *  c[d]
	a{b[c]d}e
	a{b(c]d}e
	a[b{c}d]e}  // not correct; nothing matches final }
	a{b(c)      // not correct; Nothing matches opening
 * */
public class DelimiterTest {

	  Delimiter delimiter = new Delimiter();
	  @Test
	  void testEmptyCase()
	  {
		  assertTrue(delimiter.isBalance(""));
		  assertTrue(delimiter.isBalance(null));
	  }
	  @Test
	  void testSimplePositiveCase()
	  {
		  String input ="c[d]";
		  assertTrue(delimiter.isBalance(input));
	  }
	  
	  @Test
	  void testNegativeCase()
	  {
		  String input ="a{";
		  assertFalse(delimiter.isBalance(input));  
	  }
}
