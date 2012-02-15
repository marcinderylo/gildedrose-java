package codekata.gildedrose;

/**
 * @author Marcin Deryło <marcinderylo@gmail.com>
 */
public class DecreasesQualityOverTime implements QualityPolicy {
    @Override
    public void dayPassed(Item item) {
        decreaseQuality(item);
    }

    private void decreaseQuality(Item item) {
        if (item.getQuality() > 0) {
            item.setQuality(item.getQuality() - 1);
        }
    }

}
