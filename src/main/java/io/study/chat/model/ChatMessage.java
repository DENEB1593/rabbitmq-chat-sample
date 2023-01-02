package io.study.chat.model;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.time.LocalDateTime;

public class ChatMessage {

  private String id;

  private String content;

  private LocalDateTime sendDate;

  public ChatMessage() { }

  public ChatMessage(String id, String content, LocalDateTime sendDate) {
    this.id = id;
    this.content = content;
    this.sendDate = sendDate;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public LocalDateTime getSendDate() {
    return sendDate;
  }

  public void setSendDate(LocalDateTime sendDate) {
    this.sendDate = sendDate;
  }

  @Override
  public String toString() {
    return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
      .append("id", id)
      .append("content", content)
      .append("sendDate", sendDate)
      .toString();
  }
}
