package kitchenpos.users.application;

import kitchenpos.users.domain.SignedUpEvent;
import kitchenpos.users.domain.User;
import kitchenpos.users.domain.UserRepository;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final ApplicationEventPublisher publisher;

    public UserService(final UserRepository userRepository, final ApplicationEventPublisher publisher) {
        this.userRepository = userRepository;
        this.publisher = publisher;
    }

    @Transactional
    public void join(final String name) {
        User user = new User(name);
        publisher.publishEvent(new SignedUpEvent(name)); //이벤트 발행
    }
}
