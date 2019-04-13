package ru.kpfu.itis.anochatty.controller.ws;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class ChatWebSocketController {

    private final SimpMessagingTemplate messagingTemplate;

    @Autowired
    public ChatWebSocketController(SimpMessagingTemplate messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
    }

    @MessageMapping("/startChat")
    @SendTo("/startChat")
    public String startChat(String chatGroupDto) {
        return chatGroupDto;
    }

    @MessageMapping("/startChatAccept")
    @SendTo("/startChatAccept")
    public String startChatAccept(String chatGroupDto) {
        return chatGroupDto;
    }

    @MessageMapping("/startChatDismiss")
    @SendTo("/startChatDismiss")
    public String startChatDismiss(String chatGroupDto) {
        return chatGroupDto;
    }

    @MessageMapping("/chatGroup/{chatId}")
    @SendTo("/chatGroup/{chatId}")
    public String processMessage(String message) {
        return message;
    }

    @MessageMapping("/endChat/{chatId}")
    @SendTo("/endChat/{chatId}")
    public String endChat(String message) {
        return message;
    }
}
