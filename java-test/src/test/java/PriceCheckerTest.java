import junit.framework.TestCase;
import org.junit.BeforeClass;
import org.junit.Test;
import pricecount.PriceChecker;
import pricecount.PriceDto;

import java.util.*;

public class PriceCheckerTest {

    private static PriceChecker instance;

    @BeforeClass
    public static void setUp() {
        instance = new PriceChecker();
    }

    @Test
    public void checkPricesSameDateTest() {
        Calendar date = new GregorianCalendar(2012, 9, 5);
        PriceDto dto = new PriceDto(1L, date.getTime(), true, 2.0);
        List<PriceDto> prices = Arrays.asList(dto, dto, dto, dto, dto);

        assertOfficialPrices(1, prices, 2);
        assertOfficialPrices(0, prices, 6);
    }


    @Test
    public void checkPricesDifferentDatesTest() {
        Calendar calendar1 = new GregorianCalendar(2012, 9, 5);
        Calendar calendar2 = new GregorianCalendar(2021, 3, 16);

        List<PriceDto> prices = new LinkedList<>();

        // 3 date1 , 6 date2
        for (long i = 1; i < 10; i++) {
            Date date = (i % 3 == 0) ? calendar1.getTime() : calendar2.getTime();
            prices.add(new PriceDto(i, date, true, 5.0));
        }

        assertOfficialPrices(2, prices, 2);
        assertOfficialPrices(1, prices, 4);
        assertOfficialPrices(0, prices, 7);
    }

    @Test
    public void checkNoOfficialPricesTest() {
        Calendar calendar2 = new GregorianCalendar(2021, 3, 16);

        List<PriceDto> prices = new LinkedList<>();

        // 9 elements in the list
        for (long i = 1; i < 10; i++) {
            prices.add(new PriceDto(i, calendar2.getTime(), false, 5.0));
        }

        assertOfficialPrices(0, prices, 0);
        assertOfficialPrices(0, prices, 3);
        assertOfficialPrices(0, prices, 6);
        assertOfficialPrices(0, prices, 7);
    }


    private void assertOfficialPrices(int expected, List<PriceDto> prices, int n) {
        TestCase.assertEquals(expected, instance.checkPrices(prices, n));
        TestCase.assertEquals(expected, instance.checkPricesPureFP(prices, n));
    }


}
