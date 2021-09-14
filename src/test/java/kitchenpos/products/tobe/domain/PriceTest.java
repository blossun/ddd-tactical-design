package kitchenpos.products.tobe.domain;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class PriceTest {
    @Test
    void 동등성() {
        Price price1 = new Price(BigDecimal.valueOf(1000L));
        Price price2 = new Price(BigDecimal.valueOf(1000L));
        assertThat(price1).isEqualTo(price2);
    }
}
