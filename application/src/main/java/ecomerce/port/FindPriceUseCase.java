package ecomerce.port;

import ecomerce.Brand.BrandId;
import ecomerce.Price.Price;
import ecomerce.Product.ProductId;

import java.time.OffsetDateTime;
import java.util.Optional;

public interface FindPriceUseCase {
    Optional<Price> execute(OffsetDateTime date, ProductId productId, BrandId brandId);
}
