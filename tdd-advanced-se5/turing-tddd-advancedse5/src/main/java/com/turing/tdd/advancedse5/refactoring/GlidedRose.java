package com.turing.tdd.advancedse5.refactoring;

import lombok.extern.slf4j.Slf4j;

@Slf4j
class GildedRose {
   
	Item[] items;

    public GildedRose(Item[] items) {
    	ItemFactory factory = new ItemFactory();
        for(int i=0;i< items.length;i++)
        {
        	items[i] = factory.createItem(items[i]);
        }
        this.items = items;
        //log.info("At contructor "+  this.items);
    }

    public void update() {
    	//log.info("Items "+items);
        for (Item item: items) {
            //log.info("item "+item);
            item.update();
        }
    }

   
}