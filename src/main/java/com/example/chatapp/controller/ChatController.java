package com.example.chatapp.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.chatapp.dto.ChatMessage;
import com.example.chatapp.producer.ChatProducer;

@RestController
@RequestMapping("/chat")
public class ChatController {

  private final ChatProducer producer;

  public ChatController(ChatProducer producer) {
    this.producer = producer;
  }

  @PostMapping("/send")
  public ResponseEntity<String> send(@RequestBody ChatMessage message) {
    producer.sendMessage(message);
    return ResponseEntity.ok("Message sent");
  }
}
