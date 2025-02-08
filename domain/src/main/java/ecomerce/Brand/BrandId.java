package ecomerce.Brand;

import java.util.Objects;

public record BrandId(Long value) {

    public BrandId {
        Objects.requireNonNull(value, "brandId must not be null");
        if (value < 1) {
            throw new IllegalArgumentException("brandId must be a positive number");
        }
    }
}
