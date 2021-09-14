package kitchenpos.products.tobe.application;

import kitchenpos.products.tobe.domain.DisplayedName;
import kitchenpos.products.tobe.domain.Profanities;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    private final Profanities profanities;

    public ProductService(final Profanities profanities) {
        this.profanities = profanities;
    }

    public void create(final String name) {
        new DisplayedName(name, profanities);
    }
}
