import junit.framework.Assert;
import org.junit.Test;
import pricecount.PriceChecker;
import pricecount.PriceDto;

import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

public class PriceCheckerTest {

//    private PriceChecker instance;
//
//    @BeforeClass
//    public static void setUp() {
//        instance = new PriceChecker();
//    }

    @Test
    public void checkPrices() {
        Calendar date = new GregorianCalendar(2012, 9, 5);
        PriceDto dto = new PriceDto(1L, date.getTime(), true, 2.0);
        List<PriceDto> prices = Arrays.asList(dto, dto, dto, dto, dto);

        PriceChecker instance = new PriceChecker();
        Assert.assertEquals(1, instance.checkPrices(prices, 2));
        Assert.assertEquals(0, instance.checkPrices(prices, 6));
    }

}
