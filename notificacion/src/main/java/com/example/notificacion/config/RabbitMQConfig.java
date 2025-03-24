package com.example.notificacion.config;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    @Bean
    public Queue sendNotificationQueue() {
        // El segundo parámetro 'true' significa que la cola es durable (sobrevive a reinicios)
        return new Queue("send-notification", true);
    }
}