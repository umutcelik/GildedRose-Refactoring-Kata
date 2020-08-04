package com.gildedrose.behaviours;

import com.gildedrose.Item;

public class BackstagePass extends BaseItem {

//    "Backstage passes", like aged brie, increases in Quality as its SellIn value approaches;
//    Quality increases by 2 when there are 10 days or less and by 3 when there are 5 days or less but
//    Quality drops to 0 after the concert
    @Override
    public int getQualityFactor(Item item) {
        if (item.sellIn > 10) {
            return 1;
        } else if (item.sellIn > 5) {
            return 2;
        } else if(item.sellIn < 1){
            return -1 * item.quality;
        }else{
            return 3;
        }
    }

}
