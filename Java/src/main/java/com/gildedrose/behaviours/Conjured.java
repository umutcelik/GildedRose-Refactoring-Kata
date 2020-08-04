package com.gildedrose.behaviours;

import com.gildedrose.Item;

public class Conjured extends BaseItem {
    private static final int QUALITY_MULTIPLIER = 2;


    //"Conjured" items degrade in Quality twice as fast as normal items
    public int getQualityFactor(Item item) {
        return super.getQualityFactor(item) * QUALITY_MULTIPLIER;
    }


}
