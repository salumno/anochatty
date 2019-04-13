import { Component, EventEmitter, Output } from '@angular/core';
import { ChatMessage, WebSocketChatMessage } from '../core/model/chat-message.model';
import { UserService } from '../core/services/user.service';

@Component({
  selector: 'app-chat',
  templateUrl: './chat.component.html',
  styleUrls: ['./chat.component.scss']
})
export class ChatComponent {
  @Output() closeChat = new EventEmitter();

  senderNickname: string;

  isChatVisible = false;

  messages: ChatMessage[] = [];
  userMessages: string;
  currentUserMessage: string;

  private stompClient;
  private chatId: string;

  endChatNotificationMessage: string;

  constructor(private userService: UserService) {
  }

  startChat(stompClient, chatId: string, senderNickname: string) {
    this.stompClient = stompClient;
    this.chatId = chatId;
    this.senderNickname = senderNickname;
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
          this.showEndChatNotificationDialog();
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
    this.updateUserMessages();
    this.renderSentMessage();
    this.currentUserMessage = undefined;
  }

  stopChat() {
    const messageObject = {
      senderId: this.userService.getUserId(),
      message: 'Chat is over.'
    } as WebSocketChatMessage;
    this.stompClient.send(`/anochatty/endChat/${this.chatId}`, {}, JSON.stringify(messageObject));
    this.sendDataToAnalyzeAndClose();
  }

  private sendDataToAnalyzeAndClose() {
    this.userService.sendDataToAnalyze(this.userMessages).subscribe(() => {
      this.isChatVisible = false;
      this.closeChat.emit();
    });
  }

  private renderReceivedMessage(message: string) {
    const chatMessage = {message: message, isReceived: true} as ChatMessage;
    this.messages.push(chatMessage);
  }

  private renderSentMessage() {
    const chatMessage = {message: this.currentUserMessage, isReceived: false} as ChatMessage;
    this.messages.push(chatMessage);
  }

  private updateUserMessages() {
    if (this.userMessages) {
      this.userMessages += this.currentUserMessage + '.';
    } else {
      this.userMessages = this.currentUserMessage + '.';
    }
  }

  private showEndChatNotificationDialog() {
    this.endChatNotificationMessage = 'Your fella ended the chat';
  }

  closeChatWindow() {
    this.endChatNotificationMessage = undefined;
    this.sendDataToAnalyzeAndClose();
  }
}
