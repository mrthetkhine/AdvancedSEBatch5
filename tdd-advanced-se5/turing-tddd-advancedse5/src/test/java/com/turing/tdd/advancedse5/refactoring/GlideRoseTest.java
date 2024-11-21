package com.turing.tdd.advancedse5.refactoring;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class GlideRoseTest {

	@ParameterizedTest
	@CsvSource({
		"+5 Dexterity Vest, 10, 20,9,19",
		"Aged Brie, 2, 0,1,1",
		"Elixir of the Mongoose, 5, 7,4,6",
		"Sulfuras Hand of Ragnaros, 0, 80,0,80",
		"Sulfuras Hand of Ragnaros, -1, 80,-1,80",
		"Backstage passes to a TAFKAL80ETC concert, 15, 20,14,21",
		"Backstage passes to a TAFKAL80ETC concert, 10, 49,9,50",
		"Backstage passes to a TAFKAL80ETC concert, 5, 49,4,50",
		"Conjured Mana Cake, 3, 6,2,5"
	    
	})
	public void testGlideRose(String name,int sellIn,int qty,int expectedSellIn,int expectedQty )
	{
		 Item[] items =new Item[] {new Item(name,sellIn,qty)};
		 GildedRose app = new GildedRose(items);
		 int days = 1;
		 for(int i=0;i< days;i++)
		 {
			 app.update();
		 }
		 assertEquals(expectedSellIn, items[0].sellIn);
		 assertEquals(expectedQty, items[0].quality);
	}
}	
