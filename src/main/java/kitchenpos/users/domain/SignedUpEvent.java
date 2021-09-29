package kitchenpos.users.domain;

public class SignedUpEvent {
    private final String name;

    public SignedUpEvent(final String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
