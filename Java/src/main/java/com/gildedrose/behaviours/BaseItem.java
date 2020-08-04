package com.gildedrose.behaviours;

import com.gildedrose.Item;

public abstract class BaseItem {

    int MAX_QUALITY = 50;
    int MIN_QUALITY = 0;

    private static final int SELL_IN_FACTOR = -1;


    public void updateDay(Item item) {
        updateQuality(item);
        updateSellIn(item);
    }

    void updateQuality(Item item) {
        addToQuality(item, getQualityFactor(item));
    }


    void addToQuality(Item item, int quality) {
        //The Quality of an item is never negative &&

//        if (item.quality + quality >= MIN_QUALITY && (item.quality + quality <= MAX_QUALITY)) {
//            item.quality = Integer.min(item.quality + quality, MAX_QUALITY);
//        }

        if (quality > 0) {
            increaseQuality(item, quality);
        } else {
            descreaseQuality(item, quality);
        }
    }

    void increaseQuality(Item item, int quality) {
        if (item.quality < 50) {
            //The Quality of an item is never more than 50
            item.quality = Math.min(item.quality + quality, MAX_QUALITY);
        }
    }

    void descreaseQuality(Item item, int quality) {
        item.quality = Math.max(item.quality + quality, MIN_QUALITY);
    }

    //once the sell by date has passed, Quality degrades twice as fast
    int getQualityFactor(Item item) {
        return item.sellIn < 1 ? -2 : -1;
    }

    void updateSellIn(Item item) {
        item.sellIn = item.sellIn + getSellInFactor();
    }

    int getSellInFactor() {
        return SELL_IN_FACTOR;
    }

    ;
}
