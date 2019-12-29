package com.cn.integration;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;

@Service
@Log4j2
public class KafkaProducer {
    @Autowired
    private KafkaTemplate kafkaTemplate;

    public ListenableFuture<String> send(String topic, String message) {
        ListenableFuture<String> listenableFuture = kafkaTemplate.send(topic, message);
        return listenableFuture;
    }
}
