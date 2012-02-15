package codekata.gildedrose;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Marcin Deryło <marcinderylo@gmail.com>
 */
public class ConjuredCakeTest extends BaseGildedRoseTest {
    @Before
    public void increaseInitialQuality() throws Exception {
        changeItemQuality(GildedRose.CONJURED_MANA_CAKE, 12);
    }

    @Test
    public void testConjuredItemsLoosesQualityTwiceAsFastAsRegularItems() throws Exception {
        // when
        daysPassed(3);
        // then
        assertThat(GildedRose.CONJURED_MANA_CAKE).hasQuality(6);
    }

    @Test
    public void testConjuredItemsLoosesQualityAtQuadrupleRateWhenExpired() throws Exception {
        // when
        daysPassed(4);
        // then
        assertThat(GildedRose.CONJURED_MANA_CAKE).hasQuality(2);
    }
}
