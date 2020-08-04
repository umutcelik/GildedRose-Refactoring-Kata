package com.gildedrose;



class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {


            //rule 1
            if (!item.name.equals("Aged Brie") && !item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                if (hasMinQuality(item)) {
                    if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
                        decreaseQuality(item);
                    }
                }
            } else {
                if (!hasMaxQuality(item)) {
                    increaseQuality(item);

                    if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (item.sellIn < 11) {
                            if (!hasMaxQuality(item)) {
                                increaseQuality(item);
                            }
                        }

                        if (item.sellIn < 6) {
                            if (!hasMaxQuality(item)) {
                                increaseQuality(item);
                            }
                        }
                    }
                }
            }

            //rule 2
            if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
                item.sellIn = item.sellIn - 1;
            }

            //rule 3
            if (item.sellIn < 0) {
                if (!item.name.equals("Aged Brie")) {
                    if (!item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (hasMinQuality(item)) {
                            if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
                                decreaseQuality(item);
                            }
                        }
                    } else {
                        item.quality = item.quality - item.quality;
                    }
                } else {
                    if (!hasMaxQuality(item)) {
                        increaseQuality(item);
                    }
                }
            }
        }
    }


    private void decreaseQuality(Item item) {
        item.quality = item.quality - 1;
    }

    private void increaseQuality(Item item) {
        item.quality = item.quality + 1;
    }

    private boolean hasMaxQuality(Item item) {
        return item.quality >= 50;
    }

    private boolean hasMinQuality(Item item) {
        return item.quality > 0;
    }
}