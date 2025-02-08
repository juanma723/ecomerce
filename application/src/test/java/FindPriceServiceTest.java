import ecomerce.Brand.BrandId;
import ecomerce.FindPriceService;
import ecomerce.Price.Price;
import ecomerce.Product.ProductId;
import ecomerce.port.PriceRepository;
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

public class FindPriceServiceTest {

    @Mock
    private PriceRepository priceRepository;

    @InjectMocks
    private FindPriceService priceService;

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
    void testExecute() {
        OffsetDateTime date = OffsetDateTime.now();
        ProductId productId = new ProductId(1L);
        BrandId brandId = new BrandId(1L);
        Price expectedPrice = new Price();

        when(priceRepository.findPrice(date, productId, brandId)).thenReturn(Optional.of(expectedPrice));

        Optional<Price> result = priceService.execute(date, productId, brandId);

        assertEquals(Optional.of(expectedPrice), result);
        verify(priceRepository, times(1)).findPrice(date, productId, brandId);
    }

    @Test
    void testExecuteWhenPriceNotFound() {
        OffsetDateTime date = OffsetDateTime.now();
        ProductId productId = new ProductId(1L);
        BrandId brandId = new BrandId(1L);

        when(priceRepository.findPrice(date, productId, brandId)).thenReturn(Optional.empty());

        Optional<Price> result = priceService.execute(date, productId, brandId);

        assertEquals(Optional.empty(), result);
        verify(priceRepository, times(1)).findPrice(date, productId, brandId);
    }

}
