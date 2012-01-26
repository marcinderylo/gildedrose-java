package codekata.gildedrose;

import org.junit.Assert;

public class ItemAssert {

    public static ItemAssert assertThat(Item item) {
        return new ItemAssert(item);
    }
    private final Item item;

    private ItemAssert(Item item) {
        this.item = item;
    }

    public ItemAssert hasQuality(int expectedQuality) {
        Assert.assertEquals(expectedQuality, item.getQuality());
        return this;
    }

    public ItemAssert hasSellIn(int expectedSellIn) {
        Assert.assertEquals(expectedSellIn, item.getSellIn());
        return this;
    }
}
