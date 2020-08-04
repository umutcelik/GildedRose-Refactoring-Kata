package com.gildedrose.items;

import com.gildedrose.Item;

public interface Calculator {

    int MAX_QUALITY = 50;
    int MIN_QUALITY = 0;

    default void updateDay(Item item) {
        updateQuality(item);
        updateSellIn(item);
    }

    default void updateSellIn(Item item) {
        item.sellIn = item.sellIn - 1;
    }

    default void updateQuality(Item item) {
        final int quality = getQualityFactor(item);

        if (quality > 0) {
            increaseQuality(item, quality);
        } else {
            decreaseQuality(item, quality);
        }

    }

    default void increaseQuality(Item item, int quality) {
        if (item.quality < 50) {
            //The Quality of an item is never more than 50
            item.quality = Math.min(item.quality + quality, MAX_QUALITY);
        }
    }

    default void decreaseQuality(Item item, int quality) {
        //The Quality of an item is never negative
        item.quality = Math.max(item.quality + quality, MIN_QUALITY);
    }

    //once the sell by date has passed, Quality degrades twice as fast
    default int getQualityFactor(Item item) {
        return item.sellIn < 1 ? -2 : -1;
    }


}
