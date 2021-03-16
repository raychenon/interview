package pricecount;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PriceChecker {
    /**
     * Application COLT reads prices in application MSD, between 2 dates and a given product id.
     * At one date and for a product id, we have 0 to n prices and these prices can be official or not.
     * To have an indicator on price quality and for monitoring purpose, COLT has a control that counts number of dates with more that n official prices by date.
     *
     * @param prices - input prices coming from MSD application
     * @param n      - threshold on number of prices
     * @return number of Dates with at least n prices official
     */
    public int checkPrices(List<PriceDto> prices, int n) {

        //body to add
        int count = 0;
        Map<Date, Integer> mapFrequency = new HashMap<Date, Integer>();

        for (PriceDto price : prices) {
            if (price.isOfficial()) {
                mapFrequency.put(price.getDate(), mapFrequency.getOrDefault(price.getDate(), 0) + 1);
            }
        }

//        for (Map.Entry<Date, Integer> entry : mapFrequency.entrySet()) {
//            if (entry.getValue() >= n) {
//                count += 1;
//            }
//        }
        count = (int) mapFrequency.entrySet()
                .stream()
                .filter(x -> x.getValue() > n)   // with more that n (> n) official prices by date, not at least (>= n)
                .count();

        return count;
    }

    /**
     * Pure Functional Programming style
     *
     * @param prices - input prices coming from MSD application
     * @param n      - threshold on number of prices
     * @return number of Dates with at least n prices official
     */
    public int checkPricesPureFP(List<PriceDto> prices, int n) {
        return (int) prices.stream()
                .filter(p -> p.isOfficial())
                .collect(Collectors.groupingBy(p -> p.getDate(), Collectors.counting()))
                .entrySet().stream()
                .filter(p -> p.getValue() > n)
                .count();
    }


}

