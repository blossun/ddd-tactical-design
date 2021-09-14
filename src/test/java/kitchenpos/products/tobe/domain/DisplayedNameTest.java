package kitchenpos.products.tobe.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class DisplayedNameTest {

    @Test
    void 욕설() {
        assertThatThrownBy(
                () -> new DisplayedName("욕설", new FakePurgomalumClient())
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 생성() {
        assertDoesNotThrow(
                () -> new DisplayedName("이름", new FakePurgomalumClient())
        );
    }

    @Test
    void 동등성() {
        DisplayedName name1 = new DisplayedName("치킨", new FakePurgomalumClient());
        DisplayedName name2 = new DisplayedName("치킨", new FakePurgomalumClient());
        assertThat(name1).isEqualTo(name2);
    }
}

class FakePurgomalumClient implements Profanities {
    private static final List<String> profanities;

    static {
        profanities = Arrays.asList("비속어", "욕설");
    }

    @Override
    public boolean contains(final String text) {
        return profanities.stream()
                .anyMatch(profanity -> text.contains(profanity));
    }
}
