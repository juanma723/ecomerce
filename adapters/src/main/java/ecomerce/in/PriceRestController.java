package ecomerce.in;

import ecomerce.Price.Price;
import org.openapitools.api.PricesApi;
import org.openapitools.model.PriceResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ecomerce.port.FindPriceUseCase;

import java.time.OffsetDateTime;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class PriceRestController implements PricesApi {

    private final FindPriceUseCase findPriceUseCase;

    public PriceRestController(FindPriceUseCase findPriceUseCase) {
        this.findPriceUseCase = findPriceUseCase;
    }

    @Override
    public ResponseEntity<PriceResponse> getPrice(
            @RequestParam(value = "date") OffsetDateTime date,
            @RequestParam(value = "productId") Long productId,
            @RequestParam(value = "brandId") Long brandId) {

        Optional<Price> price = findPriceUseCase.execute(
                date,
                ProductIdParser.parse(productId),
                BrandIdParser.parse(brandId));

        if (price.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return price.map(value -> new ResponseEntity<>(PriceRestControllerMapper.toResponse(value),
                HttpStatus.OK)).get();
    }
}