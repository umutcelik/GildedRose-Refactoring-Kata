package com.gildedrose.items;

import com.gildedrose.Item;

public class ConjuredCalculator implements Calculator {
    private static final int QUALITY_MULTIPLIER = 2;


    //"Conjured" items degrade in Quality twice as fast as normal items
    public int getQualityFactor(Item item) {
        return Calculator.super.getQualityFactor(item) * QUALITY_MULTIPLIER;
    }


}
