package com.learnup.project.security.details;

import lombok.extern.slf4j.Slf4j;
import org.apache.activemq.command.ActiveMQTextMessage;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

import javax.jms.Message;
import javax.jms.MessageListener;

@Service
@Slf4j
public class MassegeListener implements MessageListener {

    @JmsListener(destination = "${activemq.topic}")
    @Override
    public void onMessage(Message message) {
        try {
            ActiveMQTextMessage textMessage = (ActiveMQTextMessage) message;
            String msg = textMessage.getText();
            log.info("Received Message: " + msg);
        } catch (Exception e) {
            log.error("Received Exception : " + e);
        }
    }

}
