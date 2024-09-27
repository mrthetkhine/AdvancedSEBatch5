package com.turing.tdd.advancedse5.tdd;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.junit.jupiter.MockitoExtension;

import lombok.extern.slf4j.Slf4j;

@ExtendWith(MockitoExtension.class)
@Slf4j
public class TestParameterizedTest {
	@ParameterizedTest
	@ValueSource(ints = {1,2,3,4})
	void testIntegerParameter(int input) {
		log.info("Test testPositiveCase "+input);
		assertTrue(input>0);  
	}
	@ParameterizedTest
	@MethodSource("stringProvider")
	void testWithExplicitLocalMethodSource(String argument) {
		log.info("StringProvider Test " +argument);
	    assertNotNull(argument);
	}

	static Stream<String> stringProvider() {
	    return Stream.of("apple", "banana");
	}
	@ParameterizedTest
	@MethodSource("range")
	void testWithRangeMethodSource(int argument) {
		log.info("Range "+argument);
	    assertNotEquals(9, argument);
	}

	static IntStream range() {
	    return IntStream.range(0, 20).skip(10);
	}
	@ParameterizedTest
	@MethodSource("stringIntAndListProvider")
	void testWithMultiArgMethodSource(String str, int num, List<String> list) {
	    assertEquals(5, str.length());
	    assertTrue(num >=1 && num <=2);
	    assertEquals(2, list.size());
	}

	static Stream<Arguments> stringIntAndListProvider() {
	    return Stream.of(
	        arguments("apple", 1, Arrays.asList("a", "b")),
	        arguments("lemon", 2, Arrays.asList("x", "y"))
	    );
	}
	@ParameterizedTest
	@CsvSource({
	    "apple,         1",
	    "banana,        2",
	    "'lemon, lime', 0xF1",
	    "strawberry,    200"
	})
	void testWithCsvSource(String fruit, int rank) {
	    assertNotNull(fruit);
	    assertNotEquals(0, rank);
	}

}
