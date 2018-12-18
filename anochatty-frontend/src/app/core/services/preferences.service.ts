import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { BASE_URL } from '../../../environments/environment';

const PREFERENCES_URL = '/preferences';

@Injectable({
  providedIn: 'root'
})
export class PreferencesService {

  constructor(private http: HttpClient) {
  }

  getMovies() {
    return this.http.get(BASE_URL + PREFERENCES_URL + '/movies');
  }

  getFood() {
    return this.http.get(BASE_URL + PREFERENCES_URL + '/food');
  }

  getMusic() {
    return this.http.get(BASE_URL + PREFERENCES_URL + '/music');
  }
}
