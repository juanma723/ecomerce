package ecomerce.Price;

import ecomerce.Brand.BrandId;
import ecomerce.Product.ProductId;
import ecomerce.Tariff.TariffId;

import java.time.OffsetDateTime;

public class Price {

    private ProductId productId;
    private BrandId brandId;
    private TariffId tariffId;
    private double price;
    private String currency;
    private OffsetDateTime startDate;
    private OffsetDateTime endDate;

    public Price() {
    }

    public Price(ProductId productId, BrandId brandId, TariffId tariffId, double price, String currency,
                 OffsetDateTime startDate, OffsetDateTime endDate) {
        this.productId = productId;
        this.brandId = brandId;
        this.tariffId = tariffId;
        this.price = price;
        this.currency = currency;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public ProductId getProductId() {
        return productId;
    }

    public void setProductId(ProductId productId) {
        this.productId = productId;
    }

    public BrandId getBrandId() {
        return brandId;
    }

    public void setBrandId(BrandId brandId) {
        this.brandId = brandId;
    }

    public TariffId getTariffId() {
        return tariffId;
    }

    public void setTariffId(TariffId tariffId) {
        this.tariffId = tariffId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }


    public OffsetDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(OffsetDateTime startDate) {
        this.startDate = startDate;
    }

    public OffsetDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(OffsetDateTime endDate) {
        this.endDate = endDate;
    }
}
