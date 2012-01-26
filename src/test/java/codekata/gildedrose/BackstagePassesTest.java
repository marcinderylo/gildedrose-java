package codekata.gildedrose;

import org.junit.Test;
import static codekata.gildedrose.GildedRose.BACKSTAGE_PASSES;

/**
 *  Tests that verify whether quality and sell in are handled properly for the "backstage passes" 
 *  item.
 *  @author Marcin Derylo, PL
 */
public class BackstagePassesTest extends BaseGildedRoseTest {

    @Test
    public void shouldIncreaseTheQualityBy1UpTo5thDay() throws Exception {
        // when
        daysPassed(5);
        // then
        assertThat(BACKSTAGE_PASSES).hasSellIn(10).hasQuality(25);
    }
    
    @Test
    public void shouldIncreaseTheQualityBy2Between6thAnd10thDaythAnd() throws Exception {
        // when
        daysPassed(10);
        // then
        assertThat(BACKSTAGE_PASSES).hasSellIn(5).hasQuality(35);
    }
    
    @Test
    public void shouldIncreaseTheQualityBy3Between11thAnd15thDaythAnd() throws Exception {
        // when
        daysPassed(15);
        // then
        assertThat(BACKSTAGE_PASSES).hasSellIn(0).hasQuality(50);
    }
    
    @Test
    public void shouldDropQualityToZeroAfterConcert() throws Exception {
        // when
        daysPassed(16);
        // then
        assertThat(BACKSTAGE_PASSES).hasSellIn(-1).hasQuality(0);
    }
}
