package com.gildedrose.items;

import com.gildedrose.Item;

public class Sulfuras implements Calculator {

    //"Sulfuras", being a legendary item, never has to be sold or decreases in Quality
    @Override
    public void updateDay(Item item) {
        //do nothing
    }
}
