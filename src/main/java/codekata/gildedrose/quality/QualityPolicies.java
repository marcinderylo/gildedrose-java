package codekata.gildedrose.quality;

import codekata.gildedrose.GildedRose;
import codekata.gildedrose.Item;

/**
 * @author Marcin Deryło <marcinderylo@gmail.com>
 */
public class QualityPolicies {
    public static QualityPolicy regularQualityPolicyFor(Item item) {
        QualityPolicy policy;
        if (isA(item, GildedRose.AGED_BRIE)) {
            policy = new IncreasesQualityOverTime();
        } else if (isA(item, GildedRose.BACKSTAGE_PASSES)) {
            policy = new ValidBackstagePassQualityPolicy();
        } else if (isA(item, GildedRose.SULFURAS)) {
            policy = new NeverChangesQuality();
        } else if (isA(item, GildedRose.CONJURED_MANA_CAKE)) {
            policy = new DecreasesQualityFaster(2);
        } else {
            policy = new DecreasesQualityOverTime();
        }
        return policy;
    }

    public static QualityPolicy qualityPolicyAdjustmentForOutOfDateItem(Item item) {
        QualityPolicy policy;
        if (isA(item, GildedRose.AGED_BRIE)) {
            policy = new IncreasesQualityOverTime();
        } else if (isA(item, GildedRose.BACKSTAGE_PASSES)) {
            policy = new DropsQualityToZero();
        } else if (isA(item, GildedRose.SULFURAS)) {
            policy = new NeverChangesQuality();
        } else if (isA(item, GildedRose.CONJURED_MANA_CAKE)) {
            policy = new DecreasesQualityFaster(2);
        } else
            policy = new DecreasesQualityOverTime();
        return policy;
    }


    private static boolean isA(Item item, String itemName) {
        return itemName.equals(item.getName());
    }
}
