package com.gildedrose;

import com.gildedrose.behaviours.AgedBrie;
import com.gildedrose.behaviours.BackstagePass;
import com.gildedrose.behaviours.BaseItem;
import com.gildedrose.behaviours.Conjured;
import com.gildedrose.behaviours.DefaultItem;
import com.gildedrose.behaviours.Sulfuras;

public class Factory {

    public BaseItem getItem(Item item) {
        if (item.name.equals("Sulfuras, Hand of Ragnaros")) {
            return new Sulfuras();
        }
        if (item.name.equals("Aged Brie")) {
            return new AgedBrie();
        }
        if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
            return new BackstagePass();
        }
        if (item.name.startsWith("Conjured")) {
            return new Conjured();
        }

        return new DefaultItem();
    }
}
