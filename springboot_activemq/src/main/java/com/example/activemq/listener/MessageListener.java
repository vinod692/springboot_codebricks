package com.example.activemq.listener;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class MessageListener {

    @JmsListener(destination = "test-queue")
    public void receive(String message) {
        System.out.println("Received: " + message);
    }
}
