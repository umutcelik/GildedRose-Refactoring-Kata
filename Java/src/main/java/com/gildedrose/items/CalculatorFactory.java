package com.gildedrose.items;

import com.gildedrose.Item;

public class CalculatorFactory {

    public Calculator getItem(Item item) {
        if (item.name.equals("Sulfuras, Hand of Ragnaros")) {
            return new Sulfuras();
        }
        if (item.name.equals("Aged Brie")) {
            return new AgedBrieCalculator();
        }
        if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
            return new BackstagePassCalculator();
        }
        if (item.name.startsWith("Conjured")) {
            return new ConjuredCalculator();
        }

        return new DefaultCalculator();
    }
}
