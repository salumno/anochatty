import { Component, OnInit } from '@angular/core';
import { PreferencesService } from '../core/services/preferences.service';
import { UserService } from '../core/services/user.service';
import { UserSignUpForm } from '../core/model/auth.model';
import { Router } from '@angular/router';

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.scss']
})
export class RegistrationComponent implements OnInit {

  preferenceOptions: Preference[];

  nickname: string;
  password: string;

  successMessage: string;
  errorMessage: string;

  constructor(private preferencesService: PreferencesService,
              private userService: UserService,
              private router: Router) {
  }

  ngOnInit() {
    this.preferencesService.getPreferences().subscribe(preferenceOptions => {
      this.preferenceOptions = preferenceOptions;
    });
  }

  confirmSuccessRegistration() {
    this.successMessage = undefined;
    this.goToLoginPage();
  }

  signUp() {
    if (this.isValid()) {
      const signUpForm = this.createSignUpForm();
      this.userService.signUp(signUpForm).subscribe(
        () => this.successMessage = 'Successful registration!',
        () => this.errorMessage = 'Please check your nickname. It is already in use.'
      );
    } else {
      this.errorMessage = 'Check your fields! Rating must be a value between 0 and 100.';
    }
  }

  goToLoginPage() {
    this.router.navigate(['login']);
  }

  private isValid() {
    const invalidRatedPreferences = this.preferenceOptions.filter(
      preference => preference.rating && (preference.rating < 0 || preference.rating > 100));
    return this.nickname && this.password && !invalidRatedPreferences.length;
  }

  private createSignUpForm(): UserSignUpForm {
    return {
      nickname: this.nickname,
      password: this.password,
      ratedPreferences: this.preferenceOptions
    } as UserSignUpForm;
  }
}
