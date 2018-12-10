package ru.kpfu.itis.anochatty.dto;

import lombok.Data;

@Data
public class ChatGroupDto {
    private Long senderUserId;
    private Long receiverUserId;
    private String chatId;
}
