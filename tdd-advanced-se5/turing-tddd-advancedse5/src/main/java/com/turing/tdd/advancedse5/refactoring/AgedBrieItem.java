package com.turing.tdd.advancedse5.refactoring;

public class AgedBrieItem extends Item {

	public AgedBrieItem(String name, int sellIn, int quality) {
		super(name, sellIn, quality);

	}

	void updateQuality() {
		if (this.quality < MAX_QTY_LIMIT) {
			this.quality = this.quality + 1;

		}
	}

	void updateQualityWhenSellInLow() {
		if (this.sellIn < 0)
		{
			if (this.quality < MAX_QTY_LIMIT) {
	            this.quality = this.quality + 1;
	        }
		}
		
	}
}
