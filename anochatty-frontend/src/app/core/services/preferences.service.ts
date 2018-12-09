import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {BASE_URL} from "../../../environments/environment";
import {Observable} from "rxjs";
import {Food, Movie, Music} from "../model/preferences.model";

const PREFERENCES_URL = '/preferences';

@Injectable({
  providedIn: 'root'
})
export class PreferencesService {

  constructor(private http: HttpClient) {
  }

  getMovies(): Observable<Movie[]> {
    return this.http.get(BASE_URL + PREFERENCES_URL + '/movies');
  }

  getFood(): Observable<Food[]>  {
    return this.http.get(BASE_URL + PREFERENCES_URL + '/food');
  }

  getMusic(): Observable<Music[]>  {
    return this.http.get(BASE_URL + PREFERENCES_URL + '/music');
  }
}
