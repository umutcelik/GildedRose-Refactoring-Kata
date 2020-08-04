package com.gildedrose.behaviours;

import com.gildedrose.Item;

public class AgedBrie extends BackstagePass {


    private static final int QUALITY_FACTOR = 1;

    @Override
    public int getQualityFactor(Item item) {
        return QUALITY_FACTOR;
    }

    //"Aged Brie" actually increases in Quality the older it gets
    void addToQuality(Item item, int quality) {
        super.addToQuality(item, item.sellIn < 1 ? quality * 2 : quality);
    }


}
