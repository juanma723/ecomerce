package ecomerce.Product;

import java.util.Objects;

public record ProductId(Long value) {

    public ProductId {
        Objects.requireNonNull(value, "productId must not be null");

        if (value < 1) {
            throw new IllegalArgumentException("productId must be a positive number");
        }
    }



}
