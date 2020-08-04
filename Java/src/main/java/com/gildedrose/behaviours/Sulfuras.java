package com.gildedrose.behaviours;

import com.gildedrose.Item;

public class Sulfuras extends BaseItem {

    //"Sulfuras", being a legendary item, never has to be sold or decreases in Quality
    @Override
    public int getQualityFactor(Item item) { return 0; }

    //"Sulfuras", being a legendary item, never has to be sold or decreases in Quality
    @Override
    public int getSellInFactor() {
        return 0;
    }
}
