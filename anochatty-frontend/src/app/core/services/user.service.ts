import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { BASE_URL } from '../../../environments/environment';
import { UserSighInForm, UserSignUpForm } from '../model/auth.model';
import { User } from '../model/user.model';

const AUTH_URL = '/auth';
const RECOMMENDATION_URL = '/recommendation';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  readonly userIdKey = 'userId';
  readonly userNicknameKey = 'userNickname';

  constructor(private http: HttpClient) {
  }

  getUserId(): number {
    return Number(localStorage.getItem(this.userIdKey));
  }

  getUserNickname(): string {
    return localStorage.getItem(this.userNicknameKey);
  }

  saveUserData(user: User) {
    localStorage.setItem(this.userIdKey, String(user.id));
    localStorage.setItem(this.userNicknameKey, user.nickname);
  }

  isAuthenticated(): boolean {
    return !!this.getUserNickname();
  }

  signIn(signInForm: UserSighInForm) {
    return this.http.post(BASE_URL + AUTH_URL + '/sign-in', signInForm);
  }

  signUp(signUpForm: UserSignUpForm) {
    return this.http.post(BASE_URL + AUTH_URL + '/sign-up', signUpForm);
  }

  getRecommendedUsers() {
    return this.http.post(BASE_URL + RECOMMENDATION_URL, {userID: this.getUserId()});
  }

  sendDataToAnalyze(messages: string) {
    const userId = this.getUserId();
    return this.http.post(BASE_URL + RECOMMENDATION_URL + '/analyze', {userId, messages});
  }
}
