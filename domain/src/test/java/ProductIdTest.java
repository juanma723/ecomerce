import ecomerce.Brand.BrandId;
import ecomerce.Product.ProductId;
import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class ProductIdTest {


    @ParameterizedTest
    @ValueSource(longs = {-100, -1, 0})
    void givenAValueLessThan1_newProductId_throwsException(Long value) {
        ThrowableAssert.ThrowingCallable invocation = () -> new ProductId(value);

        assertThatIllegalArgumentException().isThrownBy(invocation);
    }



    @ParameterizedTest
    @ValueSource(longs = {1, 8_765, 2_000_000_000})
    void givenAValueGreatThanOrEqualTo1_newProductId_succeeds(Long value) {
        ProductId productId = new ProductId(value);

        assertThat(productId.value()).isEqualTo(value);
    }
}
