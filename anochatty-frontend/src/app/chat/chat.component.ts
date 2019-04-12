import { Component } from '@angular/core';
import { ChatMessage, WebSocketChatMessage } from '../core/model/chat-message.model';
import { UserService } from '../core/services/user.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-chat',
  templateUrl: './chat.component.html',
  styleUrls: ['./chat.component.scss']
})
export class ChatComponent {
  isChatVisible = false;

  messages: ChatMessage[] = [];
  userMessages: string;
  currentUserMessage: string;

  private stompClient;
  private chatId: string;

  constructor(private userService: UserService, private router: Router) {
  }

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
      this.stompClient.subscribe(`/endChat/${this.chatId}`, message => {
        const messageObject: WebSocketChatMessage = JSON.parse(message.body);
        if (messageObject.senderId != this.userService.getUserId()) {
          this.endChat();
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
    this.userMessages = this.userMessages + this.currentUserMessage + '.';
    this.renderSentMessage();
    this.currentUserMessage = undefined;
  }

  stopChat() {
    const messageObject = {
      senderId: this.userService.getUserId(),
      message: 'Chat is over.'
    } as WebSocketChatMessage;
    this.stompClient.send(`/anochatty/endChat/${this.chatId}`, {}, JSON.stringify(messageObject));
    this.endChat();
  }

  private endChat() {
    this.userService.sendDataToAnalyze(this.userMessages).subscribe(() => {
      this.isChatVisible = false;
      this.router.navigate(['dashboard']);
    })
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
