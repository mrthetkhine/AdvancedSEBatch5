package com.turing.tdd.advancedse5.refactoring;

public class BackstageItem extends Item {

	public BackstageItem(String name, int sellIn, int quality) {
		super(name, sellIn, quality);
		// TODO Auto-generated constructor stub
	}
	void updateQuality()
    {
		if (this.quality < MAX_QTY_LIMIT) {
	        this.quality = this.quality + 1;

	        updateQualityForBackStage();
	    }
    }
	private void updateQualityForBackStage() {
		if (this.sellIn < 11) {
		    if (this.quality < MAX_QTY_LIMIT) {
		    	this.quality = this.quality + 1;
		    }
		}

		if (this.sellIn < 6) {
		    if (this.quality < MAX_QTY_LIMIT) {
		    	this.quality = this.quality + 1;
		    }
		}
	}
	
	
    void updateQualityWhenSellInLow()
    {
    	if (this.sellIn < 0) {
    		this.quality =0;
		    
		}
    }
	
}
