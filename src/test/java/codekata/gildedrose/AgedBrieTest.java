package codekata.gildedrose;

import org.junit.Test;
import static codekata.gildedrose.GildedRose.AGED_BRIE;

/**
 * Tests that verify that quality of "Aged Brie" item is changing as per specification.
 * @author Marcin Derylo, PL
 */
public class AgedBrieTest extends BaseGildedRoseTest {

    @Test
    public void shouldIncreaseTheQualityWithEveryDayPassing() throws Exception {
        // when
        oneDayPassed();
        // then
        assertThat(AGED_BRIE).hasQuality(1).hasSellIn(1);
    }

    @Test
    public void shouldIncreaseTheQualityEvenAfterSellInDate() throws Exception {
        // when
        daysPassed(4);
        // then
        assertThat(AGED_BRIE).hasQuality(6).hasSellIn(-2);
    }

    @Test
    public void shouldNeverIncreaseQualityAbove50() {
        // when
        daysPassed(27);
        // then
        assertThat(AGED_BRIE).hasQuality(50).hasSellIn(-25);
    }
}
