package ecomerce;

import ecomerce.Brand.BrandId;
import ecomerce.Price.Price;
import ecomerce.Product.ProductId;
import ecomerce.port.FindPriceUseCase;
import ecomerce.port.PriceRepository;

import java.time.OffsetDateTime;
import java.util.Optional;

public class FindPriceService implements FindPriceUseCase {

    private final PriceRepository priceRepository;

    public FindPriceService(PriceRepository priceRepository) {
        this.priceRepository = priceRepository;
    }

    @Override
    public Optional<Price> execute(OffsetDateTime date, ProductId productId, BrandId brandId) {
        return priceRepository.findPrice(date, productId, brandId);
    }
}
