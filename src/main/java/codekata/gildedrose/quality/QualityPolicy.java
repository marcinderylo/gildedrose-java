package codekata.gildedrose.quality;

import codekata.gildedrose.Item;

/**
 * Describes how 'quality' property of item changes as time passes.
 *
 * @author Marcin Deryło <marcinderylo@gmail.com>
 */
public interface QualityPolicy {
    void dayPassed(Item item);
}
