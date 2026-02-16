package com.example.chatapp.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class ChatMessage {
  private String sender;
  private String receiver;
  private String content;
  private LocalDateTime timestamp;
}