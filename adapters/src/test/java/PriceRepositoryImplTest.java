import ecomerce.Brand.BrandId;
import ecomerce.Price.Price;
import ecomerce.Product.ProductId;
import ecomerce.out.PriceEntity;
import ecomerce.out.PriceJpaRepository;
import ecomerce.out.PriceRepositoryImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.OffsetDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;


public class PriceRepositoryImplTest {
    @Mock
    private PriceJpaRepository priceJpaRepository;

    @InjectMocks
    private PriceRepositoryImpl priceRepositoryImpl;

    private AutoCloseable closeable;

    @BeforeEach
    void setUp() {
        closeable = MockitoAnnotations.openMocks(this);
    }

    @AfterEach
    void teardown() throws Exception {
        closeable.close();
    }

    @Test
    void testFindPriceWhenEntityExists() {
        // Arrange
        OffsetDateTime date = OffsetDateTime.now();
        ProductId productId = new ProductId(1L);
        BrandId brandId = new BrandId(1L);

        PriceEntity priceEntity = new PriceEntity();
        priceEntity.setProductId(1L);
        priceEntity.setBrandId(1L);
        priceEntity.setTariffId(1L);
        priceEntity.setEndDate(OffsetDateTime.now());
        priceEntity.setStartDate(OffsetDateTime.now());
        priceEntity.setCurrency("EUR");
        priceEntity.setPrice(22);
        when(priceJpaRepository.findByFilter(brandId.value(), date, productId.value()))
                .thenReturn(Optional.of(priceEntity));

        // Act
        Optional<Price> result = priceRepositoryImpl.findPrice(date, productId, brandId);

        // Assert
        assertEquals(result.get().getProductId().value(), 1L);
        assertEquals(result.get().getBrandId().value(), 1L);
        assertEquals(result.get().getTariffId().value(), 1L);
        assertEquals(result.get().getEndDate(), priceEntity.getEndDate());
        assertEquals(result.get().getStartDate(), priceEntity.getStartDate());
        assertEquals(result.get().getCurrency(), priceEntity.getCurrency());
        assertEquals(result.get().getPrice(), priceEntity.getPrice());

        verify(priceJpaRepository, times(1)).findByFilter(brandId.value(), date,
                productId.value());
    }

    @Test
    void testFindPriceWhenEntityDoesNotExist() {
        // Arrange
        OffsetDateTime date = OffsetDateTime.now();
        ProductId productId = new ProductId(1L);
        BrandId brandId = new BrandId(1L);

        when(priceJpaRepository.findByFilter(brandId.value(), date, productId.value()))
                .thenReturn(Optional.empty());

        // Act
        Optional<Price> result = priceRepositoryImpl.findPrice(date, productId, brandId);

        // Assert
        assertEquals(Optional.empty(), result);
        verify(priceJpaRepository, times(1)).findByFilter(brandId.value(), date, productId.value());
    }
}
