package ecomerce.in;

import ecomerce.Product.ProductId;

public class ProductIdParser {

    public static ProductId parse(Long productId) {
        return new ProductId(productId);
    }
}
