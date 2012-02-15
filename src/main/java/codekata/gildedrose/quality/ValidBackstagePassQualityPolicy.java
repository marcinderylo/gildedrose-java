package codekata.gildedrose.quality;

import codekata.gildedrose.Item;

/**
 * @author Marcin Deryło <marcinderylo@gmail.com>
 */
public class ValidBackstagePassQualityPolicy implements QualityPolicy {

    private final QualityPolicy increaseQuality = new IncreasesQualityOverTime();

    @Override
    public void dayPassed(Item item) {
        increaseQuality(item);
        if (item.getSellIn() < 11) {
            increaseQuality(item);
        }
        if (item.getSellIn() < 6) {
            increaseQuality(item);
        }
    }

    private void increaseQuality(Item item) {
        increaseQuality.dayPassed(item);
    }
}
