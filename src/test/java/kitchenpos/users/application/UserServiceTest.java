package kitchenpos.users.application;

import kitchenpos.users.domain.ChangedPasswordEvent;
import kitchenpos.users.domain.SignedUpEvent;
import kitchenpos.users.domain.User;
import kitchenpos.users.domain.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserServiceTest {
    @Autowired
    private UserService userService;

    @Autowired
    private FakeSender fakeSender;

    @Autowired
    private UserRepository userRepository;

    @Test
    void join() {
        assertThat(fakeSender.getCount()).isEqualTo(0);
        userService.join("Solar");
        assertThat(fakeSender.getCount()).isEqualTo(1);
    }

    @Test
    void changePassword() {
        final User user = userRepository.save(new User("Solar"));
        int count = fakeSender.getCount();
        userService.changePassword(user.getName());
        assertThat(fakeSender.getCount()).isEqualTo(count + 1);
    }
}

@Component
class FakeSender implements MessageSender {
    private int count = 0;

    @EventListener
    @Override
    public void send(final SignedUpEvent event) {
        count++;
    }

    @EventListener
    public void send(final ChangedPasswordEvent event) {
        System.out.println(event);
        count++;
    }

    public int getCount() {
        return count;
    }
}
