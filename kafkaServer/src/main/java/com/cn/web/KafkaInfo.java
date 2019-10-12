package com.cn.web;

import com.cn.kafka.KafkaProducer;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/kafkainfo")
@Log4j2
public class KafkaInfo {
    @Autowired
    private KafkaProducer kafkaProducer;

    @RequestMapping("/send/{topic}/{num}")
    public String kafkaSend(@PathVariable("topic") String topic, @PathVariable("num") int num) {
        for (int i = 0; i < num; ++i) {
            String message = UUID.randomUUID().toString();
            ListenableFuture<String> listenableFuture = kafkaProducer.send(topic, message);
            listenableFuture.addCallback(
                    result -> log.debug(result),
                    throwable -> log.error(throwable));

        }
        return "success";
    }
}
