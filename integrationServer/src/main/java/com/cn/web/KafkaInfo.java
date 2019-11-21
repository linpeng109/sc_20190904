package com.cn.web;

import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/kafkainfo")
public class KafkaInfo {
    @Resource(name = "inputToKafka")
    private MessageChannel inputToKafka;

    @RequestMapping("/send/{msg}")
    public boolean send(@PathVariable("msg") String msg) {
        Message message = MessageBuilder.withPayload(msg).build();
        boolean result = inputToKafka.send(message);
        return result;
    }
}
