package codekata.gildedrose;

import org.junit.Test;
import static codekata.gildedrose.GildedRose.ELIXIR_OF_THE_MONGOOSE;
import static codekata.gildedrose.GildedRose.DEXTERITY_VEST;

/**
 * Tests that verify that the quality and sellIn values of regular items change as per specification.
 * 
 * @author Marcin Derylo, PL
 */
public class RegularItemsTest extends BaseGildedRoseTest {

    @Test
    public void shouldReduceQualityAndSellInAfterADayPasses() throws Exception {
        // when
        oneDayPassed();
        // then
        assertThat(DEXTERITY_VEST).hasQuality(19).hasSellIn(9);
        assertThat(ELIXIR_OF_THE_MONGOOSE).hasQuality(6).hasSellIn(4);
    }

    @Test
    public void shouldNotReduceQualityBelowZAfterADayPasses() throws Exception {
        // when
        daysPassed(7);
        // then
        assertThat(GildedRose.ELIXIR_OF_THE_MONGOOSE).hasQuality(0).hasSellIn(-2);
    }

    @Test
    public void shouldDegradeQualityTwiceAsFastAfterSellInDate() {
        // when
        daysPassed(11);
        // then
        assertThat(DEXTERITY_VEST).hasQuality(8).hasSellIn(-1);
    }
}
