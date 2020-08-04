package com.gildedrose.items;

import com.gildedrose.Item;

public class AgedBrieCalculator extends BackstagePassCalculator {

    //"Aged Brie" actually increases in Quality the older it gets
    @Override
    public void updateQuality(Item item) {
        final int quality = getQualityFactor(item);
        increaseQuality(item, quality);
    }

    //"Aged Brie" actually increases in Quality the older it gets
    @Override
    public int getQualityFactor(Item item) {
        return item.sellIn < 1 ? 2 : 1;
    }
}
