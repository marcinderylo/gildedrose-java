package codekata.gildedrose;

/**
 * <p>Hi and welcome to team Gilded Rose. As you know, we are a small inn with a prime location in a
 * prominent city ran by a friendly innkeeper named Allison. We also buy and sell only the finest
 * goods. Unfortunately, our goods are constantly degrading in quality as they approach their sell
 * by date. We have a system in place that updates our inventory for us. It was developed by a
 * no-nonsense type named Leeroy, who has moved on to new adventures. Your task is to add the new
 * feature to our system so that we can begin selling a new category of items. First an introduction
 * to our system:</p>
 * <ul>
 * <li>All items have a SellIn value which denotes the number of days we have to sell the item</li>
 * <li>All items have a Quality value which denotes how valuable the item is</li>
 * <li>At the end of each day our system lowers both values for every item</li>
 * </ul>
 * Pretty simple, right? Well this is where it gets interesting:
 * <ul>
 * <li>Once the sell by date has passed, Quality degrades twice as fast</li>
 * <li>The Quality of an item is never negative</li>
 * <li>“Aged Brie” actually increases in Quality the older it gets (twice as fast after sell in date)</li>
 * <li>The Quality of an item is never more than 50</li>
 * <li>“Sulfuras”, being a legendary item, never has to be sold or decreases in Quality</li>
 * <li>“Backstage passes”, like aged brie, increases in Quality as it’s SellIn value approaches;<ul>
 * <li>Quality increases by 2 when there are 10 days or less and by 3 when there are 5 days or less but</li>
 * <li>Quality drops to 0 after the concert</li></ul></li>
 * </ul>
 * <p>We have recently signed a supplier of conjured items. This requires an update to our system:</p>
 * <ul>
 * <li>“Conjured” items degrade in Quality twice as fast as normal items</li>
 * </ul>
 * <p>Feel free to make any changes to the UpdateQuality method and add any new code as long as
 * everything still works correctly. However, do not alter the Item class or Items property as those
 * belong to the goblin in the corner who will insta-rage and one-shot you as he doesn’t believe in
 * shared code ownership (you can make the UpdateQuality method and Items property static if you
 * like, we’ll cover for you).</p>
 * 
 * @author Marcin Deryło
 */
public class GildedRose {
    
    public static final String AGED_BRIE = "Aged Brie";
    public static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    public static final String CONJURED_MANA_CAKE = "Conjured Mana Cake";
    public static final String DEXTERITY_VEST = "+5 Dexterity Vest";
    public static final String ELIXIR_OF_THE_MONGOOSE = "Elixir of the Mongoose";
    public static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    /**
     * Don't you dare changing it!
     */
    private final Item[] items;
    
    public GildedRose() {
        items = new Item[]{
            // first step
            new Item(DEXTERITY_VEST, 10, 20),
            new Item(ELIXIR_OF_THE_MONGOOSE, 5, 7),
            // second step
            new Item(AGED_BRIE, 2, 0),
            new Item(SULFURAS, 0, 80),
            new Item(BACKSTAGE_PASSES, 15, 20),
            // third step
            new Item(CONJURED_MANA_CAKE, 3, 6)};
    }
    
    public Item getItem(String name) {
        for (Item item : items) {
            if (item.getName().equals(name)) {
                return item;
            }
        }
        throw new IllegalArgumentException("Item " + name + " not found");
    }
    
    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            if (!AGED_BRIE.equals(items[i].getName())
                && !BACKSTAGE_PASSES.equals(items[i].getName())) {
                if (items[i].getQuality() > 0) {
                    if (!items[i].getName().equals(SULFURAS)) {
                        items[i].setQuality(items[i].getQuality() - 1);
                    }
                }
            } else {
                if (items[i].getQuality() < 50) {
                    items[i].setQuality(items[i].getQuality() + 1);
                    
                    if (items[i].getName().equals(BACKSTAGE_PASSES)) {
                        if (items[i].getSellIn() < 11) {
                            if (items[i].getQuality() < 50) {
                                items[i].setQuality(items[i].getQuality() + 1);
                            }
                        }
                        
                        if (items[i].getSellIn() < 6) {
                            if (items[i].getQuality() < 50) {
                                items[i].setQuality(items[i].getQuality() + 1);
                            }
                        }
                    }
                }
            }
            
            if (!items[i].getName().equals(SULFURAS)) {
                items[i].setSellIn(items[i].getSellIn() - 1);
            }
            
            if (items[i].getSellIn() < 0) {
                if (!items[i].getName().equals(AGED_BRIE)) {
                    if (!items[i].getName().equals(BACKSTAGE_PASSES)) {
                        if (items[i].getQuality() > 0) {
                            if (!items[i].getName().equals(SULFURAS)) {
                                items[i].setQuality(items[i].getQuality() - 1);
                            }
                        }
                    } else {
                        items[i].setQuality(items[i].getQuality() - items[i].getQuality());
                    }
                } else {
                    if (items[i].getQuality() < 50) {
                        items[i].setQuality(items[i].getQuality() + 1);
                    }
                }
            }
        }
    }
}
