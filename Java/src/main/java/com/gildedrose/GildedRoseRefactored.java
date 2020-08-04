package com.gildedrose;


import com.gildedrose.behaviours.BaseItem;

public class GildedRoseRefactored {
    public Item[] items;

    public GildedRoseRefactored(Item[] items) {
        this.items = items;
    }

    Factory factory = new Factory();

    public void updateQuality() {
        for (Item item : items) {

            final BaseItem baseItem = factory.getItem(item);
            baseItem.updateDay(item);

        }
    }
}