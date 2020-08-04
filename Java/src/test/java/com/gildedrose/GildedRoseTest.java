package com.gildedrose;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class GildedRoseTest {


    @Test
    void foo() {
        Item[] items = new Item[] {new Item("foo", 0, 0)};
        GildedRose app = new GildedRose(items);
        app = new GildedRose(items);
        app.updateQuality();
        assertEquals("foo", app.items[0].name);
    }

    @Test
    public void defaultItemDecreasesSellIn() {
        GildedRose app = newGildedRoseRefactored("default item", 0, 0);

        app.updateQuality();

        assertEquals(-1, getSellIn(app));
    }

    @Test
    public void brieIncreaseQuality() {
        GildedRose app = newGildedRoseRefactored("Aged Brie", 1, 1);

        app.updateQuality();

        assertEquals(0, getSellIn(app));
        assertEquals(2, getQuality(app));
    }

    @Test
    public void brieQualityMax() {
        GildedRose app = newGildedRoseRefactored("Aged Brie", 1, 49);

        app.updateQuality();
        assertItem(app, 0, 50);

        app.updateQuality();
        assertItem(app, -1, 50);
    }

    @Test
    public void brieStartingConditions() {
        GildedRose app = newGildedRoseRefactored("Aged Brie", 2, 0);

        app.updateQuality();

        assertEquals(1, getQuality(app));
    }

    @Test
    public void brieSecondDay() {
        GildedRose app = newGildedRoseRefactored("Aged Brie", 1, 1);

        app.updateQuality();

        assertEquals(0, getSellIn(app));
        assertEquals(2, getQuality(app));
    }

    @Test
    public void brieThirdDay() {
        GildedRose app = newGildedRoseRefactored("Aged Brie", 0, 2);

        app.updateQuality();

        assertItem(app, -1, 4);
    }

    @Test
    public void brieFourthDay() {
        GildedRose app = newGildedRoseRefactored("Aged Brie", -1, 4);

        app.updateQuality();

        assertItem(app, -2, 6);
    }

    @Test
    public void backstagePassesDecreaseQualityMoreThanTenDays() {
        GildedRose app = newGildedRoseRefactored("Backstage passes to a TAFKAL80ETC concert", 12, 1);

        app.updateQuality();

        assertEquals(11, getSellIn(app));
        assertEquals(2, getQuality(app));
    }

    @Test
    public void backstagePassesDecreaseQualityMoreTenDays() {
        GildedRose app = newGildedRoseRefactored("Backstage passes to a TAFKAL80ETC concert", 10, 1);

        app.updateQuality();

        assertEquals(9, getSellIn(app));
        assertEquals(3, getQuality(app));
    }

    @Test
    public void backstagePassesDecreaseQualityMoreFiveDays() {
        GildedRose app = newGildedRoseRefactored("Backstage passes to a TAFKAL80ETC concert", 5, 1);

        app.updateQuality();

        assertEquals(4, getSellIn(app));
        assertEquals(4, getQuality(app));
    }

    @Test
    public void backstagePassesItemExpires() {
        GildedRose app = newGildedRoseRefactored("Backstage passes to a TAFKAL80ETC concert", 0, 50);

        app.updateQuality();

        assertItem(app, -1, 0);
    }

    @Test
    public void backstagePassesItemMaxQuality() {
        GildedRose app = newGildedRoseRefactored("Backstage passes to a TAFKAL80ETC concert", 5, 50);

        app.updateQuality();

        assertEquals(4, getSellIn(app));
        assertEquals(50, getQuality(app));
    }

    @Test
    public void backstagePassesFirstDay() {
        GildedRose app = newGildedRoseRefactored("Backstage passes to a TAFKAL80ETC concert", 10, 49);

        app.updateQuality();

        assertEquals(9, getSellIn(app));
        assertEquals(50, getQuality(app));
    }

    @Test
    public void backstagePassesSecondDay() {
        GildedRose app = newGildedRoseRefactored("Backstage passes to a TAFKAL80ETC concert", 9, 50);

        app.updateQuality();

        assertEquals(8, getSellIn(app));
        assertEquals(50, getQuality(app));
    }

    @Test
    public void defaultItemDecreasesQuality() {
        GildedRose app = newGildedRoseRefactored("foo", 2, 1);

        app.updateQuality();

        assertEquals(1, getSellIn(app));
        assertEquals(0, getQuality(app));
    }

    @Test
    public void defaultItemDecreasesQualitySellInLessThanZero() {
        GildedRose app = newGildedRoseRefactored("foo", 0, 5);

        app.updateQuality();

        assertItem(app, -1, 3);
    }

    @Test
    public void defaultItemQualityBelowZero() {
        GildedRose app = newGildedRoseRefactored("foo", 0, 0);

        app.updateQuality();

        assertItem(app, -1, 0);
    }

    @Test
    public void sulfurasFixeQuality() {
        GildedRose app = newGildedRoseRefactored("Sulfuras, Hand of Ragnaros", 1, 80);

        assertEquals(1, getSellIn(app));
        assertEquals(80, getQuality(app));

    }

    @Test
    public void conjuredItemDecrease() {
        GildedRose app = newGildedRoseRefactored("Conjured", 2, 5);

        app.updateQuality();

        assertEquals(1, getSellIn(app));
        assertEquals(3, getQuality(app));
    }

    @Test
    public void conjuredItemDecreaseFiveDays() {
        GildedRose app = newGildedRoseRefactored("Conjured", 0, 5);

        app.updateQuality();

        assertItem(app, -1, 1);
    }

    @Test
    public void conjuredItemDecreaseMinQuality() {
        GildedRose app = newGildedRoseRefactored("Conjured", 0, 0);

        app.updateQuality();

        assertItem(app, -1, 0);
    }

    private void assertItem(GildedRose app, int sellIn, int quality) {
        assertEquals(sellIn, getSellIn(app));
        assertEquals(quality, getQuality(app));
    }

    private GildedRose newGildedRoseRefactored(String itemName, int itemSellIn, int itemQuality) {
        Item[] items = new Item[] {new Item(itemName, itemSellIn, itemQuality)};
        return new GildedRose(items);
    }

    private int getSellIn(GildedRose app) {
        return app.items[0].sellIn;
    }

    private int getQuality(GildedRose app) {
        return app.items[0].quality;
    }

}
