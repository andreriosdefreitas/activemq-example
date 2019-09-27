package com.example.servicea.jms.receiver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class Receiver {

    private static final Logger LOGGER = LoggerFactory.getLogger(Receiver.class);

    @Transactional
    @JmsListener(destination = "queueA")
    public void receive(String message) {
        LOGGER.info("receive message: {}", message);
    }

    @Transactional
    @JmsListener(destination = "ActiveMQ.DLQ")
    public void receiveDLQ(String message) {
        LOGGER.info("DLQ: {}", message);
    }
}
