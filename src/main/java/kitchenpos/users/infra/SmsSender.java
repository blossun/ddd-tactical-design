package kitchenpos.users.infra;

import kitchenpos.users.application.MessageSender;
import kitchenpos.users.domain.SignedUpEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class SmsSender implements MessageSender {
    @EventListener
    @Override
    public void send(final SignedUpEvent event) {
        System.out.println("Send an SMS to" + event.getName());
    }
}
