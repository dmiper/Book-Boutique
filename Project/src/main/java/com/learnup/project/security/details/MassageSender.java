package com.learnup.project.security.details;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MassageSender {

    private final JmsTemplate jmsTemplate;
    private final String pervushinMq;


    public MassageSender(JmsTemplate jmsTemplate,
                         @Value("${activemq.topic}") String pervushinMq) {
        this.jmsTemplate = jmsTemplate;
        this.pervushinMq = pervushinMq;
    }

    public void sendMessage(String message) {
        try {
            log.debug("Message to Topic: " + pervushinMq);
            jmsTemplate.convertAndSend(pervushinMq, message);
        } catch (Exception e) {
            log.error("Receive Exception during send Message: ", e);
        }
    }

}
