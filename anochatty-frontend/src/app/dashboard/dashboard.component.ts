import { Component, OnInit, ViewChild } from '@angular/core';
import * as SockJS from 'sockjs-client';
import { SOCKET_CONNECTION_URL } from '../core/model/socket-data';
import * as Stomp from 'stompjs';
import { ChatGroupInfo } from '../core/model/chat-group.model';
import { UserService } from '../core/services/user.service';
import { User } from '../core/model/user.model';
import { ChatComponent } from '../chat/chat.component';
import { UUID } from 'angular2-uuid';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.scss']
})
export class DashboardComponent implements OnInit {

  @ViewChild(ChatComponent)
  chatComponent: ChatComponent;

  currentChatGroupInfo: ChatGroupInfo;
  users: User[];
  selectedUser: User;

  message: string;
  isStartChatNotificationVisible = false;
  isUserWaitAnswer = false;

  isChatVisible = false;

  private isUserBusy = false;
  private stompClient = null;

  constructor(private userService: UserService) {
  }

  ngOnInit() {
    this.connectToChatSocket();
    this.userService.getRecommendedUsers().subscribe(
      (users: User[]) => this.users = users
    );
  }

  connectToChatSocket() {
    const socket = new SockJS(SOCKET_CONNECTION_URL);
    this.stompClient = Stomp.over(socket);

    const that = this;
    this.stompClient.connect({}, frame => {
      that.stompClient.subscribe('/startChat', message => {
        const chatGroupInfo: ChatGroupInfo = JSON.parse(message.body);
        if (!this.isUserBusy && chatGroupInfo.receiverUserId === this.userService.getUserId()) {
          this.isStartChatNotificationVisible = true;
          this.isUserBusy = true;
          this.currentChatGroupInfo = chatGroupInfo;
        }
      })
    });
  }

  acceptStartChat() {
    const senderNickname = this.currentChatGroupInfo.senderNickname;
    this.currentChatGroupInfo.senderNickname = this.userService.getUserNickname();
    this.stompClient.send('/anochatty/startChatAccept', {}, JSON.stringify(this.currentChatGroupInfo));
    this.isUserBusy = false;
    this.isChatVisible = true;
    this.chatComponent.startChat(this.stompClient, this.currentChatGroupInfo.chatId, senderNickname);
    this.currentChatGroupInfo = undefined;
    this.isStartChatNotificationVisible = false;
  }

  dismissStartChat() {
    this.stompClient.send('/anochatty/startChatDismiss', {}, JSON.stringify(this.currentChatGroupInfo));
    this.isUserBusy = false;
    this.currentChatGroupInfo = undefined;
    this.isStartChatNotificationVisible = false;
  }

  startChat() {
    const chatGroupInfo = this.createStartChatGroupInfo();
    if (this.stompClient.connected) {
      this.stompClient.send('/anochatty/startChat', {}, JSON.stringify(chatGroupInfo));
      this.isUserWaitAnswer = true;
      this.stompClient.subscribe('/startChatAccept', message => {
        const chatGroupInfo: ChatGroupInfo = JSON.parse(message.body);
        if (this.isUserWaitAnswer && chatGroupInfo.senderUserId === this.userService.getUserId()) {
          this.isUserWaitAnswer = false;
          this.isChatVisible = true;
          this.chatComponent.startChat(this.stompClient, chatGroupInfo.chatId, chatGroupInfo.senderNickname);
        }
      });
      this.stompClient.subscribe('/startChatDismiss', message => {
        const chatGroupInfo: ChatGroupInfo = JSON.parse(message.body);
        if (this.isUserWaitAnswer && chatGroupInfo.senderUserId === this.userService.getUserId()) {
          this.isUserWaitAnswer = false;
          this.message = 'The user dismissed chat :('
        }
      });
    }
  }

  closeChat() {
    this.isChatVisible = false;
  }

  getChatSenderUsername(): string {
    if (this.currentChatGroupInfo) {
      return this.currentChatGroupInfo.senderNickname;
    }
    return "Anonymous";
  }

  private createStartChatGroupInfo() {
    return {
      senderUserId: this.userService.getUserId(),
      senderNickname: this.userService.getUserNickname(),
      receiverUserId: this.selectedUser.id,
      chatId: this.generateChatId()
    } as ChatGroupInfo;
  }

  private generateChatId(): string {
    return UUID.UUID();
  }
}
