package ru.kpfu.itis.anochatty.controller.ws;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import ru.kpfu.itis.anochatty.dto.ChatGroupDto;

@Controller
public class ChatWebSocketController {

    private final SimpMessagingTemplate messagingTemplate;

    public ChatWebSocketController(SimpMessagingTemplate messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
    }

    @MessageMapping("/startChat")
    @SendTo("/startChat")
    public ChatGroupDto startChat(ChatGroupDto chatGroupDto) {
        return chatGroupDto;
    }

    @MessageMapping("/startChatAccept")
    @SendTo("/startChatAccept")
    public ChatGroupDto startChatAccept(ChatGroupDto chatGroupDto) {
        return chatGroupDto;
    }

    @MessageMapping("/startChatDismiss")
    @SendTo("/startChatDismiss")
    public ChatGroupDto startChatDismiss(ChatGroupDto chatGroupDto) {
        return chatGroupDto;
    }

    @MessageMapping("/chatGroup/{chatId}")
    @SendTo("/chatGroup/{chatId}")
    public ChatGroupDto chatGroup(ChatGroupDto chatGroupDto) {
        return chatGroupDto;
    }
}
