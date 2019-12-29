package com.cn.integration;

import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class KafkaConsumer {
    private String topic;

    @KafkaListener(topics = {"test2"})
    public String kafkaReceiveMessage(String message) {
        log.debug("Receive message: " + message);
        return message;
    }
}
