package kitchenpos.users.infra;

import kitchenpos.users.application.MessageSender;
import kitchenpos.users.domain.SignedUpEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class EmailSender implements MessageSender {
    @EventListener
    @Override
    public void send(final SignedUpEvent event) {
        System.out.println("Send an Email to" + event.getName());
    }
}
