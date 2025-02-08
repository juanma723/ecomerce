package ecomerce.Tariff;

import java.util.Objects;

public record TariffId(Long value) {


    public TariffId {
        Objects.requireNonNull(value, "'value' must not be null");
    }
}
