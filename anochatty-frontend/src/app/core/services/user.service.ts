import { Injectable } from '@angular/core';
import {User} from "../model/user";

@Injectable({
  providedIn: 'root'
})
export class UserService {

  readonly userIdKey = 'userId';
  readonly userNicknameKey = 'userNickname';

  constructor() { }

  getUserId() {
    return localStorage.getItem(this.userIdKey);
  }

  getUserNickname() {
    return localStorage.getItem(this.userNicknameKey);
  }

  saveUserData(user: User) {
    localStorage.setItem(this.userIdKey, user.id);
    localStorage.setItem(this.userNicknameKey, user.nickname);
  }

}
