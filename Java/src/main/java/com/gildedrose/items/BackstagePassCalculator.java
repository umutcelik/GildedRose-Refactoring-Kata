package com.gildedrose.items;

import com.gildedrose.Item;

public class BackstagePassCalculator implements Calculator {

    public static final int SINGLE_INCREASE_DAY_LIMIT = 10;
    public static final int DOUBLE_INCREASE_DAY_LIMIT = 5;
    public static final int EXPIRE_DAY_LIMIT = 1;

    //"Backstage passes", like aged brie, increases in Quality as its SellIn value approaches;
    //Quality increases by 2 when there are 10 days or less and by 3 when there are 5 days or less but
    //Quality drops to 0 after the concert
    @Override
    public int getQualityFactor(Item item) {
        if (item.sellIn > SINGLE_INCREASE_DAY_LIMIT) {
            return 1;
        } else if (item.sellIn > DOUBLE_INCREASE_DAY_LIMIT) {
            return 2;
        } else if (item.sellIn < EXPIRE_DAY_LIMIT) {
            return -1 * item.quality;
        } else {
            return 3;
        }
    }

}
