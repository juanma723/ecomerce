package ecomerce.out;

import ecomerce.Brand.BrandId;
import ecomerce.Price.Price;
import ecomerce.Product.ProductId;
import org.springframework.stereotype.Repository;
import ecomerce.port.PriceRepository;

import java.time.OffsetDateTime;
import java.util.Optional;

@Repository
public class PriceRepositoryImpl implements PriceRepository {

    private final PriceJpaRepository priceJpaRepository;


    public PriceRepositoryImpl(PriceJpaRepository priceJpaRepository) {
        this.priceJpaRepository = priceJpaRepository;
    }

    @Override
    public Optional<Price> findPrice(OffsetDateTime date, ProductId productId, BrandId brandId) {
        Optional<PriceEntity> entity = priceJpaRepository.findByFilter(brandId.value(), date, productId.value());
        return entity.map(PriceRepositoryMapper::toDomain);
    }
}
