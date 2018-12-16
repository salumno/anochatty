import { Component, OnInit } from '@angular/core';
import { PreferencesService } from '../core/services/preferences.service';
import { UserService } from '../core/services/user.service';
import { UserSignUpForm } from '../core/model/auth.model';
import { Router } from '@angular/router';
import { Food, Movie, Music } from '../core/model/preferences.model';
import { SelectItem } from 'primeng/api';

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.scss']
})
export class RegistrationComponent implements OnInit {

  ratingOptions: SelectItem[];

  musicOptions: Music[];
  foodOptions: Food[];
  movieOptions: Movie[];

  nickname: string;
  password: string;

  successMessage: string;
  errorMessage: string;

  constructor(private preferencesService: PreferencesService,
              private userService: UserService,
              private router: Router) {
  }

  ngOnInit() {
    this.ratingOptions = [
      {label: '1', value: 1},
      {label: '2', value: 2},
      {label: '3', value: 3},
      {label: '4', value: 4},
      {label: '5', value: 5},
    ];
    this.preferencesService.getFood().subscribe(food => {
      this.foodOptions = food;
    });
    this.preferencesService.getMovies().subscribe(movies => {
      this.movieOptions = movies;
    });
    this.preferencesService.getMusic().subscribe(music => {
      this.musicOptions = music;
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
      this.errorMessage = 'Check your fields!';
    }
  }

  goToLoginPage() {
    this.router.navigate(['/login']);
  }

  private isValid() {
    return this.nickname && this.password;
  }

  private createSignUpForm(): UserSignUpForm {
    return {
      nickname: this.nickname,
      password: this.password,
      userPreferences: {
        movies: this.movieOptions,
        food: this.foodOptions,
        music: this.musicOptions
      }
    } as UserSignUpForm;
  }
}
