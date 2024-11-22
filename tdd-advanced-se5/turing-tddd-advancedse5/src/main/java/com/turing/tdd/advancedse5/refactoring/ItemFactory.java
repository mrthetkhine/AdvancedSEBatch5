package com.turing.tdd.advancedse5.refactoring;

public class ItemFactory {
	private static final String SULFURAS = "Sulfuras Hand of Ragnaros";
	private static final String BACKSTAGE = "Backstage passes to a TAFKAL80ETC concert";
	private static final String AGED_BRIE = "Aged Brie";
	
	Item createItem(Item item)
	{
		if(AGED_BRIE.equals(item.name))
		{
			return new AgedBrieItem(item.name, item.sellIn, item.quality);
		}
		else if(BACKSTAGE.equals(item.name))
		{
			return new BackstageItem(item.name, item.sellIn, item.quality);
		}
		else if(SULFURAS.equals(item.name))
		{
			return new Sulfuras(item.name, item.sellIn, item.quality);
		}
		else
		{
			return item;
		}
	}
}
