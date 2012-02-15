package codekata.gildedrose.sellin;

import codekata.gildedrose.GildedRose;
import codekata.gildedrose.Item;

/**
 * Factory for {@link SellInPolicy} objects.
 *
 * @author Marcin Deryło <marcinderylo@gmail.com>
 */
public class SellInPolicies {
    public static SellInPolicy sellInPolicyFor(Item item) {
        SellInPolicy policy;
        if (isA(item, GildedRose.SULFURAS)) {
            policy = new NeverAges();
        } else {
            policy = new AgesNormally();
        }
        return policy;
    }

    public static boolean isA(Item item, String itemName) {
        return itemName.equals(item.getName());
    }
}
