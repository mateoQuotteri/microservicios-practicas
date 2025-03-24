package com.example.payments.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
public class PublishNotification {
    private RabbitTemplate rabbitTemplate;

    public PublishNotification(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendMessageToTopic(String message){


        //Este metodo nos permite enivarle un mensaje
        //a un topico dentro de RabbitMq Server
        //primer parametro nombre del topico y egundo el msj
    rabbitTemplate.convertAndSend("send-notification", message);

    }
}
