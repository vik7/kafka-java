package com.vikram.kafkajava.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TopicConsumer {

    private final static String TOPIC = "myTopic";
    private final static String GROUP_ID = "kafka-group-id-1";

    private final List<String> messages = new ArrayList<>();


    @KafkaListener(topics = TOPIC, groupId = GROUP_ID)
    private void listen(String message) {
        synchronized (message) {
            messages.add(message);
        }
    }

    public List<String> getMessages() {
        return messages;
    }

}
