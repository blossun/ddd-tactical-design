package kitchenpos.users.domain;

import org.springframework.data.domain.AbstractAggregateRoot;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class User extends AbstractAggregateRoot<User> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String password = UUID.randomUUID().toString();

    protected User() {
    }

    public User(final String name) {
        this.name = name;
    }

    public void changePassword(final String password) {
        this.password = password;
        registerEvent(new ChangedPasswordEvent(id, name)); //이벤트 등록
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

}
