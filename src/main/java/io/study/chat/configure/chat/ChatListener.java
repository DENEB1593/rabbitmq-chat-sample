package io.study.chat.configure.chat;

import io.study.chat.model.ChatMessage;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

@Component
public class ChatListener {

  private SimpMessageSendingOperations messageSendingOperations;

  public ChatListener(SimpMessageSendingOperations messageSendingOperations) {
    this.messageSendingOperations = messageSendingOperations;
  }

  @EventListener
  public void handleWebSocketDisconnectListener(SessionDisconnectEvent event) {
    StompHeaderAccessor headerAccessor = StompHeaderAccessor.wrap(event.getMessage());
    String username = (String) headerAccessor.getSessionAttributes().get("username");
    if(username != null) {
      ChatMessage chatMessage = new ChatMessage();
      messageSendingOperations.convertAndSend("/topic/public", chatMessage);
    }
  }

}
