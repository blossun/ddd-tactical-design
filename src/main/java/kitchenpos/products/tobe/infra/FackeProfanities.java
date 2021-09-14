package kitchenpos.products.tobe.infra;

import kitchenpos.products.tobe.domain.Profanities;
import org.springframework.stereotype.Component;

@Component
public class FackeProfanities implements Profanities {
    @Override
    public boolean contains(final String name) {
        return false;
    }
}

