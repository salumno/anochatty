import { Food, Movie, Music } from './preferences.model';

export class UserSignUpForm {
  nickname: string;
  password: string;
  userPreferences: {
    movies: Movie[];
    food: Food[];
    music: Music[];
  };
}

export class UserSighInForm {
  nickname: string;
  password: string;
}
