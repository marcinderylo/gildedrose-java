package codekata.gildedrose.quality;

import codekata.gildedrose.GildedRose;
import codekata.gildedrose.Item;
import codekata.gildedrose.sellin.SellInPolicies;

/**
 * @author Marcin Deryło <marcinderylo@gmail.com>
 */
public class QualityPolicies {
    public static QualityPolicy regularQualityPolicyFor(Item item) {
        QualityPolicy policy;
        if (SellInPolicies.isA(item, GildedRose.AGED_BRIE)) {
            policy = new IncreasesQualityOverTime();
        } else if (SellInPolicies.isA(item, GildedRose.BACKSTAGE_PASSES)) {
            policy = new ValidBackstagePassQualityPolicy();
        } else if (SellInPolicies.isA(item, GildedRose.SULFURAS)) {
            policy = new NeverChangesQuality();
        } else {
            policy = new DecreasesQualityOverTime();
        }
        return policy;
    }

    public static QualityPolicy qualityPolicyAdjustmentForOutOfDateItem(Item item) {
        QualityPolicy policy;
        if (SellInPolicies.isA(item, GildedRose.AGED_BRIE)) {
            policy = new IncreasesQualityOverTime();
        } else if (SellInPolicies.isA(item, GildedRose.BACKSTAGE_PASSES)) {
            policy = new DropsQualityToZero();
        } else if (SellInPolicies.isA(item, GildedRose.SULFURAS)) {
            policy = new NeverChangesQuality();
        } else {
            policy = new DecreasesQualityOverTime();
        }
        return policy;
    }
}
