package com.example.donorreceiverapi.service;

import com.example.donorreceiverapi.event.DonorReceiverCreationEvent;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQSender {
    @Autowired
    private AmqpTemplate amqpTemplate;

    @Value("${rabbitmq.exchange}")
    private String exchange;

    @Value("${rabbitmq.routingkey}")
    private String routingkey;

    public void send(DonorReceiverCreationEvent donorReceiverCreationEvent) {
        amqpTemplate.convertAndSend(exchange, routingkey, donorReceiverCreationEvent);
        System.out.println("Send msg = " + donorReceiverCreationEvent);

    }
}
