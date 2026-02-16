package com.example.chatapp.consumer;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import com.example.chatapp.dto.ChatMessage;

@Service
public class ChatConsumer {

  @Autowired
  private SimpMessagingTemplate messagingTemplate;

  @KafkaListener(topics = "chat-messages", groupId = "chat-group")
  public void consume(ChatMessage message,  Acknowledgment ack) {

    try {
      System.out.println("Consumed: " + message.getContent());
      messagingTemplate.convertAndSend("/topic/messages", message);

      // Process message (save to DB, push to WebSocket, etc.)

      ack.acknowledge(); // commit offset ONLY if successful
    } catch (Exception e) {
      // do NOT acknowledge → Kafka will retry
      throw e;
    }
  }

//  @KafkaListener(topics = "chat-messages", groupId = "chat-group")
//  public void consume(ChatMessage message) {
//    System.out.println("Received: " + message.getContent());
//    // Later: push to WebSocket
//  }
}