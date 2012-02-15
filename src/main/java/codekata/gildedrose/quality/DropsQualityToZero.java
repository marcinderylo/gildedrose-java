package codekata.gildedrose.quality;

import codekata.gildedrose.Item;

/**
 * @author Marcin Deryło <marcinderylo@gmail.com>
 */
public class DropsQualityToZero implements QualityPolicy {
    @Override
    public void dayPassed(Item item) {
        item.setQuality(0);
    }
}
