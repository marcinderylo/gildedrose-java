package codekata.gildedrose.quality;

import codekata.gildedrose.Item;

/**
 * @author Marcin Deryło <marcinderylo@gmail.com>
 */
public class IncreasesQualityOverTime implements QualityPolicy {
    @Override
    public void apply(Item item) {
        increaseQuality(item);
    }

    private void increaseQuality(Item item) {
        if (item.getQuality() < 50) {
            item.setQuality(item.getQuality() + 1);
        }
    }
}
