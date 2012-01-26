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

    /**
     * @return the inn
     */
    /**
     * @return the inn
     */
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
}
