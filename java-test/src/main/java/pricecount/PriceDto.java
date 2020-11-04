package pricecount;

import java.util.Date;

public class PriceDto {

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
