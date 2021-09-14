package kitchenpos.products.tobe.domain;

import javax.persistence.Embeddable;
import java.util.Objects;

/**
 * - `DisplayedName`에는`Profanity`가 포함될 수 없다.*
 */
@Embeddable
public class DisplayedName {
    private String name;

    public DisplayedName() {
    }

    public DisplayedName(final String name, final Profanities profanities) {
        if (profanities.contains(name)) {
            throw new IllegalArgumentException("이름에 욕설이 포함될 수 없습니다.");
        }
        this.name = name;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof DisplayedName)) return false;
        final DisplayedName that = (DisplayedName) o;
        return name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
