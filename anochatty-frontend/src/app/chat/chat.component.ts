import { Component } from '@angular/core';

@Component({
  selector: 'app-chat',
  templateUrl: './chat.component.html',
  styleUrls: ['./chat.component.scss']
})
export class ChatComponent {
  isChatVisible = false;

  private stompClient;
  private chatId: string;
  private message: string;

  startChat(stompClient, chatId: string) {
    this.stompClient = stompClient;
    this.chatId = chatId;
    if (stompClient.isConnected) {
      this.isChatVisible = false;
      this.stompClient.subscribe(`/chat/${this.chatId}`, (message: string) => {
        console.log('received message: ', message);
        this.renderReceivedMessage();
      });
    }
  }

  sendMessage() {
    this.stompClient.send(`/anochatty/chat/${this.chatId}`, {}, this.message);
    this.renderSentMessage();
  }

  closeChat() {
    this.isChatVisible = false;
  }

  private renderReceivedMessage() {
    //todo
  }

  private renderSentMessage() {
    //todo
  }
}
