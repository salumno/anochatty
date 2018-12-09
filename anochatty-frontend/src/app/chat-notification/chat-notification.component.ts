import {Component, EventEmitter, Output} from '@angular/core';

@Component({
  selector: 'app-chat-notification',
  templateUrl: './chat-notification.component.html',
  styleUrls: ['./chat-notification.component.scss']
})

export class ChatNotificationComponent {
  @Output() acceptStartChat = new EventEmitter();
  @Output() dismissStartChat = new EventEmitter();
}
