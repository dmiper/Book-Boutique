package com.learnup.project.security.details;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class MassegeSender {

    private final JmsTemplate jmsTemplate;
    private final String pervushinMq;


    public MassegeSender(JmsTemplate jmsTemplate,
                         @Value("${activemq.topic}") String pervushinMq) {
        this.jmsTemplate = jmsTemplate;
        this.pervushinMq = pervushinMq;
    }

    public void sendMessege(String messege) {
        try {
            log.debug("Attempting Send message to Topic: " + pervushinMq);
            jmsTemplate.convertAndSend(pervushinMq, messege);
        } catch (Exception e) {
            log.error("Receive Exception during send Message: ", e);
        }
    }

}
