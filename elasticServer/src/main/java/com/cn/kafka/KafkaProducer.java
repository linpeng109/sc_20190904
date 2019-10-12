package com.cn.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;

@Service
public class KafkaProducer {
    @Autowired
    private KafkaTemplate kafkaTemplate;

    public ListenableFuture<String> send(String topic, String message) {
        ListenableFuture<String> listenableFuture = kafkaTemplate.send(topic, message);
        return listenableFuture;
    }
}
