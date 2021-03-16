package pricecount;

import java.util.Date;

/**
 * User: raychenon
 * Date: 11/3/2021
 * Time: 1:37 PM
 */
public class PriceDto {


    private long productId;
    private Date date;
    private boolean isOfficial;
    private double value;

    public PriceDto(long productId, Date date, boolean isOfficial, double value) {
        this.productId = productId;
        this.date = date;
        this.isOfficial = isOfficial;
        this.value = value;
    }

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
