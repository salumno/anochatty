import { Component, EventEmitter, Input, Output } from '@angular/core';

@Component({
  selector: 'app-chat-notification',
  templateUrl: './chat-notification.component.html',
  styleUrls: ['./chat-notification.component.scss']
})

export class ChatNotificationComponent {
  @Input() isVisible: boolean;
  @Input() senderNickname: string;

  @Output() acceptStartChat = new EventEmitter();
  @Output() dismissStartChat = new EventEmitter();
}
