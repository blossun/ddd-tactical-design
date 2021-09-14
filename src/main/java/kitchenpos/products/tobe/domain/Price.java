package kitchenpos.products.tobe.domain;

import kitchenpos.common.Value;

import javax.persistence.Embeddable;
import java.math.BigDecimal;

@Embeddable
public class Price extends Value<Price> {
    private BigDecimal value;

    protected Price() {
    }

    public Price(final BigDecimal value) {
        if (value.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException();
        }
        this.value = value;
    }
}
