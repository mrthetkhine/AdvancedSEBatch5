package com.turing.tdd.advancedse5.refactoring;

class GildedRose {
    private static final int MIN_QTY_LIMIT = 0;
	private static final int MAX_QTY_LIMIT = 50;
	private static final String SULFURAS = "Sulfuras Hand of Ragnaros";
	private static final String BACKSTAGE = "Backstage passes to a TAFKAL80ETC concert";
	private static final String AGED_BRIE = "Aged Brie";
	Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void update() {
        for (Item item: items) {
            
            updateQuality(item);
            updateSellIn(item);
            updateQualityWhenSellInLow(item);
        }
    }

	private void updateQuality(Item item) {
		if( AGED_BRIE.equals(item.name) || BACKSTAGE.equals(item.name))
		{
			if (item.quality < MAX_QTY_LIMIT) {
		        item.quality = item.quality + 1;

		        if (item.name.equals(BACKSTAGE)) {
		            updateQualityForBackStage(item);
		        }
		    }
		}
		else if(SULFURAS.equals(item.name))
		{
			//Do nothing
		}
		else
		{
			item.updateQuality();
				
		}
	}

	private void updateQualityForBackStage(Item item) {
		if (item.sellIn < 11) {
		    if (item.quality < MAX_QTY_LIMIT) {
		        item.quality = item.quality + 1;
		    }
		}

		if (item.sellIn < 6) {
		    if (item.quality < MAX_QTY_LIMIT) {
		        item.quality = item.quality + 1;
		    }
		}
	}
	private void updateSellIn(Item item) {
		if (item.name.equals(SULFURAS)) {
		   //do nothing
		}
		else
		{
			item.updateSellIn();
		}
	}
	private void updateQualityWhenSellInLow(Item item) {
		if (item.sellIn < 0) {
			if( AGED_BRIE.equals(item.name))
			{
				if (item.quality < MAX_QTY_LIMIT) {
		            item.quality = item.quality + 1;
		        }
			}
			else if(BACKSTAGE.equals(item.name))
			{
				item.quality =0;
			}
			else if(SULFURAS.equals(item.name))
			{
				//Do nothing
			}
			else
			{
				item.updateQualityWhenSellInLow();
			}
		    
		}
	}
}