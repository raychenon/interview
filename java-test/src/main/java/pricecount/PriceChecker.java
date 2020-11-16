package pricecount;

import java.util.Date;
import java.util.List;

public class PriceChecker {
    /**
     *Application COLT reads prices in application MSD, between 2 dates and a given product id.
     *At one date and for a product id, we have 0 to n prices and these prices can be official or not.
     *To have an indicator on price quality and for monitoring purpose, COLT has a control that counts number of dates with more that n official prices by date.
     * @param prices - input prices coming from MSD application
     * @param n - threshold on number of prices
     * @return number of Dates with at least n prices official
     */
    public int checkPrices(List<PriceDto> prices, int n) {

        //body to add
        int count = 0;
        //...
        return count;
    }

    private class PriceDto {

        private long productId;
        private Date date;
        private boolean isOfficial;
        private double value;

        public long getProductId() {
            return productId;
        }

        public Date getDate() {
            return date;
        }

        public boolean isOfficial() {
            return isOfficial;
        }

        public double getValue() {
            return value;
        }
    }


}

