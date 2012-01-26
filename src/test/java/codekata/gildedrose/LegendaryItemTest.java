package codekata.gildedrose;

import org.junit.Test;
import static codekata.gildedrose.GildedRose.SULFURAS;

/**
 * Tests that verify that legendary item "Sulfuras, Hand of Ragnaros" retains it's quality 
 * regardless of time passed.
 */
public class LegendaryItemTest extends BaseGildedRoseTest {

    @Test
    public void shouldNotDecreaseQualityNorSellInAfterOneDayPasses() throws Exception {
        // when
        oneDayPassed();
        // then
        assertThat(SULFURAS).hasQuality(80).hasSellIn(0);
    }

    @Test
    public void shouldNotDecreaseQualityNorSellInEvenAfterManyDaysHavePassed() {
        // when
        daysPassed(10);
        // then
        assertThat(SULFURAS).hasQuality(80).hasSellIn(0);
    }
}
