package com.asg.send_pulse.cliente;

import com.asg.send_pulse.dto.Email;
import com.asg.send_pulse.dto.EmailResponse;
import com.asg.send_pulse.dto.FromTo;
import io.micronaut.core.type.Argument;
import io.micronaut.http.HttpHeaders;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.client.RxHttpClient;
import io.micronaut.http.client.annotation.Client;
import io.reactivex.Flowable;
import io.reactivex.Maybe;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.Arrays;
import java.util.Collections;

@Singleton
public class SendPulseCliente {

    @Inject
    @Client("${com.asg.mail.host}")
    private RxHttpClient httpClient;

    public Maybe<?> sendMail() {
        Email body = new Email();
        email.setFrom(new FromTo("Jorge Ferrer","jorge.ferrer@advisoryservicesg.tech"));
        email.setSubject("Prueba");
        email.setText("El texto a enviar");
        email.setTo(Collections.singletonList(new FromTo("Jorge Ferrer", "ferrer65lied@gmail.com")));

        HttpRequest<?> req = HttpRequest.POST("/smtp/emails", body)
                .header(HttpHeaders.USER_AGENT, "Micronaut HTTP Client")
                .header(HttpHeaders.ACCEPT, "application/json");
        Flowable<EmailResponse> flowable = httpClient.retrieve(req, Argument.of(EmailResponse.class));
        return flowable.singleElement();
    }

}
