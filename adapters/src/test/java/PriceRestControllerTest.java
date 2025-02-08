import ecomerce.Brand.BrandId;
import ecomerce.Price.Price;
import ecomerce.Product.ProductId;
import ecomerce.Tariff.TariffId;
import ecomerce.in.PriceRestController;
import ecomerce.port.FindPriceUseCase;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.openapitools.model.PriceResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.OffsetDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

class PriceRestControllerTest {

    @Mock
    private FindPriceUseCase findPriceUseCase;

    @InjectMocks
    private PriceRestController priceRestController;

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
    void testGetPriceWhenPriceExists() {
        OffsetDateTime date = OffsetDateTime.now();
        Long productId = 1L;
        Long brandId = 1L;

        ProductId parsedProductId = new ProductId(productId);
        BrandId parsedBrandId = new BrandId(brandId);
        TariffId parsedTariffId = new TariffId(1L);

        Price price = new Price();
        price.setProductId(parsedProductId);
        price.setBrandId(parsedBrandId);
        price.setTariffId(parsedTariffId);
        price.setPrice(99.99);
        price.setCurrency("EUR");
        price.setStartDate(OffsetDateTime.parse("2024-01-01T00:00:00Z"));
        price.setEndDate(OffsetDateTime.parse("2024-12-31T23:59:59Z"));

        PriceResponse expectedResponse = new PriceResponse();
        expectedResponse.setProductId(productId);
        expectedResponse.setBrandId(brandId);
        expectedResponse.setTariffId(1L);
        expectedResponse.setPrice(99.99);
        expectedResponse.setCurrency("EUR");
        expectedResponse.setStartDate(OffsetDateTime.parse("2024-01-01T00:00:00Z"));
        expectedResponse.setEndDate(OffsetDateTime.parse("2024-12-31T23:59:59Z"));

        when(findPriceUseCase.execute(date, parsedProductId, parsedBrandId))
                .thenReturn(Optional.of(price));

        ResponseEntity<PriceResponse> result = priceRestController.getPrice(date, productId, brandId);

        assertEquals(HttpStatus.OK, result.getStatusCode());
        assertNotNull(result.getBody());

        PriceResponse actualResponse = result.getBody();
        assertEquals(expectedResponse.getProductId(), actualResponse.getProductId());
        assertEquals(expectedResponse.getBrandId(), actualResponse.getBrandId());
        assertEquals(expectedResponse.getTariffId(), actualResponse.getTariffId());
        assertEquals(expectedResponse.getPrice(), actualResponse.getPrice(), 0.01);
        assertEquals(expectedResponse.getCurrency(), actualResponse.getCurrency());
        assertEquals(expectedResponse.getStartDate(), actualResponse.getStartDate());
        assertEquals(expectedResponse.getEndDate(), actualResponse.getEndDate());
    }


    @Test
    void testGetPriceWhenPriceDoesNotExist() {
        OffsetDateTime date = OffsetDateTime.now();
        Long productId = 1L;
        Long brandId = 1L;

        ProductId parsedProductId = new ProductId(1L);
        BrandId parsedBrandId = new BrandId(1L);


        when(findPriceUseCase.execute(date, parsedProductId, parsedBrandId))
                .thenReturn(Optional.empty());

        ResponseEntity<PriceResponse> result = priceRestController.getPrice(date, productId, brandId);

        assertEquals(HttpStatus.NO_CONTENT, result.getStatusCode());

    }
}