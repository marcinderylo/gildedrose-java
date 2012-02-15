package codekata.gildedrose.sellin;

import codekata.gildedrose.Item;

/**
 * @author Marcin Deryło <marcinderylo@gmail.com>
 */
public class AgesNormally implements SellInPolicy {
    @Override
    public void apply(Item item) {
        item.setSellIn(item.getSellIn() - 1);
    }
}
