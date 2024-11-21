package com.turing.tdd.advancedse5.refactoring;

public class Item {
    private static final int MIN_QTY_LIMIT = 0;
	private static final int MAX_QTY_LIMIT = 50;
    public String name;

    public int sellIn;

    public int quality;

    public Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }
    void update()
    {
    	this.updateQuality();
    	this.updateSellIn();
    	this.updateQualityWhenSellInLow();
    }
    void updateQuality()
    {
    	if(this.quality>MIN_QTY_LIMIT)
		{
			 this.quality = this.quality - 1;
		}
    }
    void updateSellIn()
    {
    	this.sellIn = this.sellIn - 1;
    }
    void updateQualityWhenSellInLow()
    {
    	if (this.quality > 0) {
			this.quality = this.quality - 1;
        }
    }
   @Override
   public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }
}