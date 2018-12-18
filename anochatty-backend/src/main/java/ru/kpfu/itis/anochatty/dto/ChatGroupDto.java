package ru.kpfu.itis.anochatty.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class ChatGroupDto implements Serializable {
    private Long senderUserId;
    private Long receiverUserId;
    private String chatId;
}
