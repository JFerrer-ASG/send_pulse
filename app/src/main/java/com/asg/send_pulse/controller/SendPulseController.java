package com.asg.send_pulse.controller;

import com.asg.send_pulse.cliente.SendPulseCliente;
import com.asg.send_pulse.dto.EmailResponse;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.reactivex.Maybe;

import javax.inject.Inject;

@Controller("/sendPulse")
public class SendPulseController {

    @Inject
    private SendPulseCliente cliente;

    @Get("/mail")
    public Maybe<EmailResponse> testSendMail() {
        return cliente.sendMail();
    }

}
