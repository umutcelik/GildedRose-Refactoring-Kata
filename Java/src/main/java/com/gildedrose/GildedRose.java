package com.gildedrose;


import com.gildedrose.items.Calculator;
import com.gildedrose.items.CalculatorFactory;

public class GildedRose {
    public Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    private CalculatorFactory calculatorFactory = new CalculatorFactory();

    public void updateQuality() {
        for (Item item : items) {

            final Calculator calculator = calculatorFactory.getItem(item);
            calculator.updateDay(item);

        }
    }
}