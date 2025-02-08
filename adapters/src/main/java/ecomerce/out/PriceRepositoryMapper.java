package ecomerce.out;


import ecomerce.Brand.BrandId;
import ecomerce.Price.Price;
import ecomerce.Product.ProductId;
import ecomerce.Tariff.TariffId;

import java.util.Optional;

public class PriceRepositoryMapper {


    public static Price toDomain(PriceEntity entity) {

        Price price = new Price();
        Optional.ofNullable(entity.getProductId()).ifPresent(p -> price.setProductId(new ProductId(p)));
        Optional.ofNullable(entity.getBrandId()).ifPresent(b -> price.setBrandId(new BrandId(b)));
        Optional.ofNullable(entity.getTariffId()).ifPresent(t -> price.setTariffId(new TariffId(t)));
        price.setStartDate(entity.getStartDate());
        price.setEndDate(entity.getEndDate());
        price.setPrice(entity.getPrice());
        price.setCurrency(entity.getCurrency());
        return price;
    }
}
