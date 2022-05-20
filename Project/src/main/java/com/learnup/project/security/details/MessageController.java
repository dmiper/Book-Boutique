package com.learnup.project.security.details;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/message")
public class MessageController {

    private final MassageSender massageSender;

    public MessageController(MassageSender massageSender) {
        this.massageSender = massageSender;
    }

    @GetMapping
    public String sendMessage(@RequestParam(value = "message") String message) {
        massageSender.sendMessage(message);
        return "OK";
    }

}
