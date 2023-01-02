package io.study.chat.controller;

import io.study.chat.model.ChatMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {

  private final static Logger logger = LoggerFactory.getLogger(ChatController.class);

  @MessageMapping("/send")
  @SendTo("/topic/deneb-chat")
  public ChatMessage send(@Payload ChatMessage chatMessage) {
    logger.info("send : {}", chatMessage);
    return chatMessage;
  }

  @MessageMapping("/join")
  @SendTo("/topic/deneb-chat")
  public ChatMessage join(@Payload ChatMessage chatMessage,
                          SimpMessageHeaderAccessor headerAccessor) {
    headerAccessor.getSessionAttributes().put("username", chatMessage.getId());
    logger.info("join : {}", chatMessage);
    return chatMessage;
  }


}
