package codekata.gildedrose;

/**
 * Describes how 'quality' property of item changes as time passes.
 *
 * @author Marcin Deryło <marcinderylo@gmail.com>
 */
public interface QualityPolicy {
    void dayPassed(Item item);
}
