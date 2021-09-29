package kitchenpos.users.domain;

public class ChangedPasswordEvent {
    private final Long id;
    private final String name;

    public ChangedPasswordEvent(final Long id, final String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "ChangedPasswordEvent{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
