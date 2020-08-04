package com.gildedrose;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class GildedRoseRefactoredTest {


    @Test
    void foo() {
        Item[] items = new Item[] {new Item("foo", 0, 0)};
        GildedRoseRefactored app = new GildedRoseRefactored(items);
        app = new GildedRoseRefactored(items);
        app.updateQuality();
        assertEquals("foo", app.items[0].name);
    }

    @Test
    public void defaultItemDecreasesSellIn() {
        GildedRoseRefactored app = newGildedRoseRefactored("default item", 0, 0);

        app.updateQuality();

        assertEquals(-1, getSellIn(app));
    }

    @Test
    public void brieIncreaseQuality() {
        GildedRoseRefactored app = newGildedRoseRefactored("Aged Brie", 1, 1);

        app.updateQuality();

        assertEquals(0, getSellIn(app));
        assertEquals(2, getQuality(app));
    }

    @Test
    public void brieQualityMax() {
        GildedRoseRefactored app = newGildedRoseRefactored("Aged Brie", 1, 49);

        app.updateQuality();
        assertEquals(0, getSellIn(app));
        assertEquals(50, getQuality(app));

        app.updateQuality();
        assertItem(app, 1, 50);
    }

    @Test
    public void brieStartingConditions() {
        GildedRoseRefactored app = newGildedRoseRefactored("Aged Brie", 2, 0);

        app.updateQuality();

        assertEquals(1, getQuality(app));
    }

    @Test
    public void brieSecondDay() {
        GildedRoseRefactored app = newGildedRoseRefactored("Aged Brie", 1, 1);

        app.updateQuality();

        assertEquals(0, getSellIn(app));
        assertEquals(2, getQuality(app));
    }

    @Test
    public void brieThirdDay() {
        GildedRoseRefactored app = newGildedRoseRefactored("Aged Brie", 0, 2);

        app.updateQuality();

        assertItem(app, 1, 4);
    }

    @Test
    public void brieFourthDay() {
        GildedRoseRefactored app = newGildedRoseRefactored("Aged Brie", -1, 4);

        app.updateQuality();

        assertItem(app, 2, 6);
    }

    @Test
    public void backstagePassesDecreaseQualityMoreThanTenDays() {
        GildedRoseRefactored app = newGildedRoseRefactored("Backstage passes to a TAFKAL80ETC concert", 12, 1);

        app.updateQuality();

        assertEquals(11, getSellIn(app));
        assertEquals(2, getQuality(app));
    }

    @Test
    public void backstagePassesDecreaseQualityMoreTenDays() {
        GildedRoseRefactored app = newGildedRoseRefactored("Backstage passes to a TAFKAL80ETC concert", 10, 1);

        app.updateQuality();

        assertEquals(9, getSellIn(app));
        assertEquals(3, getQuality(app));
    }

    @Test
    public void backstagePassesDecreaseQualityMoreFiveDays() {
        GildedRoseRefactored app = newGildedRoseRefactored("Backstage passes to a TAFKAL80ETC concert", 5, 1);

        app.updateQuality();

        assertEquals(4, getSellIn(app));
        assertEquals(4, getQuality(app));
    }

    @Test
    public void backstagePassesItemExpires() {
        GildedRoseRefactored app = newGildedRoseRefactored("Backstage passes to a TAFKAL80ETC concert", 0, 50);

        app.updateQuality();

        assertItem(app, 1, 0);
    }

    @Test
    public void backstagePassesItemMaxQuality() {
        GildedRoseRefactored app = newGildedRoseRefactored("Backstage passes to a TAFKAL80ETC concert", 5, 50);

        app.updateQuality();

        assertEquals(4, getSellIn(app));
        assertEquals(50, getQuality(app));
    }

    @Test
    public void backstagePassesFirstDay() {
        GildedRoseRefactored app = newGildedRoseRefactored("Backstage passes to a TAFKAL80ETC concert", 10, 49);

        app.updateQuality();

        assertEquals(9, getSellIn(app));
        assertEquals(50, getQuality(app));
    }

    @Test
    public void backstagePassesSecondDay() {
        GildedRoseRefactored app = newGildedRoseRefactored("Backstage passes to a TAFKAL80ETC concert", 9, 50);

        app.updateQuality();

        assertEquals(8, getSellIn(app));
        assertEquals(50, getQuality(app));
    }

    @Test
    public void defaultItemDecreasesQuality() {
        GildedRoseRefactored app = newGildedRoseRefactored("foo", 2, 1);

        app.updateQuality();

        assertEquals(1, getSellIn(app));
        assertEquals(0, getQuality(app));
    }

    @Test
    public void defaultItemDecreasesQualitySellInLessThanZero() {
        GildedRoseRefactored app = newGildedRoseRefactored("foo", 0, 5);

        app.updateQuality();

        assertItem(app, 1, 3);
    }

    @Test
    public void defaultItemQualityBelowZero() {
        GildedRoseRefactored app = newGildedRoseRefactored("foo", 0, 0);

        app.updateQuality();

        assertItem(app, 1, 0);
    }

    @Test
    public void sulfurasFixeQuality() {
        GildedRoseRefactored app = newGildedRoseRefactored("Sulfuras, Hand of Ragnaros", 1, 80);

        assertEquals(1, getSellIn(app));
        assertEquals(80, getQuality(app));

    }

    @Test
    public void conjuredItemDecrease() {
        GildedRoseRefactored app = newGildedRoseRefactored("Conjured", 2, 5);

        app.updateQuality();

        assertEquals(1, getSellIn(app));
        assertEquals(3, getQuality(app));
    }

    @Test
    public void conjuredItemDecreaseFiveDays() {
        GildedRoseRefactored app = newGildedRoseRefactored("Conjured", 0, 5);

        app.updateQuality();

        assertItem(app, 1, 1);
    }

    @Test
    public void conjuredItemDecreaseMinQuality() {
        GildedRoseRefactored app = newGildedRoseRefactored("Conjured", 0, 0);

        app.updateQuality();

        assertItem(app, 1, 0);
    }

    private void assertItem(GildedRoseRefactored app, int sellIn, int quality) {
        assertEquals(-sellIn, getSellIn(app));
        assertEquals(quality, getQuality(app));
    }

    private GildedRoseRefactored newGildedRoseRefactored(String itemName, int itemSellIn, int itemQuality) {
        Item[] items = new Item[] {new Item(itemName, itemSellIn, itemQuality)};
        return new GildedRoseRefactored(items);
    }

    private int getSellIn(GildedRoseRefactored app) {
        return app.items[0].sellIn;
    }

    private int getQuality(GildedRoseRefactored app) {
        return app.items[0].quality;
    }

}
