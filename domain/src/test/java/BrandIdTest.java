import ecomerce.Brand.BrandId;
import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class BrandIdTest {


    @ParameterizedTest
    @ValueSource(longs = {-100, -1, 0})
    void givenAValueLessThan1_newBrandId_throwsException(Long value) {
        ThrowableAssert.ThrowingCallable invocation = () -> new BrandId(value);

        assertThatIllegalArgumentException().isThrownBy(invocation);
    }



    @ParameterizedTest
    @ValueSource(longs = {1, 8_765, 2_000_000_000})
    void givenAValueGreatThanOrEqualTo1_newBrandId_succeeds(Long value) {
        BrandId brandId = new BrandId(value);

        assertThat(brandId.value()).isEqualTo(value);
    }
}
