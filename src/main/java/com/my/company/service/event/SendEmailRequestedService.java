package com.my.company.service.event;

import com.my.company.endpoint.event.model.SendEmailRequested;
import com.my.company.mail.Email;
import com.my.company.mail.Mailer;
import jakarta.mail.internet.InternetAddress;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Consumer;

@Service
@AllArgsConstructor
public class SendEmailRequestedService implements Consumer<SendEmailRequested> {
    private final Mailer mailer;

    @Override
    @SneakyThrows
    public void accept(SendEmailRequested event) {
        var recipient = new InternetAddress(event.getTo());
        var email = new Email(recipient, List.of(), List.of(), "Hello world", "... world!", List.of());
        mailer.accept(email);
    }
}
