import { Component } from '@angular/core';
import { UserService } from '../core/services/user.service';
import { Router } from '@angular/router';
import { UserSighInForm } from '../core/model/auth.model';
import { User } from '../core/model/user.model';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent {

  userNickname: string;
  userPassword: string;

  errorMessage: string;

  constructor(private userService: UserService, private router: Router) {
  }

  signInSubmit() {
    if (this.userNickname && this.userPassword) {
      const userSingInData = {nickname: this.userNickname, password: this.userPassword} as UserSighInForm;
      this.userService.signIn(userSingInData).subscribe(
        (user: User) => {
          this.userService.saveUserData(user);
          this.router.navigate(['dashboard']);
        },
        () => {
          this.errorMessage = 'Incorrect nickname or password';
        }
      );
    } else {
      this.errorMessage = 'All fields are required';
    }
  }
}
