package com.cn.integration;

import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Log4j2
@Service
public class KafkaConsumer {
    @KafkaListener(topics = {"test2"})
    public String receiver(String message) {
        log.debug("receive:" + message);
        return message;
    }
}
