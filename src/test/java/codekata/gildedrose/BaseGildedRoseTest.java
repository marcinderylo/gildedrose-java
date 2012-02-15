package codekata.gildedrose;

import org.junit.Before;

/**
 *  Common setup & test helpers for Gilded Rose kata tests.
 * 
 *  @author Marcin Derylo, PL
 */
public abstract class BaseGildedRoseTest {

    public BaseGildedRoseTest() {
    }

    @Before
    public void setUp() {
        inn = new GildedRose();
    }
    private GildedRose inn;

    protected final ItemAssert assertThat(String itemName) {
        return ItemAssert.assertThat(inn.getItem(itemName));
    }

    protected final void daysPassed(int howManyDays) {
        for (int i = 0; i < howManyDays; i++) {
            inn.updateQuality();
        }
    }

    protected final void oneDayPassed() {
        daysPassed(1);
    }
    
    protected final void changeItemQuality(String itemName, int newQuality) {
        inn.getItem(itemName).setQuality(newQuality);
    }
}
