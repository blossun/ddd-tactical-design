package kitchenpos.users.application;

import kitchenpos.users.domain.SignedUpEvent;

public interface MessageSender {
    void send(SignedUpEvent event); //어떤 이벤트를 핸들링할 것인지 명시
}
