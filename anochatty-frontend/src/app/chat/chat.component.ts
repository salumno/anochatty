import { Component } from '@angular/core';
import { ChatMessage, WebSocketChatMessage } from '../core/model/chat-message.model';
import { UserService } from '../core/services/user.service';

@Component({
  selector: 'app-chat',
  templateUrl: './chat.component.html',
  styleUrls: ['./chat.component.scss']
})
export class ChatComponent {
  isChatVisible = false;

  messages: ChatMessage[] = [];
  currentUserMessage: string;

  private stompClient;
  private chatId: string;

  constructor(private userService: UserService) {}

  startChat(stompClient, chatId: string) {
    this.stompClient = stompClient;
    this.chatId = chatId;
    if (stompClient.connected) {
      this.isChatVisible = true;
      this.stompClient.subscribe(`/chatGroup/${this.chatId}`, message => {
        const messageObject: WebSocketChatMessage = JSON.parse(message.body);
        if (messageObject.senderId != this.userService.getUserId()) {
          this.renderReceivedMessage(messageObject.message);
        }
      });
    }
  }

  sendMessage() {
    const messageObject = {
      senderId: this.userService.getUserId(),
      message: this.currentUserMessage
    } as WebSocketChatMessage;
    this.stompClient.send(`/anochatty/chatGroup/${this.chatId}`, {}, JSON.stringify(messageObject));
    this.renderSentMessage();
    this.currentUserMessage = undefined;
  }

  closeChat() {
    this.isChatVisible = false;
  }

  private renderReceivedMessage(message: string) {
    const chatMessage = {message: message, isReceived: true} as ChatMessage;
    this.messages.push(chatMessage);
  }

  private renderSentMessage() {
    const chatMessage = {message: this.currentUserMessage, isReceived: false} as ChatMessage;
    this.messages.push(chatMessage);
  }

}
