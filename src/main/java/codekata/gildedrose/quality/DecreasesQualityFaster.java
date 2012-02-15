package codekata.gildedrose.quality;

import codekata.gildedrose.Item;

/**
 * @author Marcin Deryło <marcinderylo@gmail.com>
 */
public class DecreasesQualityFaster implements QualityPolicy {
    private int decreaseRate;
    private final QualityPolicy regularDecrease = new DecreasesQualityOverTime();

    public DecreasesQualityFaster(int qualityDecreaseRateFactor) {
        this.decreaseRate = qualityDecreaseRateFactor;
    }

    @Override
    public void apply(Item item) {
        for (int i = 0; i < decreaseRate; i++) {
             regularDecrease.apply(item);
        }
    }
}
