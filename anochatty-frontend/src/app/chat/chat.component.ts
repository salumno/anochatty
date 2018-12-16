import { Component } from '@angular/core';
import { ChatMessage } from '../core/model/chat-message.model';

@Component({
  selector: 'app-chat',
  templateUrl: './chat.component.html',
  styleUrls: ['./chat.component.scss']
})
export class ChatComponent {
  isChatVisible = false;

  messages: ChatMessage[];
  currentUserMessage: string;

  private stompClient;
  private chatId: string;

  startChat(stompClient, chatId: string) {
    this.stompClient = stompClient;
    this.chatId = chatId;
    if (stompClient.isConnected) {
      this.isChatVisible = true;
      this.stompClient.subscribe(`/chat/${this.chatId}`, (message: string) => {
        console.log('received message: ', message);
        this.renderReceivedMessage(message);
      });
    }
  }

  sendMessage() {
    this.stompClient.send(`/anochatty/chat/${this.chatId}`, {}, this.currentUserMessage);
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
