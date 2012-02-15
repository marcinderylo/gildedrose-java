package codekata.gildedrose.sellin;

import codekata.gildedrose.Item;

/**
 * Describes how 'sell in' value of item changes as time passes.
 *
 * @author Marcin Deryło <marcinderylo@gmail.com>
 */
public interface SellInPolicy {
    void dayPassed(Item item);
}
