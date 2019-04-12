import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { BASE_URL } from '../../../environments/environment';
import { Observable } from 'rxjs';

const PREFERENCES_URL = '/preferences';

@Injectable({
  providedIn: 'root'
})
export class PreferencesService {

  constructor(private http: HttpClient) {
  }

  getPreferences(): Observable<Preference[]> {
    return this.http.get<Preference[]>(BASE_URL + PREFERENCES_URL);
  }
}
