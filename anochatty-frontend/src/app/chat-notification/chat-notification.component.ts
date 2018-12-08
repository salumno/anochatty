import { Component, OnInit } from '@angular/core';
import * as Stomp from 'stompjs';
import * as SockJS from 'sockjs-client';
import {SOCKET_CONNECTION_URL} from "../core/model/socket-data";
import {ChatGroupInfo} from "../core/model/chat-group";
import {UserService} from "../core/services/user.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-chat-notification',
  templateUrl: './chat-notification.component.html',
  styleUrls: ['./chat-notification.component.scss']
})



export class ChatNotificationComponent implements OnInit {

  isStartChatNotificationVisible = false;
  currentChatGroupInfo: ChatGroupInfo;

  private isUserBuzy = false;
  private stompClient = null;

  constructor(private userService: UserService, private router: Router) { }

  ngOnInit() {
    this.connectToChatSocket();
  }

  connectToChatSocket() {
    const socket = new SockJS(SOCKET_CONNECTION_URL);
    this.stompClient = Stomp.over(socket);

    const that = this;
    this.stompClient.connect({}, frame => {
      that.stompClient.subscribe('/startChat', (chatGroupInfo: ChatGroupInfo) => {
        if (!this.isUserBuzy && chatGroupInfo.receiverUserId === this.userService.getUserId()) {
          this.isStartChatNotificationVisible = true;
          this.isUserBuzy = true;
          this.currentChatGroupInfo = chatGroupInfo;
        }
      })
    });
  }

  acceptStartChat() {
    this.stompClient.send('/anochatty/startChatAccept', {}, this.currentChatGroupInfo);
    this.isUserBuzy = false;
    this.currentChatGroupInfo = undefined;
    this.router.navigate(['/chat', this.currentChatGroupInfo.chatId])
  }

  dismissStartChat() {
    this.stompClient.send('/anochatty/startChatDismiss', {}, this.currentChatGroupInfo);
    this.isUserBuzy = false;
    this.currentChatGroupInfo = undefined;
  }

}
