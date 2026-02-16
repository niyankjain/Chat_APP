package com.example.chatapp.producer;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.example.chatapp.dto.ChatMessage;

@Service
public class ChatProducer {

  private final KafkaTemplate<String, ChatMessage> kafkaTemplate;

  public ChatProducer(KafkaTemplate<String, ChatMessage> kafkaTemplate) {
    this.kafkaTemplate = kafkaTemplate;
  }

  public void sendMessage(ChatMessage message) {
    kafkaTemplate.send("chat-messages", message);
  }
}
