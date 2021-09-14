package kitchenpos.products.tobe.domain;

import kitchenpos.common.Value;

import javax.persistence.Embeddable;

/**
 * - `DisplayedName`에는`Profanity`가 포함될 수 없다.*
 */
@Embeddable
public class DisplayedName extends Value<DisplayedName> {
    private String name;

    public DisplayedName() {
    }

    public DisplayedName(final String name, final Profanities profanities) {
        if (profanities.contains(name)) {
            throw new IllegalArgumentException("이름에 욕설이 포함될 수 없습니다.");
        }
        this.name = name;

    }
}
