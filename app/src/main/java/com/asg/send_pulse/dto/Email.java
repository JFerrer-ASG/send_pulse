package com.asg.send_pulse.dto;

import lombok.Data;

import java.util.List;

@Data
public class Email {

    private String html;
    private String text;
    private String subject;
    private FromTo from;
    private List<FromTo> to;

}
