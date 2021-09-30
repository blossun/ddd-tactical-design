package kitchenpos.users.domain;

public class ChangedPasswordEvent {
    private final Long id;
    private final String name;
    private final boolean subscribed;

    public ChangedPasswordEvent(final Long id, final String name, final boolean subscribed) {
        this.id = id;
        this.name = name;
        this.subscribed = subscribed;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public boolean isSubscribed() {
        return subscribed;
    }

    @Override
    public String toString() {
        return "ChangedPasswordEvent{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
