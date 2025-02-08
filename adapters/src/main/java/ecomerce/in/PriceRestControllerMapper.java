package ecomerce.in;

import ecomerce.Price.Price;
import org.openapitools.model.PriceResponse;

public record PriceRestControllerMapper() {


    public static PriceResponse toResponse(Price price) {
        PriceResponse response = new PriceResponse();
        response.setProductId(price.getProductId().value());
        response.setBrandId(price.getBrandId().value());
        response.setTariffId(price.getTariffId().value());
        response.setStartDate(price.getStartDate());
        response.setEndDate(price.getEndDate());
        response.setCurrency(price.getCurrency());
        response.setPrice(price.getPrice());
        return response;
    }
}
