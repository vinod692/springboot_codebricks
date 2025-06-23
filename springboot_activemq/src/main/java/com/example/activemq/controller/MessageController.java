package com.example.activemq.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.*;

import javax.jms.Queue;

@RestController
@RequestMapping("/api")
public class MessageController {

    @Autowired
    private JmsTemplate jmsTemplate;

    @Autowired
    private Queue queue;

    @PostMapping("/send")
    public ResponseEntity<String> sendMessage(@RequestBody String message) {
        jmsTemplate.convertAndSend(queue, message);
        return ResponseEntity.ok("Message sent to ActiveMQ");
    }
}
