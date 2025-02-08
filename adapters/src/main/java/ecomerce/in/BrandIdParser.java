package ecomerce.in;

import ecomerce.Brand.BrandId;

public class BrandIdParser {

    public static BrandId parse(Long brandId) {
        return new BrandId(brandId);
    }
}
