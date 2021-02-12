package com.vikram.kafkajava.controller;

import com.vikram.kafkajava.consumer.TopicConsumer;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class KafkaController {

    private KafkaTemplate<String, String> kafkaTemplate;
    private static final String TOPIC = "myTopic";

    private TopicConsumer topicConsumer;

    public KafkaController(KafkaTemplate kafkaTemplate, TopicConsumer topicConsumer) {
        this.kafkaTemplate = kafkaTemplate;
        this.topicConsumer = topicConsumer;
    }

    @GetMapping("/kafka/produce")
    public void produce(@RequestParam String message) {
        kafkaTemplate.send(TOPIC, message);
    }

    @GetMapping("/kafka/messages")
    public List<String> getMessage() {
        return topicConsumer.getMessages();
    }
}
