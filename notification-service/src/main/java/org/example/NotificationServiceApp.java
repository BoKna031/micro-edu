package org.example;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.kafka.annotation.KafkaListener;

@SpringBootApplication
@EnableDiscoveryClient
@Slf4j
public class NotificationServiceApp {
    public static void main(String[] args) {
        SpringApplication.run(NotificationServiceApp.class, args);
    }

    @KafkaListener(topics = "communicationTopic")
    public void handleNotification(CommunicationEvent event){
        if(event.getResponseStatus().startsWith("4") || event.getResponseStatus().startsWith("5"))
            log.error(event.toString());
        else
            log.info(event.toString());
    }
}